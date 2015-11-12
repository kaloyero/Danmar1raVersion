angular
    .module('theme.demos.ng_grid', [
        'agGrid', 'theme.core.servicesFactura'
    ])
    .controller('FacturaController', ['$modal', '$scope', '$http', 'ArticuloService', 'ArticuloServiceFiltro', function($modal, $scope, $http, ArticuloService, ArticuloServiceFiltro) {
        'use strict';

        var borraProducto = true;
        var dataSource;
        var dataSourceCliente;

        var resultadoBusqueda = "";
        var modalInstance;
        var modalInstanceCliente ;


        var columnCliente = [{
            headerName: "Razon Social",
            field: "razonSocial",
            width: 150
        }];
        var columnProductos = [{
                headerName: "Articulo",
                field: "articulo",
                width: 250
            }, {
                headerName: "Codigo Prov",
                field: "codigoProv",
                width: 90
            }, {
                headerName: "Costo",
                field: "costo",
                width: 90
            }


        ];
        var columnsFactura = [{
                headerName: "Articulo",
                field: "articulo",
                width: 250
            }, {
                headerName: "Codigo Prov",
                field: "codigoProv",
                width: 90
            }, {
                headerName: "Costo",
                field: "costo",
                width: 90
            }, {
                headerName: "Cantidad",
                field: "canMaxima",
                width: 90,
                editable: true
            },

            {
                headerName: "Acciones",
                field: "total",
                width: 100,
                cellRenderer: function(params) {
                    return '<button ng-click="borrarFila(' + params.rowIndex + ')">X</button>';
                }
            },


        ];

        init();


        /*Arranque del controlador*/
        function init() {

            $scope.onKeyCliente = showClientePopup;
            $scope.borrarFila = borrarFila;
            
            //Variables que contendran la informacion para el header
            $scope.clienteSeleccionadoRazon;
            $scope.clienteSeleccionadoId;
            $scope.fechaFactura = new Date();
            $scope.subTotal;
            //Fin Variables que contendran la informacion para el header

            
            setDatasources()
            setGrids()
            setGridEvents()
            setModals()

        }
        /*Eventos de las Grillas*/

        function setGridEvents() {
            $scope.externalFilterChanged = function() {
                $scope.gridOptionsProductos.api.onFilterChanged();
            };
        }
        /*Setear Datasource*/

        function setDatasources() {
            dataSource = {
                rowCount: null, // behave as infinite scroll
                pageSize: 50,
                overflowSize: 50,
                maxConcurrentRequests: 2,
                maxPagesInCache: 2,
                getRows: function(params) {
                    $scope.openDemoModal('lg');
                    console.log('asking for ' + params.startRow + ' to ' + params.endRow);

                    var start = params.startRow + 1;
                    $.ajax({
                        type: 'POST',
                        url:'http://localhost:8080/DanmarWeb/articulo/searchByFiltros',
                        contentType : "application/json",
            			data :  JSON.stringify(getFiltroBusqueda(params.startRow,params.endRow)),
            		    dataType: 'json',

                       // url: 'http://localhost:8080/DanmarWeb/articulo/findAll/' + start + '/' + params.endRow,

                        success: function(data) {
                            resultadoBusqueda = JSON.parse(angular.toJson(data))
                            modalInstance.close();
                            var rowsThisPage = resultadoBusqueda.slice(params.startRow, params.endRow);
                            var lastRow = -1;

                            params.successCallback(rowsThisPage, lastRow);

                        }
                    });
                }
            }

            dataSourceCliente = {
                rowCount: null, // behave as infinite scroll
                pageSize: 50,
                overflowSize: 50,
                maxConcurrentRequests: 2,
                maxPagesInCache: 2,
                getRows: function(params) {
                    //$scope.openDemoModal('lg');
                    console.log('asking for ' + params.startRow + ' to ' + params.endRow);

                    var start = params.startRow + 1;
                    $.ajax({
                        type: 'GET',
                         url: 'http://localhost:8080/DanmarWeb/cliente/findAll/' + start + '/' + params.endRow,
                        //url:'http://localhost:8080/DanmarWeb/articulo/searchByFiltros',
                        //contentType : "application/json",
            			//data : getFiltroBusqueda(start,params.endRow),
                        success: function(data) {
                            resultadoBusqueda = JSON.parse(angular.toJson(data))
                            var rowsThisPage = resultadoBusqueda.slice(params.startRow, params.endRow);
                            var lastRow = -1;

                            params.successCallback(rowsThisPage, lastRow);

                        }
                    });
                }
            };
        }
        /*Setear Modals*/

        function setModals() {
            $scope.openDemoModal = function(size) {
                modalInstance = $modal.open({
                    templateUrl: 'modalTardanza.html',
                    backdrop: 'static',
                    controller: function($scope, $modalInstance) {
                        $scope.cancel = function() {
                            $modalInstance.dismiss('cancel');
                        };
                    },
                    size: size,
                });
            }
            $scope.openDemoModalCliente = function(size) {
                modalInstanceCliente = $modal.open({
                    templateUrl: 'modalBuscadorCliente.html',
                    backdrop: 'static',
                    scope: $scope,
                    controller: function($scope, $modalInstance) {
                        $scope.cancel = function() {
                            $modalInstance.dismiss('cancel');
                        };
                    },
                    size: size,
                });
            }
        }

        /*Inicializar las grillas*/

        function setGrids() {
            $scope.gridOptionsProductos = {
                columnDefs: columnProductos,
                rowSelection: 'multiple',
                rowData: null,
                enableFilter: true,
                enableServerSideFilter: true,
                virtualPaging: true, // this is important, if not set, normal paging will be done
                onSelectionChanged: seleccionCambiada,
                ready: function(api) {
                    console.log("LISTO")
                    $scope.gridOptionsProductos.api.setDatasource(dataSource);
                }
            };

            $scope.gridOptionsCliente = {
                columnDefs: columnCliente,
                rowSelection: 'multiple',
                rowData: null,
                enableFilter: true,
                enableServerSideFilter: true,
                virtualPaging: true,
                onSelectionChanged: seleccionClienteCambiada,

                ready: function(api) {
                    $scope.gridOptionsCliente.api.setDatasource(dataSourceCliente);
                }
            };

            $scope.gridOptionsFactura = {
                columnDefs: columnsFactura,
                rowSelection: 'single',
                rowData: null,
                enableFilter: true,
                onCellValueChanged: valorCeldaCambiado,
                angularCompileRows: true
            };
        }


        /*****Eventos Grillas*******/

        function rowDeselectedFunc(event) {
            // console.log("row " , event.node.data.athlete , " de-selected");
        }

        function valorCeldaCambiado() {
            // after a value changes, get the volatile cells to update
            calculateSubtotal()
        }

        /*function rowSelectedFunc(event) {
                	  	$scope.seleccionados=$scope.gridOptionsProductos.api.getSelectedRows()
                  }*/
        function seleccionCambiada(event) {
            if (borraProducto == true) {

                var clonedArray = JSON.parse(JSON.stringify($scope.gridOptionsProductos.api.getSelectedRows()))
                $scope.gridOptionsFactura.api.setRowData(clonedArray);
                calculateSubtotal()
            }
            borraProducto = true

        }
        function seleccionClienteCambiada(event) {
            console.log("event",event)
            modalInstanceCliente.close();
            //Seteamos el valor del cliente elegido

            $scope.clienteSeleccionadoRazon =event.selectedRows[0].razonSocial;
            //$scope.clienteSeleccionadoId = ?
        }

        //Se elimina el producto en la grilla de Factura y se deseleccionda el producto en la Grillas de "Productos",se pone
        // en boolean la variable borraProducto,porque al momento que deseleccionamos en la grilla de Productos el elemento,se llama
        //automaticamente y por el plugin,el metodo seleccionCambiada ,y no queremos que ejecute nada dentro.
        function borrarFila(data) {

            var nombreArticuloEliminar = $scope.gridOptionsFactura.rowData[data].articulo

            var arrayNodes = jQuery.extend({}, $scope.gridOptionsProductos.api.getSelectedNodes());
            var producto;


            for (producto in arrayNodes) {
                if (nombreArticuloEliminar === arrayNodes[producto].data.articulo) {

                    borraProducto = false;

                }

            }
            $scope.gridOptionsProductos.api.forEachNode(function(node) {

                if (node.data.articulo === nombreArticuloEliminar) {
                    $scope.gridOptionsProductos.api.selectionController.deselectNode(node);
                }
            });
            $scope.gridOptionsFactura.rowData.splice(data, 1);

            var newArray = $scope.gridOptionsFactura.rowData
            $scope.gridOptionsFactura.api.setRowData(newArray); //Investigar refrescar y no hacer esto
            //calculateSubtotal()
        }

        /*****FIN Eventos Grillas*******/

        /*****Calculos*******/
        function calculateSubtotal() {
            var producto;
            var subTotal = 0;
            console.log("DATA", $scope.gridOptionsFactura)
            for (producto in $scope.gridOptionsFactura.rowData) {
                subTotal = subTotal + (parseInt($scope.gridOptionsFactura.rowData[producto].canMaxima) * parseInt($scope.gridOptionsFactura.rowData[producto].costo));
            }
            $scope.subTotal = subTotal
            $scope.$apply();
        }

        /*****Otros*******/

        function showClientePopup(event) {
            $scope.openDemoModalCliente('lg');
        }


        function getFiltroBusqueda(start, end) {
            var filtro = new Object();
            filtro.cc1 = $scope.codigo1;
            filtro.cc2 = $scope.codigo2;
            filtro.cc3=$scope.codigo3;
            filtro.pagina = start + 1;
            filtro.articulo = $scope.articulo;
            filtro.cantRegistros = end;
            return filtro;
        }


        //ArticuloService.query(null,function(data) {

        //var articulos=JSON.parse(angular.toJson(data))


        //$scope.gridOptionsProductos.api.setRowData(articulos);

        // } );




    }]);