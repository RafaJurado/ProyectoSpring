package dao;

import domain.Propiedad;
import domain.TipoPropiedad;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

@Repository
public class PropiedadDao {
	private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
    } 
    
    private static final class PropiedadMapper implements RowMapper<Propiedad>{
    	public Propiedad mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Propiedad p = new Propiedad();
    		p.setIdPropiedad(rs.getInt("idPropiedad"));
			p.setTitulo(rs.getString("titulo"));
			p.setDescripcion(rs.getString("descripcion"));
			p.setCapacidad(rs.getInt("capacidad"));
			p.setNumeroHabitaciones(rs.getInt("numeroHabitaciones"));
			p.setNumeroBanyos(rs.getInt("numeroBanyos"));
			p.setNumeroCamas(rs.getInt("numeroCamas"));
			p.setTamanyo(rs.getInt("tamanyo"));
			p.setPrecio(rs.getFloat("precio"));
			p.setActivo(rs.getBoolean("activo"));
			p.setTipoPropiedad(TipoPropiedad.valueOf(rs.getString("tipoPropiedad")));
			p.setPoblacion(rs.getString("poblacion"));
			p.setProvincia(rs.getString("provincia"));
			p.setTipoVia(rs.getString("tipoVia"));
			p.setNombreVia(rs.getString("nombreVia"));
			p.setNumero(rs.getString("numero"));
			p.setEscalera(rs.getString("escalera"));
			p.setPuerta(rs.getString("puerta"));
			p.setCodigoPostal(rs.getInt("codigoPostal"));
			p.setIdPersona(rs.getString("idPersona"));
			p.setValoracionMedia(rs.getFloat("valoracionMedia"));
			
			return p;
    	}
    }
	
	public List<Propiedad> getPropiedades() {
		return this.jdbcTemplate.query("select * from Propiedad", 
				new PropiedadMapper());		
	}
	
	public Propiedad getPropiedad(int idPropiedad){
		return this.jdbcTemplate.queryForObject("select * from Propiedad where idPropiedad=?", 
				new Object[] {idPropiedad}, 
				new PropiedadMapper());
	}
	
	public void addPropiedad(Propiedad p){
		this.jdbcTemplate.update("insert into Propiedad(idPropiedad, titulo, descripcion, capacidad, numeroHabitaciones,"
				+ "numeroBanyos, numeroCamas, tamanyo, precio, activo, tipoPropiedad, poblacion, provincia, tipoVia,"
					+ "nombreVia, numero, escalera, puerta, codigoPostal, idPersona, valoracionMedia) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CAST(? AS tipoPropiedad), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					p.getIdPropiedad(),
					p.getTitulo(),
					p.getDescripcion(),
					p.getCapacidad(),
					p.getNumeroHabitaciones(),
					p.getNumeroBanyos(),
					p.getNumeroCamas(),
					p.getTamanyo(),
					p.getPrecio(),
					p.getActivo(),
					p.getTipoPropiedad().name(),
					p.getPoblacion(),
					p.getProvincia(),
					p.getTipoVia(),
					p.getNombreVia(),
					p.getNumero(),
					p.getEscalera(),
					p.getPuerta(),
					p.getCodigoPostal(),
					p.getIdPersona(),
					p.getValoracionMedia());			
	}
	
	public void updatePropiedad(Propiedad p){
		this.jdbcTemplate.update(
					" update Propiedad "
					+ "set titulo = ?,"
					+ "descripcion = ?,"
					+ "capacidad = ?,"
					+ "numeroHabitaciones = ?,"
					+ "numeroBanyos = ?,"
					+ "numeroCamas = ?,"
					+ "tamanyo = ?,"
					+ "precio = ?,"
					+ "activo = ?,"
					+ "tipoPropiedad = CAST(? AS tipoPropiedad),"
					+ "poblacion = ?,"
					+ "provincia = ?,"
					+ "tipoVia = ?,"
					+ "nombreVia = ?,"
					+ "numero = ?,"
					+ "escalera = ?,"
					+ "puerta = ?,"
					+ "codigoPostal = ?,"
					+ "idPersona = ?,"				
					+ "valoracionMedia = ?"
					+ "where idPropiedad = ?",
					p.getIdPropiedad(),
					p.getTitulo(),
					p.getDescripcion(),
					p.getCapacidad(),
					p.getNumeroHabitaciones(),
					p.getNumeroBanyos(),
					p.getNumeroCamas(),
					p.getTamanyo(),
					p.getPrecio(),
					p.getActivo(),
					p.getTipoPropiedad().name(),
					p.getPoblacion(),
					p.getProvincia(),
					p.getTipoVia(),
					p.getNombreVia(),
					p.getNumero(),
					p.getEscalera(),
					p.getPuerta(),
					p.getCodigoPostal(),
					p.getIdPersona(),
					p.getValoracionMedia());		
	}
	/*
	public void deletePropiedad(Propiedad p) {
		this.jdbcTemplate.update(
					" DELETE FROM Propiedad "
				  + " WHERE idPropiedad = ?",
				  p.getIdPropiedad());		
	}*/
	
	public void deletePropiedad(int idPropiedad) {
		this.jdbcTemplate.update(
					" DELETE FROM Propiedad "
				  + " WHERE idPropiedad = "+idPropiedad); 		
	}

}
