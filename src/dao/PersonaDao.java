package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.ResultSet;
import domain.Persona;
import domain.TipoPersona;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class PersonaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	private static final class PersonaMapper implements RowMapper<Persona> { 

	    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException { 
	    	Persona persona = new Persona();
	    	
	    	persona.setDni(rs.getString("dni"));
			persona.setNombre(rs.getString("nombre"));
			persona.setApellidos(rs.getString("apellidos"));
			persona.setEmail(rs.getString("email"));
			persona.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
		    persona.setTelefono(rs.getInt("telefono"));
			persona.setActivo(rs.getBoolean("activo"));
			persona.setNombreUsuario(rs.getString("nombreUsuario"));
			persona.setContrasenya(rs.getString("contrasenya"));			
			persona.setTipoPersona(TipoPersona.valueOf(rs.getString("tipoPersona")));			
			persona.setPoblacion(rs.getString("poblacion"));
			persona.setProvincia(rs.getString("provincia"));
			persona.setTipoVia(rs.getString("tipoVia"));
			persona.setNombreVia(rs.getString("nombreVia"));
			persona.setNumero(rs.getString("numero"));
			persona.setEscalera(rs.getString("escalera"));
			persona.setPuerta(rs.getString("puerta"));
			persona.setCodigoPostal(rs.getInt("codigoPostal"));		    	
	    	
	        return persona;
	    }
	}
	
	public List<Persona> getPersonas() {
		 return this.jdbcTemplate.query("select * from Persona", new PersonaMapper()); 
	}	 
		
	public Persona getPersona(String dni) {
		return this.jdbcTemplate.queryForObject("select * from Persona where dni =?",  
												new Object[] {dni}, 
												new PersonaMapper());
	}
	
	public void addPersona(Persona persona) {
		this.jdbcTemplate.update(
				"insert into Persona(dni, nombre, apellidos, email, fechaRegistro, telefono, activo, "
						+ "nombreUsuario, contrasenya,  tipoPersona, poblacion, provincia, tipoVia, nombreVia, numero, "
						+ "escalera, puerta, codigoPostal) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, CAST(? AS tipopersona), ?, ?, ?, ?, ?, ?, ?, ?)", 
				
				persona.getDni(), 
				persona.getNombre(), 
				persona.getApellidos(), 
				persona.getEmail(), 
				new Timestamp(System.currentTimeMillis() % 1000), //automatico
				persona.getTelefono(), 
				true, //automatico
				persona.getNombreUsuario(), 
				persona.getContrasenya(), 
				"USUARIO", //automatico
				persona.getPoblacion(), 
				persona.getProvincia(), 
				persona.getTipoVia(), 
				persona.getNombreVia(), 
				persona.getNumero(), 
				persona.getEscalera(), 
				persona.getPuerta(), 
				persona.getCodigoPostal());
	}
		
	public void updatePersona(Persona persona) {
		this.jdbcTemplate.update(
				"update Persona set nombre = ?, apellidos = ?, email = ?, "
				+ "telefono = ?, nombreUsuario = ?, contrasenya = ?, "
				+ "poblacion = ?, provincia = ?, tipoVia = ?, nombreVia = ?, "
				+ "numero = ?, escalera = ?, puerta = ?, codigoPostal = ? where dni = ?", 
				persona.getNombre(), 
				persona.getApellidos(), 
				persona.getEmail(), 
//				persona.getFechaRegistro(), 
				persona.getTelefono(), 
//				persona.getActivo(), 
				persona.getNombreUsuario(), 
				persona.getContrasenya(), 
//				persona.getTipoPersona(), 
				persona.getPoblacion(), 
				persona.getProvincia(), 
				persona.getTipoVia(), 
				persona.getNombreVia(), 
				persona.getNumero(), 
				persona.getEscalera(), 
				persona.getPuerta(), 
				persona.getCodigoPostal(), 
				persona.getDni());
	}
		
	public void deletePersona(String dni){
		this.jdbcTemplate.update("delete from Persona where dni = ? ",dni);
	}

	
}