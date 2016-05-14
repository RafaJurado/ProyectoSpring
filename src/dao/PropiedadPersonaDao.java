package dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.PropiedadPersona;



@Repository
public class PropiedadPersonaDao {
     
    private JdbcTemplate jdbcTemplate;
     
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class PropiedadPersonaMapper implements RowMapper<PropiedadPersona> {

        public PropiedadPersona mapRow(ResultSet rs, int rowNum) throws SQLException { 
        	PropiedadPersona pp = new PropiedadPersona();
			
			pp.setIdPersona(rs.getString("idPersona"));
			pp.setIdPropiedad(rs.getInt("idPropiedad"));
			pp.setValoracion(rs.getInt("valoracion"));
			pp.setFechaValoracion(rs.getTimestamp("fechaValoracion"));
			
            return pp;
        }
    }

    public List<PropiedadPersona> getPropiedadPersona() {
         return this.jdbcTemplate.query("select * from PropiedadPersona"
, new PropiedadPersonaMapper());
    }     
        
    public PropiedadPersona getPropiedadPersona(int idPersona, int idPropiedad) {
        return this.jdbcTemplate.queryForObject("select * from PropiedadPersona where idPersona = ? and idPropiedad = ?",  new Object[] {idPersona,idPropiedad}, new PropiedadPersonaMapper());
    }
    
    public void addPropiedadPersona(PropiedadPersona pp) {
        this.jdbcTemplate.update(
        		"insert into PropiedadPersona(idPersona, idPropiedad, valoracion, fechaValoracion ) "
    					+ "values(?, ?, ?, ?)", pp.getIdPersona(),pp.getIdPropiedad(),pp.getValoracion(),pp.getFechaValoracion());
    }
        
    public void updatePropiedadPersona(PropiedadPersona pp) {
        this.jdbcTemplate.update(
        		" update PropiedadPersona "
    					+ "set valoracion = ? ,"
    					+ "fechaValoracion = ? "		
    					+ "where idPersona = ? AND idPropiedad = ?",pp.getValoracion(),pp.getFechaValoracion(),pp.getIdPersona(), pp.getIdPropiedad());
    }
        
    public void deletePropiedadPersona(int idPersona, int idPropiedad) {
        this.jdbcTemplate.update(
        		" DELETE from PropiedadPersona "
    			+ " where idPersona = ? AND idPropiedad= ?",
                idPersona, idPropiedad);
    }

}
