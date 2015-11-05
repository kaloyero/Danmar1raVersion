package com.facturador.danmar.service;

import com.facturador.danmar.common.ErrorRespuestaBean;
import com.facturador.danmar.model.DocumentoEncabezado;


public interface DocumentoEncabezadoService  {

	ErrorRespuestaBean save(DocumentoEncabezado dto);
}
