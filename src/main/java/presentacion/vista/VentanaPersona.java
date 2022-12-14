package presentacion.vista;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.TipoContactoDTO;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtFechaCumpleaños;
	private JButton btnAgregarPersona;
	private JComboBox<TipoContactoDTO> comboBox;
	private DefaultComboBoxModel<TipoContactoDTO> tipos;
	private static VentanaPersona INSTANCE;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 600, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblFechaCumpleaños = new JLabel("Fecha cumpleaños");
		lblFechaCumpleaños.setBounds(10, 134, 113, 14);
		panel.add(lblFechaCumpleaños);
		
		JLabel lblTipoContacto = new JLabel("Tipo");
		lblTipoContacto.setBounds(350, 11, 113, 14);
		panel.add(lblTipoContacto);
		
		comboBox = new JComboBox<TipoContactoDTO>();
		comboBox.setBounds(380, 11, 113, 20);
		tipos = new DefaultComboBoxModel<TipoContactoDTO>();
		//actualiza los tipos que lee de la base de datos
		comboBox.setModel(tipos);
		panel.add(comboBox);
		//---------------------------------------------------------------------//
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 90, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFechaCumpleaños = new JTextField();
		txtFechaCumpleaños.setBounds(133, 131, 164, 20);
		panel.add(txtFechaCumpleaños);
		txtFechaCumpleaños.setColumns(10);
		//---------------------------------------------------------------------//
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(230, 200, 89, 23);
		panel.add(btnAgregarPersona);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtEmail() {
		
		return txtEmail;
	}
	
	public JTextField getTxtFechaCumpleaños() {
		
		return txtFechaCumpleaños;
	}
	

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JComboBox<TipoContactoDTO> getComboBox() {
		return comboBox;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtFechaCumpleaños.setText(null);
		this.txtEmail.setText(null);
		
		this.dispose();
	}

	public void actualizarComboBoxes(List<TipoContactoDTO> tipoContactosEnTabla) {
		for (TipoContactoDTO tc : tipoContactosEnTabla) {
			comboBox.addItem(tc);
		}
	}

	

	
}

