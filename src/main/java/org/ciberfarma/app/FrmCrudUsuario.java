package org.ciberfarma.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmCrudUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextArea txtS;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
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
	public FrmCrudUsuario() {
		setTitle("CRUD - USUARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(508, 8, 89, 23);
		contentPane.add(btnRegistrar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}
		});
		btnBuscar.setBounds(508, 42, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(10, 12, 71, 14);
		contentPane.add(lblCodigo);

		JLabel lblApellido = new JLabel("Nombre :");
		lblApellido.setBounds(10, 42, 71, 14);
		contentPane.add(lblApellido);

		JLabel lblNewLabel_2 = new JLabel("Apellido :");
		lblNewLabel_2.setBounds(10, 74, 71, 14);
		contentPane.add(lblNewLabel_2);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(80, 12, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(80, 40, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(80, 71, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 686, 186);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listado();
			}
		});
		btnListado.setBounds(607, 42, 89, 23);
		contentPane.add(btnListado);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();

			}
		});
		btnActualizar.setBounds(508, 76, 89, 23);
		contentPane.add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();

			}
		});
		btnEliminar.setBounds(607, 8, 89, 23);
		contentPane.add(btnEliminar);

		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 99, 71, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Clave :");
		lblNewLabel_1.setBounds(250, 46, 71, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Fecha :");
		lblNewLabel_3.setBounds(250, 71, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Tipo :");
		lblNewLabel_4.setBounds(250, 96, 46, 14);
		contentPane.add(lblNewLabel_4);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(80, 99, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JTextField();
		txtClave.setBounds(320, 40, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBounds(320, 68, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(320, 93, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setBounds(320, 9, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Estado :");
		lblNewLabel_5.setBounds(250, 12, 46, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(607, 76, 89, 23);
		contentPane.add(btnLimpiar);

		JLabel lblNewLabel_6 = new JLabel("1 = Administrador");
		lblNewLabel_6.setBounds(416, 99, 94, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("2 = Cliente");
		lblNewLabel_7.setBounds(416, 123, 86, 14);
		contentPane.add(lblNewLabel_7);
	}

	protected void eliminar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = factory.createEntityManager();

		try {
			Usuario p1 = em.find(Usuario.class, leerCodigo());
			em.getTransaction().begin();

			em.remove(p1);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al eliminar" + e.getMessage());
		}

	}

	void actualizar() {
		Usuario u = new Usuario();
		u.setNombre(leerNombre());
		u.setApellido(leerApellido());
		u.setUsuario(leerUsuario());
		u.setClave(leerClave());
		u.setFnacim(leerFecha());
		u.setTipo(leerTipo());
		u.setEstado(leerEstado());

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Actualización exitosa");
		em.close();

	}

	void registrar() {
		Usuario u = new Usuario();
		u.setNombre(leerNombre());
		u.setApellido(leerApellido());
		u.setUsuario(leerUsuario());
		u.setClave(leerClave());
		u.setFnacim(leerFecha());
		u.setTipo(leerTipo());
		u.setEstado(leerEstado());

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Registro exitoso");
		em.close();
	}

	void listado() {
		// Obtener un listado de los Usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		// TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll",
		// Usuario.class);
		// List<Usuario> lstUsuarios = consulta.getResultList();

		TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
		// consulta.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios = consulta.getResultList();

		em.close();
		txtS.append("CODIGO" + "\t" + "NOMBRE" + "\t" + "APELLIDO" + "\t" + "USER" + "\t" + "\t" + "PASSWORD" + "\t"
				+ "FECH_NAC" + "\t" + "TIPO" + "\t" + "ESTADO" + "\n");
		for (Usuario u : lstUsuarios) {
			txtS.append(u.getCodigo() + "\t" + u.getNombre() + "\t" + u.getApellido() + "\t" + u.getUsuario() + "\t"
					+ u.getClave() + "\t" + u.getFnacim() + "\t" + u.getTipo() + "\t" + u.getEstado() + "\n");
		}

	}

	void buscar() {
		// Buscar codigo
		int codigo = leerCodigo();
		// Buscar en la tabla, para obtener en Usuario
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		Usuario u = em.find(Usuario.class, codigo);
		em.close();
		if (u == null) {
			aviso("Usuario " + codigo + " No existe!!!");
		} else {
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
		}

	}

	void aviso(String mensaje) {
		JOptionPane.showInternalMessageDialog(this, mensaje, "Aviso del sistema", 1);
	}

	int leerCodigo() {

		return Integer.parseInt(txtCodigo.getText());
	}

	String leerNombre() {
		return txtNombre.getText();
	}

	String leerApellido() {
		return txtApellido.getText();
	}

	String leerUsuario() {
		return txtUsuario.getText();
	}

	String leerClave() {
		return txtClave.getText();
	}

	String leerFecha() {
		return txtFecha.getText();
	}

	int leerTipo() {
		return Integer.parseInt(txtTipo.getText());
	}

	int leerEstado() {
		return Integer.parseInt(txtEstado.getText());
	}
}
