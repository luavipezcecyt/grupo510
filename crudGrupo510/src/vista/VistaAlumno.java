package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AlumnoDao;
import modelo.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNControl;
	private JTextField txtNombre;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtCurp;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAlumno frame = new VistaAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setForeground(new Color(0, 0, 255));
		lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnos.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAlumnos.setBounds(172, 11, 157, 29);
		contentPane.add(lblAlumnos);
		
		JLabel lblNewLabel = new JLabel("Número de control:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(54, 57, 106, 14);
		contentPane.add(lblNewLabel);
		
		txtNControl = new JTextField();
		txtNControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
				if(((c <'0')||c >'9')&&(c!='\b')){
					e.consume();
					JOptionPane.showMessageDialog(null,"sólo acepta números");
		}
				
				//JOptionPane.showMessageDialog(null,"Tecleaste la letra: " +e.getKeyChar());
			}
		});
		txtNControl.setBounds(170, 54, 116, 20);
		contentPane.add(txtNControl);
		txtNControl.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(54, 85, 106, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(170, 82, 116, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
		lblApellidoPaterno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidoPaterno.setBounds(54, 113, 106, 14);
		contentPane.add(lblApellidoPaterno);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setColumns(10);
		txtApellidoP.setBounds(170, 110, 116, 20);
		contentPane.add(txtApellidoP);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidoMaterno.setBounds(54, 141, 106, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setColumns(10);
		txtApellidoM.setBounds(170, 138, 116, 20);
		contentPane.add(txtApellidoM);
		
		JLabel lblCurp = new JLabel("CURP:");
		lblCurp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurp.setBounds(54, 169, 106, 14);
		contentPane.add(lblCurp);
		
		txtCurp = new JTextField();
		txtCurp.setColumns(10);
		txtCurp.setBounds(170, 166, 116, 20);
		contentPane.add(txtCurp);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setBounds(54, 203, 106, 14);
		contentPane.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(170, 200, 116, 20);
		contentPane.add(txtTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno al = new Alumno();
			if(txtNControl.getText().length()>0) {				
			al.setnControl(Integer.parseInt(txtNControl.getText()));
			al.setNombre(txtNombre.getText());
			al.setApellido_p(txtApellidoP.getText());
			al.setApellido_m(txtApellidoM.getText());
			al.setCurp(txtCurp.getText());
			al.setTelefono(txtTelefono.getText());
			
			AlumnoDao ald = new AlumnoDao();
			ald.guardar(al);
;			}else {
	JOptionPane.showMessageDialog(null, "Ingresa el número de control");
	
}
			}
		});
		btnGuardar.setBounds(40, 228, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnoDao ald = new AlumnoDao();
				Alumno a = ald.consultar(Integer.parseInt(txtNControl.getText()));
				txtNombre.setText(a.getNombre());
				txtApellidoP.setText(a.getApellido_p());
				txtApellidoM.setText(a.getApellido_m());
				txtCurp.setText(a.getCurp());
				txtTelefono.setText(a.getTelefono());
			}
		});
		btnConsultar.setBounds(153, 228, 89, 23);
		contentPane.add(btnConsultar);
	}
}
