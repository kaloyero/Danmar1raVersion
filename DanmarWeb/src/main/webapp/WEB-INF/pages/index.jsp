<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Danmar V1.0</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Maverick">
	<meta name="author" content="nDevr Studios & The Red Team">

	<link rel="icon" type="image/png" href="favicon.png">

	<!-- prochtml:remove:dist -->
	<link href="static/app/assets/less/styles.less" rel="stylesheet/less" media="all"> 
	<!-- /prochtml -->

	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>     

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries. Placeholdr.js enables the placeholder attribute -->
	<!--[if lte IE 9]>
	  <link rel="stylesheet" href="static/app/assets/css/ie8.css">
	  <script type="text/javascript" src="static/app/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	  <script type="text/javascript" src="static/app/http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.1.0/respond.min.js"></script>
	  <script type="text/javascript" src="static/app/bower_components/flot/excanvas.min.js"></script>
	  <script type='text/javascript' src='assets/plugins/misc/placeholdr.js'></script>
	  <script type="text/javascript" src="static/app/assets/plugins/misc/media.match.min.js"></script>
	<![endif]-->

	<!-- The following CSS are included as plugins and can be removed if unused-->

	<!-- build:css assets/css/vendor.css -->
	<!-- bower:css -->
	<link rel="stylesheet" href="static/app/bower_components/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" href="static/app/bower_components/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-tree/dist/angular-ui-tree.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/ng-grid/ng-grid.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-xeditable/dist/css/xeditable.css" />
	<link rel="stylesheet" href="static/app/bower_components/iCheck/skins/all.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.core.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.buttons.css" />
	<link rel="stylesheet" href="static/app/bower_components/pnotify/pnotify.history.css" />
	<link rel="stylesheet" href="static/app/bower_components/nanoscroller/bin/css/nanoscroller.css" />
	<link rel="stylesheet" href="static/app/bower_components/textAngular/src/textAngular.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-grid/ui-grid.css" />
	<link rel="stylesheet" href="static/app/bower_components/switchery/dist/switchery.css" />
	<link rel="stylesheet" href="static/app/bower_components/ng-sortable/dist/ng-sortable.css" />
	<link rel="stylesheet" href="static/app/bower_components/fullcalendar/fullcalendar.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-meditor/dist/meditor.min.css" />
	<link rel="stylesheet" href="static/app/bower_components/angular-ui-select/dist/select.css" />
	<link rel="stylesheet" href="static/app/bower_components/animate.css/animate.css" />
	<link rel="stylesheet" href="static/app/bower_components/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<link rel="stylesheet" href="static/app/bower_components/nvd3/src/nv.d3.css" />
	<link rel="stylesheet" href="static/app/bower_components/skylo/vendor/styles/skylo.css" />
	<link rel="stylesheet" href="static/app/bower_components/bootstrap-datepaginator/dist/bootstrap-datepaginator.min.css" />
	<!-- endbower -->
	<link rel='stylesheet' type='text/css' href='static/app/assets/fonts/glyphicons/css/glyphicons.min.css' /> 
	<link rel='stylesheet' type='text/css' href='static/app/assets/plugins/form-fseditor/fseditor.css' /> 
	<link rel='stylesheet' type='text/css' href='static/app/assets/plugins/jcrop/css/jquery.Jcrop.min.css' /> 
	<!-- endbuild -->

	<!-- build:css({.tmp,app}) assets/css/main.css -->
	  <link rel="stylesheet" href="static/app/assets/css/styles.css">
	<!-- endbuild -->

	<!-- prochtml:remove:dist -->
	<script type="text/javascript">less = { env: 'development'};</script>
	<script type="text/javascript" src="static/app/assets/plugins/misc/less.js"></script>
	<!-- /prochtml -->
	<style>
	.ag-fresh .ag-not-dragging {
  		border: none;
	}
	</style>
</head>

<body
  ng-app="themesApp"
  ng-controller="MainController"
  class="{{getLayoutOption('sidebarThemeClass')}} {{getLayoutOption('topNavThemeClass')}}"
  ng-class="{
			  'static-header': !getLayoutOption('fixedHeader'),
			  'focusedform': getLayoutOption('fullscreen'),
			  'layout-horizontal': getLayoutOption('layoutHorizontal'),
			  'fixed-layout': getLayoutOption('layoutBoxed'),
			  'sidebar-collapsed': getLayoutOption('leftbarCollapsed') && !getLayoutOption('leftbarShown'),
			  'show-infobar': getLayoutOption('rightbarCollapsed'),
			  'show-sidebar': getLayoutOption('leftbarShown')
			}"
  ng-click="hideHeaderBar();hideChatBox()"
  animate-page-content
  faux-offcanvas
  to-top-on-load
