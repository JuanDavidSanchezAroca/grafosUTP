package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controlador;
import modelo.Nodo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelGrafo panel;
	private Controlador controlador;
	private JTextField txVerticeOrigen;
	private JTextField txVerticeDestino;
	private JRadioButton rbDireccional;
	private JRadioButton rbBidireccional;
	private ButtonGroup G1;
	private JTextField txVertice;
	private JTextField txPesoVertice;

	public VentanaPrincipal() {
		controlador = new Controlador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tablero principal");
		lblNewLabel.setBounds(346, 25, 239, 26);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 74, 851, 352);
		contentPane.add(scrollPane);

		panel = new PanelGrafo();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Panel de opciones");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(346, 441, 224, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Arista");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(40, 454, 90, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Vertice Origen ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(40, 499, 109, 14);
		contentPane.add(lblNewLabel_3);

		txVerticeOrigen = new JTextField();
		txVerticeOrigen.setBounds(40, 524, 86, 20);
		contentPane.add(txVerticeOrigen);
		txVerticeOrigen.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Vertice Destino");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(168, 499, 142, 15);
		contentPane.add(lblNewLabel_4);

		txVerticeDestino = new JTextField();
		txVerticeDestino.setColumns(10);
		txVerticeDestino.setBounds(168, 524, 86, 20);
		contentPane.add(txVerticeDestino);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(40, 593, 89, 23);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarVertice(e);
			}
		});

		rbDireccional = new JRadioButton("direccional");
		rbDireccional.setBounds(40, 551, 109, 23);
		contentPane.add(rbDireccional);

		rbBidireccional = new JRadioButton("bidireccional");
		rbBidireccional.setBounds(168, 551, 109, 23);
		contentPane.add(rbBidireccional);

		G1 = new ButtonGroup();
		G1.add(rbBidireccional);
		G1.add(rbDireccional);
		
		JLabel lbLimipar = new JLabel("Limpiar Grafo ");
		lbLimipar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbLimipar.setBounds(792, 500, 109, 14);
		contentPane.add(lbLimipar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(792, 523, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnEliminarArista = new JButton("Eliminar");
		btnEliminarArista.setBounds(168, 593, 89, 23);
		contentPane.add(btnEliminarArista);
		btnEliminarArista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarArista(e);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Vertice");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(474, 499, 73, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnEliminarVertice = new JButton("Eliminar");
		btnEliminarVertice.setBounds(472, 551, 89, 23);
		contentPane.add(btnEliminarVertice);
		btnEliminarVertice.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarVertice(e);
			}
		});
		
		txVertice = new JTextField();
		txVertice.setColumns(10);
		txVertice.setBounds(472, 524, 86, 20);
		contentPane.add(txVertice);
		
		JLabel lblNewLabel_4_1 = new JLabel("Vertice peso");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(291, 499, 142, 15);
		contentPane.add(lblNewLabel_4_1);
		
		txPesoVertice = new JTextField();
		txPesoVertice.setColumns(10);
		txPesoVertice.setBounds(291, 524, 86, 20);
		contentPane.add(txPesoVertice);
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarGrafo(e);
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				actionMouse(e);
			}
		});
	}
	
	public void eliminarVertice(ActionEvent e) {
		int vertice = Integer.parseInt(txVertice.getText());
		controlador.eliminarVertice(vertice);
		panel.circulo(controlador.getGrafo());
	}

	public void actionMouse(MouseEvent event) {
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del vertice"));
		Nodo nod = new Nodo(event.getX() - 10, event.getY() - 10, valor);
		try {
			controlador.agregar(nod);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		panel.circulo(controlador.getGrafo());
	}

	public void agregarVertice(ActionEvent e) {
		int verticeOrigen = Integer.parseInt(txVerticeOrigen.getText());
		int verticeDestino = Integer.parseInt(txVerticeDestino.getText());
		int pesoVertice = Integer.parseInt(txPesoVertice.getText());
		try {
			if(rbDireccional.isSelected()) {
				controlador.agregarArista(verticeOrigen, verticeDestino, true,pesoVertice);
			}else {
				controlador.agregarArista(verticeOrigen, verticeDestino, false,pesoVertice);
			}
			panel.circulo(controlador.getGrafo());
		} catch (RuntimeException e2) {
			JOptionPane.showMessageDialog(null,e2.getMessage());
		}
		
		
	}
	
	public void eliminarArista(ActionEvent e) {
		int verticeOrigen = Integer.parseInt(txVerticeOrigen.getText());
		int verticeDestino = Integer.parseInt(txVerticeDestino.getText());
		try {
			if(rbDireccional.isSelected()) {
				controlador.eliminarArista(verticeOrigen, verticeDestino, true);
			}else {
				controlador.eliminarArista(verticeOrigen, verticeDestino, false);
			}
			panel.circulo(controlador.getGrafo());
		} catch (RuntimeException e2) {
			JOptionPane.showMessageDialog(null,e2.getMessage());
		}
	}
	
	public void limpiarGrafo(ActionEvent e) {
		controlador.shortPathGra(1, 10);
		//controlador = new Controlador();
		//panel.circulo(controlador.getGrafo());
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
