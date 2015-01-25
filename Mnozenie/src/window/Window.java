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
import javax.swing.JTextArea;

public class Window {

	private JFrame frame;
	private JPanel panel;
	private Slider slider1;
	private Slider slider2;
	private Plansza plansza;
	private Slide slide;
	protected Ewaluacja ewaluacja;
	private Minmax minmax = new Minmax();
	private State state;
	String player1Name = "Gracz";
	String player2Name = "Komputer";
	//protected Owner turn = Owner.PLAYER1;			//na razie z zalozenia zawsze zaczyna player1
	boolean firstMove = true;						//pierwszy ruch nie wprowadza zmian na planszy
	boolean kom = true;
	int mode;						//mode=0 tryb gracz vs bot, mode=1 tryb bot vs bot
	private JTextArea textArea;
	
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
									"Niepoprawny ruch", "Blad",		//tura nie jest zmieniana - ten sam gracz znow wybiera numer
									JOptionPane.PLAIN_MESSAGE);
						kom = false;
						if(e.getSource() == slider1)
							slider1.setValue(ewaluacja.getSlider1Value());
						else
							slider2.setValue(ewaluacja.getSlider2Value());
						kom = true;
						return;
					}
					ewaluacja.setSlider1Value(s1);
					ewaluacja.setSlider2Value(s2);
					if(firstMove){
						firstMove = false;
						ewaluacja.setTurn(Owner.PLAYER1);
						return;
					}
					plansza.setInUse(a, ewaluacja.getTurn());
					ewaluacja.setOwner(a, ewaluacja.getTurn());
					textArea.setText(textArea.getText()+"\n"+(ewaluacja.getTurn()==Owner.PLAYER1 ? player1Name : player2Name)+": "+a);
					if(ewaluacja.isWinner(a, ewaluacja.getTurn())){
						if(ewaluacja.getTurn()==Owner.PLAYER1)
							JOptionPane.showMessageDialog(frame,
									"Wygrywa "+player1Name, "Wygrana",
									JOptionPane.PLAIN_MESSAGE);
						else
							JOptionPane.showMessageDialog(frame,
									"Wygrywa "+player2Name, "Wygrana",
									JOptionPane.PLAIN_MESSAGE);
					}
					if(ewaluacja.getTurn()==Owner.PLAYER1)	ewaluacja.setTurn(Owner.PLAYER2);
					else ewaluacja.setTurn(Owner.PLAYER1);
					ewaluacja.showBoard();
					if(ewaluacja.getTurn()==Owner.PLAYER2 && mode==0){			//jezeli teraz jest tura bota
						state = new State(s1,s2,ewaluacja.getBoard(), ewaluacja.getTurn());
						State nextState = minmax.minMaxStep(state, 2);
						nextState.showBoard();
						if(s1!=nextState.slider1Value){
							slider1.setValue(nextState.slider1Value);
					//		ewaluacja.setSlider2Value(nextState.slider2Value);
						}
						if(s2!=nextState.slider2Value){
							slider2.setValue(nextState.slider2Value);
					//		ewaluacja.setSlider1Value(nextState.slider1Value);
						}
					}
					
					
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
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.add(plansza);	
		
		panel.add(slider1);
				
		panel.add(slider2);
			
		panel.add(slide);
		
		JLabel lblPlayer1 = new JLabel(player1Name);
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setForeground(Color.BLACK);
		lblPlayer1.setOpaque(true);
		lblPlayer1.setBackground(Color.MAGENTA);
		lblPlayer1.setBounds(41, 151, 150, 50);
		panel.add(lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel(player2Name);
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setForeground(Color.BLACK);
		lblPlayer2.setOpaque(true);
		lblPlayer2.setBackground(Color.ORANGE);
		lblPlayer2.setBounds(41, 251, 150, 50);
		panel.add(lblPlayer2);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(569, 100, 175, 300);
		panel.add(textArea);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 780, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		plansza = new Plansza();
		plansza.setLocation(230, 100);
		
		slider1 = new Slider();
		slider1.setBounds(215, 405, 330, 35);
		
		slider2 = new Slider();
		slider2.setBounds(215, 485, 330, 35);
		
		slide = new Slide();
		slide.setLocation(200, 436);
		slide.setSize(360, 40);
		
		ewaluacja = new Ewaluacja();
		
		//TODO: kto zaczyna gre - chcemy miec wybor do testow
		ewaluacja.setTurn(Owner.PLAYER2);
		
		ewaluacja.setSlider1Value(slider1.getValue());
		ewaluacja.setSlider2Value(slider2.getValue());
		
		//turn = Player.PLAYER1;
		//firstMove = true
		
		slider1.addChangeListener(new SliderListener());
		slider2.addChangeListener(new SliderListener());
		
		String[] options = {"Gracz vs bot", "Bot vs bot"};
		mode = JOptionPane.showOptionDialog(frame, "Wybierz tryb gry", "Wybierz tryb", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
		if(mode==0)
			player1Name = JOptionPane.showInputDialog(frame, "Wpisz nazwe gracza", "Gracz");
		JOptionPane.showMessageDialog(frame, "Zaczyna "+(ewaluacja.getTurn()==Owner.PLAYER1 ? player1Name : player2Name));
		
		state = new State(9,9,ewaluacja.getBoard(), ewaluacja.getTurn());
		State nextState = minmax.minMaxStep(state, 2);
		nextState.showBoard();
		if(ewaluacja.getSlider1Value()==nextState.slider1Value){
			slider2.setValue(nextState.slider2Value);
	//		ewaluacja.setSlider2Value(nextState.slider2Value);
		}
		else{
			slider1.setValue(nextState.slider1Value);
	//		ewaluacja.setSlider1Value(nextState.slider1Value);
		}
		
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