package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private List<TipoContactoDTO> tiposContactosEnTabla;
		private TreeMap<Integer, TipoContactoDTO> tiposContactoOrdenados;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			
			this.agenda = agenda;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			cargarTiposContacto();
			actualizarComboBoxes();
			this.ventanaPersona.mostrarVentana();
		}

	
		private void guardarPersona(ActionEvent p) {
			//toma las variables y las setea en una PersonaDTO
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String fecha_cumpleaños = ventanaPersona.getTxtFechaCumpleaños().getText();
			
			//toma las variables y las setea en un ContactoDTO
			//int id = ventanaPersona.getComboBox().getSelectedItem();
			//int id = (int) this.ventanaPersona.getComboBox()
			
			PersonaDTO nuevaPersona = new PersonaDTO(0, 0, 0, nombre, tel, email, fecha_cumpleaños);
			this.agenda.agregarPersona(nuevaPersona);
			
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			//obtiene una list de personasDTO leyendola de la base de datos
			this.personasEnTabla = agenda.obtenerPersonas();
			//hace visible la tabla actualizada
			this.vista.llenarTabla(this.personasEnTabla);
		}
		
		private void cargarTiposContacto() {
			this.tiposContactosEnTabla = agenda.obtenerTiposContacto();
			tiposContactoOrdenados = new TreeMap<Integer, TipoContactoDTO>();
			
			for (TipoContactoDTO tc  : tiposContactosEnTabla) {
				if(!tiposContactoOrdenados.containsKey(tc.getIdTipoContacto())) {
					tiposContactoOrdenados.put(tc.getIdTipoContacto(), tc);
				}	
			}	
		}
		
		private void actualizarComboBoxes() {
			this.tiposContactosEnTabla = agenda.obtenerTiposContacto();
			this.ventanaPersona.actualizarComboBoxes(this.tiposContactosEnTabla);
		}


		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
