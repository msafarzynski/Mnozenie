package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

//-------------------------------------------------PLANSZA---------------------------------------------------

public class Plansza extends JPanel{
	Kafelek[][] kafelki = new Kafelek [6][6];
	
	
	public Plansza(){
		super();
		setBounds(229, 125, 300, 300);
		setLayout(new GridLayout(6, 6, 0, 0));
		dodajKafle();
	}
	
	/**
	 * Tworzenie i dodawanie do tablicy i planszy nowych kafli
	 */
	void dodajKafle(){
		for(int x=0; x<6; x++)
			for(int y=0; y<6; y++){
				int a = Functions.numerKafla(x, y);
				kafelki[y][x] = new Kafelek(Integer.toString(a));
				add(kafelki[y][x]);
			}
	}
	
	

	/**
	 * Sprawdza czy kafel jest juz zajety
	 * @param a		liczba ktora jest na kaflu
	 * @return		prawde jezeli jest zajety wpp falsz
	 */
	boolean isInUse(int a){
		Pair p = Functions.indexKafla(a);
		if(kafelki[p.x][p.y].isInUse())
			return true;
		return false;
	}
	
	/**
	 * Ustawia kafel jako zajety
	 * @param a			liczba ktora jest na kaflu
	 * @param player	przez ktorego gracza ma zostac zajety kafel
	 */
	void setInUse(int a, Owner player){
		Pair p = Functions.indexKafla(a);
		if(player == Owner.PLAYER1)
			kafelki[p.x][p.y].setInUse(Color.MAGENTA);
		else
			kafelki[p.x][p.y].setInUse(Color.ORANGE);
	}
}


//-----------------------------------------------------KAFELEK----------------------------------------------------
class Kafelek extends JLabel{
	boolean inUse = false;
	public Kafelek(){
		super();
	}
	public Kafelek(String s){
		super(s);
		setFont(new Font("Lucida Grande", Font.BOLD, 14));
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createRaisedSoftBevelBorder());
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * Sprawdza czy kafel jest juz zajety
	 * @return	prawda jesli kafel zajety wpp falsz
	 */
	boolean isInUse(){
		if(inUse)
			return true;
		return false;
	}
	
	/**
	 * Ustawia kafel jako zajety
	 * @param c		kolor gracza na jaki ma zostac zamalowany kafel
	 */
	void setInUse(Color c){
		setBackground(c);
		inUse = true;
	}
}
