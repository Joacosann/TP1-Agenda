package persistencia.dao.interfaz;

import java.util.List;

import dto.TipoContactoDTO;


public interface TipoContactoDAO {

	
	public boolean insert(TipoContactoDTO persona);

	public boolean delete(TipoContactoDTO persona_a_eliminar);
	
	public List<TipoContactoDTO> readAll();
}
