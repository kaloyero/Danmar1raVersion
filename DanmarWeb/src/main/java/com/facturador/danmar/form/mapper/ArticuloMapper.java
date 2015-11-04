package com.facturador.danmar.form.mapper;

import com.danmar.dbf.dto.ArticuloDto;
import com.facturador.danmar.common.ConvertionUtil;
import com.facturador.danmar.common.DateUtil;
import com.facturador.danmar.common.FormatUtil;
import com.facturador.danmar.form.ArticuloForm;


public class ArticuloMapper extends MapperImpl<ArticuloDto,ArticuloForm>{


	public ArticuloDto getEntidad(ArticuloForm form) {
		ArticuloDto ent = new ArticuloDto();
		if (form != null){		

			
		}
		return ent;
	}

	public ArticuloForm getForm(ArticuloDto ent) {
		ArticuloForm articulo=new ArticuloForm();
		if (ent != null){
        	articulo.setArticulo(ent.getArticulo());
        	articulo.setCanMaxima(ConvertionUtil.StrValueOf(ent.getCanMaxima()));
        	articulo.setCanMinima(ConvertionUtil.StrValueOf(ent.getCanMinima()));
        	articulo.setCc1(ent.getCc1());
        	articulo.setCc2(ent.getCc2());
        	articulo.setCc3(ent.getCc3());
        	articulo.setCc4(ent.getCc4());
        	articulo.setCc5(ent.getCc5());
        	articulo.setCodigoProv(ent.getCodigoProv());
        	articulo.setCosto(FormatUtil.format2DecimalsStr(ent.getCosto()));
        	articulo.setDescuentoAdicional(ent.getDescuentoAdicional());
        	articulo.setDescuentoProv1(ent.getDescuentoProv1());
        	articulo.setDescuentoProv2(ent.getDescuentoProv2());
        	articulo.setDescuentos(ent.getDescuentos());
        	articulo.setExistentes(ent.getExistentes());
        	articulo.setFacturaCompra(ConvertionUtil.StrValueOf(ent.getFacturaCompra()));
        	articulo.setfCamprec(DateUtil.convertDateToString(ent.getfCamprec()));
        	articulo.setFechaCompra(DateUtil.convertDateToString(ent.getFechaCompra()));
        	articulo.setfVarmay(ent.getVarMay());
        	articulo.setfVarmin(ent.getVarMin());
        	articulo.setGanancia( FormatUtil.format2DecimalsStr(ent.getGanancia()) );
        	articulo.setGananciaMy(FormatUtil.format2DecimalsStr(ent.getGananciaMy()) );
        	articulo.setLinea(ent.getLinea());
        	articulo.setListaPrecioAux(FormatUtil.format2DecimalsStr(ent.getListaPrecioAux()) );
        	articulo.setManoDeObra(ent.getManoDeObra());
        	articulo.setMonedaCos(ent.getMonedaCos());
        	articulo.setOrigen(ent.getOrigen());
        	articulo.setPrecio(FormatUtil.format2DecimalsStr(ent.getPrecio()));
        	articulo.setPrecioLp(FormatUtil.format2DecimalsStr(ent.getPrecioLp()));
        	articulo.setPrecioMayorista(FormatUtil.format2DecimalsStr(ent.getPrecioMayorista()));
        	articulo.setProveedor(ent.getProveedor());
        	articulo.setRecambio(ent.getRecambio());
        	articulo.setReservados(ent.getReservados());
        	articulo.setTiempo(ent.getTiempo());
        	articulo.setTipo(ent.getTipo());
        	articulo.setVariacion(ent.getVariacion());
        	articulo.setVarMay(ent.getVarMay());
        	articulo.setVarMin(ent.getVarMin());
        	articulo.setVisible(ent.getVisible());

		}
		return articulo;
	}


}