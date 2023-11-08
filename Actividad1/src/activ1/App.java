package activ1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton botonCalc = new JButton("Calculadora");
		botonCalc.setIcon(new ImageIcon("C:\\Users\\jmolina1094\\Downloads\\calculadora.png"));
		String rutaCalc="\"C:\\WINDOWS\\System32\\Calc";;
		LanzadorProcesos lp = new LanzadorProcesos();
		botonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp.ejecuar(rutaCalc);
				
			}
		});
		botonCalc.setBounds(163, 11, 197, 79);
		frame.getContentPane().add(botonCalc);
		
		JButton botonBloc = new JButton("Bloc de notas");
		botonBloc.setIcon(new ImageIcon("C:\\Users\\jmolina1094\\Downloads\\notas.png"));
		String rutaBloc="\"C:\\Program Files\\Notepad++\\notepad++.exe\"";
		botonBloc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lp.ejecuar(rutaBloc);
				
			}
		});
		botonBloc.setBounds(163, 125, 197, 79);
		frame.getContentPane().add(botonBloc);
		
	}
}
