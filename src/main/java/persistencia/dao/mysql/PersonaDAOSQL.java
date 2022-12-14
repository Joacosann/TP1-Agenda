package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(id_persona, id_tipo_contacto, id_direccion, nombre, telefono, email, fecha_cumpleaños) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE id_persona = ?";
	private static final String readall = "SELECT * FROM personas";
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getId_persona());
			
			if(persona.getId_tipoContacto()!=0) {
				
				statement.setInt(2, persona.getId_tipoContacto());
			}
			else {
				statement.setNull(2,Types.INTEGER);
			}
			
			if(persona.getId_direccion()!=0) {
				statement.setInt(3, persona.getId_direccion());
			}
			else {
				statement.setNull(3,Types.INTEGER);
			}
			
			statement.setString(4, persona.getNombre());
			statement.setString(5, persona.getTelefono());
			statement.setString(6, persona.getEmail());
			statement.setString(7, persona.getFecha_cumpleaños());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getId_persona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id_persona = resultSet.getInt("id_persona");
		int id_tipo_contacto = resultSet.getInt("id_tipo_contacto");
		int id_direccion = resultSet.getInt("id_direccion");
		
		String nombre = resultSet.getString("nombre");
		String tel = resultSet.getString("telefono");
		String email = resultSet.getString("email");
		String fecha_cumpleaños = resultSet.getString("fecha_cumpleaños");
		
		return new PersonaDTO(id_persona,id_tipo_contacto,id_direccion, nombre, tel, email, fecha_cumpleaños);
	}
}
