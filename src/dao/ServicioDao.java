package dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.Servicio;



@Repository
public class ServicioDao {
     
    private JdbcTemplate jdbcTemplate;
     
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final class ServicioMapper implements RowMapper<Servicio> {

        public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException { 
            Servicio s = new Servicio();
            s.setIdServicio(rs.getInt("idServicio"));
			s.setDescripcion(rs.getString("descripcion"));
            return s;
        }
    }

    public List<Servicio> getServicio() {
         return this.jdbcTemplate.query("select * from Servicio"
, new ServicioMapper());
    }     
        
    public Servicio getServicio(int idServicio) {
        return this.jdbcTemplate.queryForObject("select * from Servicio where idServicio=?",  new Object[] {idServicio}, new ServicioMapper());
    }
    
    public void addServicio(Servicio s) {
        this.jdbcTemplate.update(
                "insert into Servicio(idServicio, descripcion) "
					+ "values(?, ?)", s.getIdServicio(), s.getDescripcion());
    }
        
    public void updateServicio(Servicio s) {
        this.jdbcTemplate.update(
                "update Servicio "
					+ "set descripcion = ? "
					+ "where idServicio = ?", s.getDescripcion(), s.getIdServicio());
    }
        
    public void deleteNadador(int idServicio) {
        this.jdbcTemplate.update(
        		"DELETE from Servicio "
    					+ " where idServicio= ?",
                idServicio);
    }

}
