package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import domain.Factura;
import java.util.List;

@Repository
public class FacturaDao {
	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 
    
    private static final class FacturaMapper implements RowMapper<Factura>{
    	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Factura f = new Factura();
			f.setIdFactura(rs.getInt("idFactura"));			
			/*Calendar cal = Calendar.getInstance(); //***
			cal.setTime(rs.getDate("fechaFactura"));*/
			f.setFechaFactura(rs.getTimestamp("fechaFactura"));
		    //f.setFechaFactura(cal);		    	
			f.setIdReserva(rs.getInt("idReserva"));					
			return f;
    	}
    }

	public List<Factura> getFacturas() {
		return this.jdbcTemplate.query("select * from Factura",
				new FacturaMapper());
	}
	
	public Factura getFactura(int idFactura) {
		return this.jdbcTemplate.queryForObject(" select * "
										+ " from Factura "
										+ " where idFactura = ?",
										new Object[] {idFactura},
										new FacturaMapper());			
	}
	
	public void addFactura(Factura factura) {
		this.jdbcTemplate.update("insert into Factura("
					 + "idFactura, fechaFactura, idReserva) "
					+ "values(?, ?, ?)",			
			factura.getIdFactura(),
			factura.getFechaFactura(),
			factura.getIdReserva());		
	}

	public void updateFactura(Factura factura) {
		this.jdbcTemplate.update("update Factura "
					+ "set fechaFactura = ?,"
					+ "idReserva = ? "
					+ "where idFactura = ?",			
			factura.getFechaFactura(),
			factura.getIdReserva(),	
			factura.getIdFactura());		
	}

//	public void deleteFactura(Factura factura) {
//		this.jdbcTemplate.update(" DELETE from Factura "
//					+ " where idFactura = ?",				
//			factura.getIdFactura());		
//	}
	
	public void deleteFactura(int idFactura){
		this.jdbcTemplate.update("DELETE from Factura "
				+ " where idFactura =" + idFactura);
	}
}
