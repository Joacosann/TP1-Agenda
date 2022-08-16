package dto;

public class PersonaDTO 
{
	private int id_persona;
	private int id_tipoContacto;
	private int id_direccion;
	private String nombre;
	private String telefono;
	private String email;
	private String fecha_cumpleaños;

	public PersonaDTO(int idPersona, int idTipoContacto, int idDireccion, String nombre, String telefono, String email, String fecha_cumpleaños)
	{
		this.id_persona = idPersona;
		this.id_tipoContacto = idTipoContacto;
		this.id_direccion = idDireccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fecha_cumpleaños = fecha_cumpleaños;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public int getId_tipoContacto() {
		return id_tipoContacto;
	}

	public void setId_tipoContacto(int id_tipoContacto) {
		this.id_tipoContacto = id_tipoContacto;
	}

	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha_cumpleaños() {
		return fecha_cumpleaños;
	}

	public void setFecha_cumpleaños(String fecha_cumpleaños) {
		this.fecha_cumpleaños = fecha_cumpleaños;
	}
	
	
	
}
