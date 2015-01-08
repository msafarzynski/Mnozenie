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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Cursor;
import java.awt.ComponentOrientation;

import javax.swing.border.BevelBorder;

public class Window {

	private JFrame frame;
	private Slider slider1;
	private Slider slider2;
	private Plansza plansza;
	private Slide slide;
	protected int slider1Value;
	protected int slider2Value;
	String player1Name = "Gracz 1", player2Name = "Gracz 2";
	protected Owner turn = Owner.PLAYER1;			//na razie z zalozenia zawsze zaczyna player1
	boolean firstMove = true;						//pierwszy ruch nie wprowadza zmian na planszy
	boolean kom = true;
	
	class SliderListener implements ChangeListener{
		int s1, s2;
		public void stateChanged(ChangeEvent e) {
			int a;
			if((!slider1.getValueIsAdjusting())&&(!slider2.getValueIsAdjusting())){
				s1 = slider1.getValue();
				s2 = slider2.getValue();
				a = s1*s2;
				if(kom){
					if(plansza.isInUse(a)){							//jezeli kafelek juz jest przez kogos zajety to pojawia sie komunikat i 
							JOptionPane.showMessageDialog(frame,	//slidery wracaja do poprzedniego stanu
									"Niepoprawny ruch", "Blad",	//tura nie jest zmieniana - ten sam gracz znow wybiera numer
									JOptionPane.PLAIN_MESSAGE);
						kom = false;
						if(e.getSource() == slider1)
							slider1.setValue(slider1Value);
						else
							slider2.setValue(slider2Value);
						kom = true;
						return;
					}
					slider1Value = s1;
					slider2Value = s2;
					if(firstMove){
						firstMove = false;
						return;
					}
					plansza.setInUse(a, turn);
					if(turn==Owner.PLAYER1)	turn = Owner.PLAYER2;
					else turn = Owner.PLAYER1;
				}
			}
		}
		
	};


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
		
		plansza = new Plansza();
		plansza.setLocation(230, 100);
		panel.add(plansza);
		
		slider1 = new Slider();
		slider1.setBounds(215, 405, 330, 35);
		panel.add(slider1);
		
		
		slider2 = new Slider();
		slider2.setBounds(215, 485, 330, 35);
		panel.add(slider2);
		
		slide = new Slide();
		slide.setLocation(200, 436);
		slide.setSize(360, 40);
		panel.add(slide);
		
		
		//turn = Player.PLAYER1;
		//firstMove = true;
		
		slider1Value = slider1.getValue();
		slider2Value = slider2.getValue();
		
		//turn = Player.PLAYER1;
		//firstMove = true
		
		slider1.addChangeListener(new SliderListener());
		slider2.addChangeListener(new SliderListener());
		
		player1Name = JOptionPane.showInputDialog(frame, "Wpisz nazwe gracza 1", "Gracz 1");
		player2Name = JOptionPane.showInputDialog(frame, "Wpisz nazwe gracza 2", "Gracz 2");
		
	}
}

class Slider extends JSlider{
	public Slider(){
		setOpaque(false);
		setSnapToTicks(true);
		setMinorTickSpacing(1);
		setMinimum(1);
		setMaximum(9);
	}	
}

//--------------------------------------------------------------------------------------------------------------------------
class Slide extends JPanel{
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	
	public Slide(){
		super();
		setBounds(155, 436, 450, 50);
		setLayout(new GridLayout(1, 9, 0, 0));
		
		label = new JLabel("1");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label.setBackground(Color.LIGHT_GRAY);
		add(label);
		
		label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_1.setBackground(Color.LIGHT_GRAY);
		add(label_1);
		
		label_2 = new JLabel("3");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setOpaque(true);
		label_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_2.setBackground(Color.LIGHT_GRAY);
		add(label_2);
		
		label_3 = new JLabel("4");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setOpaque(true);
		label_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_3.setBackground(Color.LIGHT_GRAY);
		add(label_3);
		
		label_4 = new JLabel("5");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setOpaque(true);
		label_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_4.setBackground(Color.LIGHT_GRAY);
		add(label_4);
		
		label_5 = new JLabel("6");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setOpaque(true);
		label_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_5.setBackground(Color.LIGHT_GRAY);
		add(label_5);
		
		label_6 = new JLabel("7");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setOpaque(true);
		label_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_6.setBackground(Color.LIGHT_GRAY);
		add(label_6);
		
		label_7 = new JLabel("8");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setHorizontalTextPosition(SwingConstants.CENTER);
		label_7.setOpaque(true);
		label_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_7.setBackground(Color.LIGHT_GRAY);
		add(label_7);
		
		label_8 = new JLabel("9");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setHorizontalTextPosition(SwingConstants.CENTER);
		label_8.setOpaque(true);
		label_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_8.setBackground(Color.LIGHT_GRAY);
		add(label_8);
	}
}