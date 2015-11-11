package com.danmar.dbf.dto.filtro;

public class Paginacion {

	private String campoFiltroGeneral;
	private int pagina ;
	private int cantRegistros ;
	
	
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getCantRegistros() {
		return cantRegistros;
	}
	public void setCantRegistros(int cantRegistros) {
		this.cantRegistros = cantRegistros;
	}
	public String getCampoFiltroGeneral() {
		return campoFiltroGeneral;
	}
	public void setCampoFiltroGeneral(String campoFiltroGeneral) {
		this.campoFiltroGeneral = campoFiltroGeneral;
	}
	
	
}
