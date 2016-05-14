package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import domain.Imagen;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;


@Repository
public class ImagenDao {
	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 

    private static final class ImagenMapper implements RowMapper<Imagen>{
    	public Imagen mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Imagen imagen = new Imagen();
    		imagen.setNombreImagen(rs.getString("nombreImagen"));
			imagen.setIdPropiedad(rs.getInt("idPropiedad"));
			imagen.setFechaSubida(rs.getTimestamp("fechaSubida"));
			return imagen;
    	}
    }
    
	public List<Imagen> getImagenes() {
		return this.jdbcTemplate.query("select * from Imagen",
				new ImagenMapper());			
	}
	
	public Imagen getImagen(String nombreImagen, int idPropiedad) {
		return this.jdbcTemplate.queryForObject( " select * "
										+ " from Imagen "
										+ " where nombreImagen = ? and idPropiedad = ?",
										new Object[] {nombreImagen, idPropiedad},
										new ImagenMapper());			
	}
	
	public void addImagen(Imagen imagen) {
		this.jdbcTemplate.update("insert into Imagen(nombreImagen,"
				+ "idPropiedad, fechaSubida) "
				+ "values(?, ?, ?)",
			imagen.getNombreImagen(),
			imagen.getIdPropiedad(),
			imagen.getFechaSubida());		
	}
	//TIENE SENTIDO HACER ESTE UPDATE???
	public void updateImagen(Imagen imagen) {
		this.jdbcTemplate.update("update Imagen "
					+ "set fechaSubida = ?,"
					+ "where nombreImagen = ? and idPropiedad = ?",
					imagen.getFechaSubida(),
					imagen.getIdPropiedad(),					
					imagen.getNombreImagen());		
	}

	public void deleteImagen(String nombreImagen, int idPropiedad) {
		this.jdbcTemplate.update(" DELETE from Imagen "
					+ " where nombreImagen = ? "
					+ " AND idPropiedad= ?",nombreImagen,idPropiedad);		
	}
}
