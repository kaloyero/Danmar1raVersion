package com.facturador.danmar.manager;

import com.facturador.danmar.common.ErrorRespuestaBean;
import com.facturador.danmar.form.DocumentoEncabezadoForm;


public interface DocumentoEncabezadoManager  {

	ErrorRespuestaBean save(DocumentoEncabezadoForm form);
}
