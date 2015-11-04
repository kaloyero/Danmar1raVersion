package com.danmar.dbf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.danmar.dbf.dto.TarjetaDto;

public class TarjetaDao extends GenericDao<TarjetaDto>{
	public static final String TABLA_NOMBRE		 = "tc_coefs";
	
	public static final String CAMPO_TARJETA	 = "tarjeta";
	public static final String CAMPO_CUOTAS		 = "cuotas";
	public static final String CAMPO_COEFICIEN	 	 = "coeficien";


   /**
    * Se ejecuta la clase de consulta
    */
    public static void main(String[] args) {
        
    	TarjetaDao access = new TarjetaDao();
        access.getAll();
        access.getById(1, 3);
    }
   
   public List<TarjetaDto> getAll(int pagina, int cantRegistros)
   {
       return super.getAll(pagina,cantRegistros);
   }
   
   public List<TarjetaDto> getAll()
   {
       return super.getAll();
   }
	        
    @Override
    protected TarjetaDto getDto(ResultSet res) throws SQLException{
        	TarjetaDto tarjeta = new TarjetaDto();
        	tarjeta.setCodigo( res.getInt(CAMPO_TARJETA));
        	tarjeta.setCuotas( res.getInt(CAMPO_CUOTAS));
        	tarjeta.setCoeficiente(res.getDouble(CAMPO_COEFICIEN));

        	return tarjeta;
    }
     
	@Override
	protected String getTableName() {
		return TABLA_NOMBRE;
	}


	public TarjetaDto getById (int tarjeta,int cuotas){
		TarjetaDto dto = super.getByIdQry("tarjeta = "+tarjeta+"  and cuotas = "+cuotas+" ");
		
		return dto;
	}
}
