package ec.edu.ups.pw2.demoapp2.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inicio {

	private VentanaVehiculos ventanaVehiculos;
	private DefaultListModel<String> vehiculosEnLista;
	
	private JFrame frame;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio window = new inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inicio() {
		try {
			ventanaVehiculos = new VentanaVehiculos();
			ventanaVehiculos.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Marca:");
		panel_2.add(lblNewLabel);
		
		txtMarca = new JTextField();
		panel_2.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnBuscarPorMarca = new JButton("Buscar");
		btnBuscarPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = txtMarca.getText();
				List<String> vehiculos = ventanaVehiculos.buscarPorMarca(marca);
				actualizarJListVehiculos(vehiculos);
			}
		});
		panel_2.add(btnBuscarPorMarca);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblModelo = new JLabel("Modelo:");
		panel_2_1.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		panel_2_1.add(txtModelo);
		
		JButton btnBuscarPorModelo = new JButton("Buscar");
		btnBuscarPorModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modelo = txtMarca.getText();
				List<String> vehiculos = ventanaVehiculos.buscarPorModelo(modelo);
				actualizarJListVehiculos(vehiculos);
			}
		});
		panel_2_1.add(btnBuscarPorModelo);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		panel_2_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblAo = new JLabel("Año:");
		panel_2_2.add(lblAo);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		panel_2_2.add(txtAnio);
		
		JButton btnBuscarPorAnio = new JButton("Buscar");
		btnBuscarPorAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String anio = txtMarca.getText();
				List<String> vehiculos = ventanaVehiculos.buscarPorAnio(anio);
				actualizarJListVehiculos(vehiculos);
			}
		});
		panel_2_2.add(btnBuscarPorAnio);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list = new JList();
		panel_1.add(list);
	}
	
	private void actualizarJListVehiculos(List<String> vehiculos) {
		vehiculosEnLista.removeAllElements();
		for (String vehiculo : vehiculos) {
			vehiculosEnLista.addElement(vehiculo);
		}
	}

}
