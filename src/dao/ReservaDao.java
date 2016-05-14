package dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import domain.Status;
import domain.Reserva;
import java.util.Calendar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class ReservaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class ReservaMapper implements RowMapper<Reserva> { 

	    public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	Reserva reserva = new Reserva();
	    	reserva.setIdReserva(rs.getInt("idReserva"));
	    	reserva.setFechaSolicitud(rs.getTimestamp("fechaSolicitud"));
			reserva.setFechaInicio(rs.getTimestamp("fechaInicio"));
			reserva.setFechaFin(rs.getTimestamp("fechaFin"));
		    reserva.setNumeroPersonas(rs.getInt("numeroPersonas"));
		    reserva.setPrecioTotal(rs.getFloat("precioTotal"));
		    reserva.setStatus(Status.valueOf(rs.getString("estado")));				
		    reserva.setIdPersona(rs.getString("idPersona"));
		    reserva.setIdPropiedad(rs.getInt("IdPropiedad"));

	        return reserva;
	    }
	}
	
	public List<Reserva> getReservas() {
		 return this.jdbcTemplate.query("select * from Reserva", new ReservaMapper()); 
	}	 
		
	public Reserva getReserva(int idReserva) {
		return this.jdbcTemplate.queryForObject("select * from Reserva where idReserva =?",  new Object[] {idReserva}, new ReservaMapper());
	}
	
	public void addReserva(Reserva reserva) {
		this.jdbcTemplate.update(
				"insert into Reserva(idReserva, fechaSolicitud, fechaInicio, fechaFin, numeroPersonas, precioTotal, estado, idPersona, idPropiedad) values(?, ?, ?, ?, ?, ?, ?, ?, ?)", reserva.getIdReserva(), reserva.getFechaSolicitud(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getNumeroPersonas(), reserva.getPrecioTotal(), reserva.getStatus(), reserva.getIdPersona(), reserva.getIdPropiedad());
	}
		
	public void updateReserva(Reserva reserva) {
		this.jdbcTemplate.update(
				"update Reserva set fechaSolicitud = ?, "
					+ "fechaInicio = ?, "
					+ "fechaFin = ?, "
					+ "numeroPersonas = ?, "
					+ "precioTotal = ?,"
					+ "estado = CAST(? AS Status),"					
					+ "idPersona = ?,"
					+ "idPropiedad = ? "
					+ "where idReserva = ?", reserva.getFechaSolicitud(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getNumeroPersonas(), reserva.getPrecioTotal(), reserva.getStatus(), reserva.getIdPersona(), reserva.getIdPropiedad());
	}
		
	public void deleteReserva(int idReserva){
		this.jdbcTemplate.update("delete from reserva where idReserva = ? " + idReserva);
	}

	
}