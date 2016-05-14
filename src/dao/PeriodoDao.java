package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.Periodo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;

import java.util.List;

@Repository
public class PeriodoDao {
	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 

    private static final class PeriodoMapper implements RowMapper<Periodo>{
    	public Periodo mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Periodo p = new Periodo();
    		
		    p.setFechaInicio(rs.getTimestamp("fechaInicio"));
		    p.setFechaFin(rs.getTimestamp("fechaFin"));				
			p.setIdPropiedad(rs.getInt("idPropiedad"));
			
			return p;
    	}
    }
    
	public List<Periodo> getPeriodos() {
		return this.jdbcTemplate.query("select * from Periodo",
				new PeriodoMapper());			
	}
	
	public Periodo getPeriodo(Timestamp fechaInicio, int idPropiedad) {
		return this.jdbcTemplate.queryForObject("select * "
										+ " from Periodo "
										+ " where fechaInicio = ? and idPropiedad = ?",
										new Object[] {fechaInicio, idPropiedad},
										new PeriodoMapper());			
	}
	
	public void addPeriodo(Periodo periodo) {
		this.jdbcTemplate.update("insert into Periodo(fechaInicio, fechaFin, "
				+ "idPropiedad) "
				+ "values(?, ?, ?)",			
			periodo.getFechaInicio(),
			periodo.getFechaFin(),
			periodo.getIdPropiedad());		
	}

	public void updatePeriodo(Periodo periodo) {
		this.jdbcTemplate.update("update Periodo "
					+ "set fechaFin = ? "
					+ "where fechaInicio = ? AND idPropiedad = ?",
					periodo.getFechaFin(),
					periodo.getFechaInicio(), 
					periodo.getIdPropiedad());	
	}

	public void deletePeriodo(Timestamp fechaInicio, int idPropiedad) {
		this.jdbcTemplate.update(" DELETE from Periodo "
					+ " where fechaInicio = "+fechaInicio+" AND idPropiedad= "+idPropiedad);
								
	}
}