>


	<div ng-include="'static/app/views/templates/custom-styles.html'"></div>

	<ng-include src="'static/app/views/layout/header.html'"></ng-include>
	<nav id="headernav" class="navbar ng-hide" role="navigation" ng-show="getLayoutOption('layoutHorizontal') && !layoutLoading">
		<div class="nav">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<i class="fa fa-reorder"></i>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse" ng-class="{'large-icons-nav': getLayoutOption('layoutHorizontalLargeIcons')}" id="horizontal-navbar">
			  <ul ng-controller="NavigationController" id="top-nav" class="nav navbar-nav">
				  <li ng-repeat="item in menu"
					  ng-if="!item.hideOnHorizontal"
					  ng-class="{ hasChild: (item.children!==undefined),
									active: item.selected,
									  open: (item.children!==undefined) && item.open,
						   'nav-separator': item.separator==true }"
					  ng-include="'templates/nav_renderer_horizontal.html'"
					></li>
			  </ul>
		</div>
	</nav>


	<div id="wrapper">
		<div id="layout-static">
		
			<div class="static-content-wrapper">
				<div class="static-content">
					<div id="wrap" ng-view="" class="mainview-animation animated">
					</div> <!--wrap -->
				</div>
				<footer role="contentinfo" ng-show="!layoutLoading" ng-cloak>
					<div class="clearfix">
						<ul class="list-unstyled list-inline pull-left">
							<li>MAVERICK &copy; 2015</li>
						</ul>
						<button class="pull-right btn btn-default btn-sm hidden-print" back-to-top style="padding: 1px 10px;"><i class="fa fa-angle-up"></i></button>
					</div>
				</footer>
			</div>
		</div>
	</div>


	<!--[if lt IE 9]>
	<script src="static/app/bower_components/es5-shim/es5-shim.js"></script>
	<script src="static/app/bower_components/json3/lib/json3.min.js"></script>
	<![endif]-->


	<!-- build:js scripts/vendor.js -->
	<!-- bower:js -->
	<script src="static/app/bower_components/jquery/dist/jquery.js"></script>
	<script src="static/app/bower_components/angular/angular.js"></script>
	<script src="static/app/bower_components/angular-resource/angular-resource.js"></script>
	<script src="static/app/bower_components/angular-cookies/angular-cookies.js"></script>
	<script src="static/app/bower_components/angular-sanitize/angular-sanitize.js"></script>
	<script src="static/app/bower_components/angular-route/angular-route.js"></script>
	<script src="static/app/bower_components/angular-animate/angular-animate.js"></script>
	<script src="static/app/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script src="static/app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
	<script src="static/app/bower_components/ng-grid/build/ng-grid.js"></script>


	<script src="static/app/bower_components/enquire/dist/enquire.js"></script>
	
	<script src="static/app/bower_components/angularjs-nvd3-directives/dist/angularjs-nvd3-directives.js"></script>
	<script src="static/app/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>


	  <!-- build:js({.tmp,app}) scripts/scripts.js -->
	<script src="static/app/scripts/core/controllers/mainController.js"></script>
	<script src="static/app/scripts/core/controllers/messagesController.js"></script>
	<script src="static/app/scripts/core/controllers/navigationController.js"></script>
	<script src="static/app/scripts/core/controllers/notificationsController.js"></script>
	<script src="static/app/scripts/core/directives/directives.js"></script>
	<script src="static/app/scripts/core/directives/form.js"></script>
	<script src="static/app/scripts/core/directives/ui.js"></script>
	<script src="static/app/scripts/core/modules/templates.js"></script>
	<script src="static/app/scripts/core/modules/panels/ngDraggable.js"></script>
	
	<script src="static/app/scripts/core/services/servicesold.js"></script>
	<script src="static/app/scripts/core/services/servicesFactura.js"></script>
	
	<script src="static/app/scripts/core/services/theme.js"></script>
	<script src="static/app/scripts/core/theme.js"></script>
	
    <script src="static/grid/dist/ag-grid.js?ignore=notused14"></script>
	
	<script src="static/app/scripts/demos/modules/facturaController.js"></script>

	<script src="static/app/scripts/demos/demos.js"></script>
	<script src="static/app/scripts/app.js"></script>
	
    <link rel="stylesheet" type="text/css" href="static/grid/dist/ag-grid.css?ignore=notused14">
    <link rel="stylesheet" type="text/css" href="static/grid/dist/theme-fresh.css?ignore=notused14">
	  <!-- endbuild -->
</body>
</html>
