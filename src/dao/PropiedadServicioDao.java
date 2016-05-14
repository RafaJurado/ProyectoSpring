package dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.PropiedadServicio;



@Repository
public class PropiedadServicioDao {
     
    private JdbcTemplate jdbcTemplate;
     
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class PropiedadServicioMapper implements RowMapper<PropiedadServicio> {

        public PropiedadServicio mapRow(ResultSet rs, int rowNum) throws SQLException { 
        	PropiedadServicio ps = new PropiedadServicio();
			
			ps.setIdServicio(rs.getInt("idServicio"));
			ps.setIdPropiedad(rs.getInt("idPropiedad"));
            return ps;
        }
    }

    public List<PropiedadServicio> getPropiedadServicio() {
         return this.jdbcTemplate.query("select * from PropiedadServicio"
, new PropiedadServicioMapper());
    }     
        
    public PropiedadServicio getPropiedadServicio(int idServicio, int idPropiedad) {
        return this.jdbcTemplate.queryForObject(" select * "
				+ " from PropiedadServicio "
				+ " where idServicio = ? AND idPropiedad = ?",  new Object[] {idServicio,idPropiedad}, new PropiedadServicioMapper());
    }
    
    public void addPropiedadServicio(PropiedadServicio ps) {
        this.jdbcTemplate.update(
                "insert into PropiedadServicio(idServicio, idPropiedad) "
					+ "values(?, ?)", ps.getIdServicio(), ps.getIdPropiedad());
    }
        
    //no se puede hacer update, ya que ambos atributos son parte de la clave primaria
        
    public void deletePropiedadServicio(int idServicio, int idPropiedad) {
        this.jdbcTemplate.update(
        		" DELETE from PropiedadServicio "
    					+ " where idServicio= ? AND idPropiedad = ?",
                idServicio, idPropiedad);
    }

}
