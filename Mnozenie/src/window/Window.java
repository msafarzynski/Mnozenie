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
		frame.setBounds(100, 100, 780, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel plansza = new JPanel();
		plansza.setBounds(229, 125, 300, 300);
		panel.add(plansza);
		plansza.setLayout(new GridLayout(6, 6, 0, 0));
		
		JLabel lbl1 = new JLabel("1");
		lbl1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl1.setOpaque(true);
		lbl1.setBackground(Color.MAGENTA);
		lbl1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl1);
		
		JLabel lbl2 = new JLabel("2");
		lbl2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl2.setBackground(Color.LIGHT_GRAY);
		lbl2.setOpaque(true);
		lbl2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl2);
		
		JLabel lbl3 = new JLabel("3");
		lbl3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl3.setBackground(Color.LIGHT_GRAY);
		lbl3.setOpaque(true);
		lbl3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl3);
		
		JLabel lbl4 = new JLabel("4");
		lbl4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl4.setBackground(Color.LIGHT_GRAY);
		lbl4.setOpaque(true);
		lbl4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl4);
		
		JLabel lbl5 = new JLabel("5");
		lbl5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl5.setBackground(Color.LIGHT_GRAY);
		lbl5.setOpaque(true);
		lbl5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl5);
		
		JLabel lbl6 = new JLabel("6");
		lbl6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl6.setBackground(Color.LIGHT_GRAY);
		lbl6.setOpaque(true);
		lbl6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl6);
		
		JLabel lbl7 = new JLabel("7");
		lbl7.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl7.setBackground(Color.LIGHT_GRAY);
		lbl7.setOpaque(true);
		lbl7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl7);
		
		JLabel lbl8 = new JLabel("8");
		lbl8.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl8.setBackground(Color.LIGHT_GRAY);
		lbl8.setOpaque(true);
		lbl8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl8);
		
		JLabel lbl9 = new JLabel("9");
		lbl9.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl9.setBackground(Color.ORANGE);
		lbl9.setOpaque(true);
		lbl9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl9);
		
		JLabel lbl10 = new JLabel("10");
		lbl10.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl10.setBackground(Color.LIGHT_GRAY);
		lbl10.setOpaque(true);
		lbl10.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl10);
		
		JLabel lbl12 = new JLabel("12");
		lbl12.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl12.setBackground(Color.LIGHT_GRAY);
		lbl12.setOpaque(true);
		lbl12.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl12);
		
		JLabel lbl14 = new JLabel("14");
		lbl14.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl14.setBackground(Color.LIGHT_GRAY);
		lbl14.setOpaque(true);
		lbl14.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl14);
		
		JLabel lbl15 = new JLabel("15");
		lbl15.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl15.setBackground(Color.LIGHT_GRAY);
		lbl15.setOpaque(true);
		lbl15.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl15);
		
		JLabel lbl16 = new JLabel("16");
		lbl16.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl16.setBackground(Color.LIGHT_GRAY);
		lbl16.setOpaque(true);
		lbl16.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl16.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl16);
		
		JLabel lbl18 = new JLabel("18");
		lbl18.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl18.setBackground(Color.LIGHT_GRAY);
		lbl18.setOpaque(true);
		lbl18.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl18.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl18);
		
		JLabel lbl20 = new JLabel("20");
		lbl20.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl20.setBackground(Color.LIGHT_GRAY);
		lbl20.setOpaque(true);
		lbl20.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl20.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl20);
		
		JLabel lbl21 = new JLabel("21");
		lbl21.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl21.setBackground(Color.LIGHT_GRAY);
		lbl21.setOpaque(true);
		lbl21.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl21);
		
		JLabel lbl24 = new JLabel("24");
		lbl24.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl24.setBackground(Color.LIGHT_GRAY);
		lbl24.setOpaque(true);
		lbl24.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl24.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl24);
		
		JLabel lbl25 = new JLabel("25");
		lbl25.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl25.setBackground(Color.LIGHT_GRAY);
		lbl25.setOpaque(true);
		lbl25.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl25.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl25);
		
		JLabel lbl27 = new JLabel("27");
		lbl27.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl27.setBackground(Color.LIGHT_GRAY);
		lbl27.setOpaque(true);
		lbl27.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl27.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl27);
		
		JLabel lbl28 = new JLabel("28");
		lbl28.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl28.setBackground(Color.LIGHT_GRAY);
		lbl28.setOpaque(true);
		lbl28.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl28.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl28);
		
		JLabel lbl30 = new JLabel("30");
		lbl30.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl30.setBackground(Color.LIGHT_GRAY);
		lbl30.setOpaque(true);
		lbl30.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl30.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl30);
		
		JLabel lbl32 = new JLabel("32");
		lbl32.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl32.setBackground(Color.LIGHT_GRAY);
		lbl32.setOpaque(true);
		lbl32.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl32.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl32);
		
		JLabel lbl35 = new JLabel("35");
		lbl35.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl35.setBackground(Color.LIGHT_GRAY);
		lbl35.setOpaque(true);
		lbl35.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl35.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl35);
		
		JLabel lbl36 = new JLabel("36");
		lbl36.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl36.setBackground(Color.LIGHT_GRAY);
		lbl36.setOpaque(true);
		lbl36.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl36.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl36);
		
		JLabel lbl40 = new JLabel("40");
		lbl40.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl40.setBackground(Color.LIGHT_GRAY);
		lbl40.setOpaque(true);
		lbl40.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl40.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl40);
		
		JLabel lbl42 = new JLabel("42");
		lbl42.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl42.setBackground(Color.LIGHT_GRAY);
		lbl42.setOpaque(true);
		lbl42.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl42);
		
		JLabel lbl45 = new JLabel("45");
		lbl45.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl45.setBackground(Color.LIGHT_GRAY);
		lbl45.setOpaque(true);
		lbl45.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl45.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl45);
		
		JLabel lbl48 = new JLabel("48");
		lbl48.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl48.setBackground(Color.LIGHT_GRAY);
		lbl48.setOpaque(true);
		lbl48.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl48.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl48);
		
		JLabel lbl49 = new JLabel("49");
		lbl49.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl49.setBackground(Color.LIGHT_GRAY);
		lbl49.setOpaque(true);
		lbl49.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl49.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl49);
		
		JLabel lbl54 = new JLabel("54");
		lbl54.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl54.setBackground(Color.LIGHT_GRAY);
		lbl54.setOpaque(true);
		lbl54.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl54.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl54);
		
		JLabel lbl56 = new JLabel("56");
		lbl56.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl56.setBackground(Color.LIGHT_GRAY);
		lbl56.setOpaque(true);
		lbl56.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl56.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl56);
		
		JLabel lbl63 = new JLabel("63");
		lbl63.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl63.setBackground(Color.LIGHT_GRAY);
		lbl63.setOpaque(true);
		lbl63.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl63.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl63);
		
		JLabel lbl64 = new JLabel("64");
		lbl64.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl64.setBackground(Color.LIGHT_GRAY);
		lbl64.setOpaque(true);
		lbl64.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl64.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl64);
		
		JLabel lbl72 = new JLabel("72");
		lbl72.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl72.setBackground(Color.LIGHT_GRAY);
		lbl72.setOpaque(true);
		lbl72.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl72.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl72);
		
		JLabel lbl81 = new JLabel("81");
		lbl81.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl81.setBackground(Color.LIGHT_GRAY);
		lbl81.setOpaque(true);
		lbl81.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl81.setHorizontalAlignment(SwingConstants.CENTER);
		plansza.add(lbl81);
		
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
							lbl1.setBackground(Color.magenta);
						case 64:
							lbl64.setBackground(Color.magenta);
							break;
						default:
							break;
					}
				}
			}
		});
		
	}
}
