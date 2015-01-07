package window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Window {

	private JFrame frame;
	private JSlider slider1;
	private JSlider slider2;
	private Plansza plansza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
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
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 780, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		/*JPanel plansza = new JPanel();
		plansza.setBounds(229, 125, 300, 300);
		panel.add(plansza);
		plansza.setLayout(new GridLayout(6, 6, 0, 0));
		*/
		plansza = new Plansza();
		panel.add(plansza);
	
		slider1 = new JSlider();
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(1);
		slider1.setSnapToTicks(true);
		slider1.setMinorTickSpacing(1);
		slider1.setMinimum(1);
		slider1.setMaximum(9);
		slider1.setBounds(274, 437, 190, 35);
		panel.add(slider1);
		
		slider2 = new JSlider();
		slider2.setPaintLabels(true);
		slider2.setMinimum(1);
		slider2.setMaximum(9);
		slider2.setMajorTickSpacing(1);
		slider2.setSnapToTicks(true);
		slider2.setBounds(274, 475, 190, 44);
		panel.add(slider2);
		
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int a = slider1.getValue();
				int b = slider2.getValue();
				int y = a*b;
				if(!slider1.getValueIsAdjusting()){
					switch(y){
						case 1:
							break;
						case 64:
							break;
						default:
							break;
					}
				}
			}
		});
		
	}
//--------------------------------------------------------------------------------------
}
