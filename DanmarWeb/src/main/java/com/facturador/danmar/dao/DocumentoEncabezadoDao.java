package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.model.DocumentoEncabezado;

public interface DocumentoEncabezadoDao {

	public void save(DocumentoEncabezado ent);

	public List<DocumentoEncabezado > getAll();

}