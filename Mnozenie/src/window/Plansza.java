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
	//Kafelek[] kafelki = new Kafelek[36];
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
				int a = numerKafla(x, y);
				kafelki[y][x] = new Kafelek(Integer.toString(a));
				add(kafelki[y][x]);
			}
	}
	
	/**
	 * Funkcja ktora wylicza jaki numer powinien byc na kafelku
	 * @param x		wspolrzedna x w tablicy kafelkow
	 * @param y		wspolrzedna y w tablicy kafelkow
	 * @return		numer na kaflu
	 */
	int numerKafla(int x, int y){
		switch(x){
		case 0:
			switch(y){
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 5;
			case 5:
				return 6;
			}
		case 1:
			switch(y){
			case 0:
				return 7;
			case 1:
				return 8;
			case 2:
				return 9;
			case 3:
				return 10;
			case 4:
				return 12;
			case 5:
				return 14;
			}
		case 2:
			switch(y){
			case 0:
				return 15;
			case 1:
				return 16;
			case 2:
				return 18;
			case 3:
				return 20;
			case 4:
				return 21;
			case 5:
				return 24;
			}
		case 3:
			switch(y){
			case 0:
				return 25;
			case 1:
				return 27;
			case 2:
				return 28;
			case 3:
				return 30;
			case 4:
				return 32;
			case 5:
				return 35;
			}
		case 4:
			switch(y){
			case 0:
				return 36;
			case 1:
				return 40;
			case 2:
				return 42;
			case 3:
				return 45;
			case 4:
				return 48;
			case 5:
				return 49;
			}
		case 5:
			switch(y){
			case 0:
				return 54;
			case 1:
				return 56;
			case 2:
				return 63;
			case 3:
				return 64;
			case 4:
				return 72;
			case 5:
				return 81;
			}
		}
		return 0;
		/*if(i>=1 && i<=10)	return i;
		else if(i==11) return 12;
		else if(i>11 && i<=14) return i+2;
		else if(i==15)	return 18;
		else if(i==16 || i==17)	return i+4;
		else if(i==18 || i==19)	return i+6;
		else if(i==20 || i==21)	return i+7;
		else if(i==22)	return 30;
		else if(i==23)	return 32;
		else if(i==24 || i==25)		return i+11;
		else if(i==26)	return 40;
		else if(i==27)	return 42;
		else if(i==28)	return 45;
		else if(i==29 || i==30)		return i+19;
		else if(i==31)	return 54;
		else if(i==32)	return 56;
		else if(i==33 || i==34)	return i+30;
		else if(i==35)		return 72;
		else	return 81;
		*/
		
	}
	
	/**
	 * Funkcja ktora wylicza wspolrzadne w tablicy kafelkow 6x6
	 * @param i		liczba ktora jest na kaflu - wynik mnozenia
	 * @return		klasa Pair - wspolrzedne x i y w tablicy kafli
	 */
	Pair indexKafla(int i){
		switch(i){
		case 1:
			return new Pair(0,0);
		case 2:
			return new Pair(1,0);
		case 3:
			return new Pair(2,0);
		case 4:
			return new Pair(3,0);
		case 5:
			return new Pair(4,0);
		case 6:
			return new Pair(5,0);
		case 7:
			return new Pair(0,1);
		case 8:
			return new Pair(1,1);
		case 9:
			return new Pair(2,1);
		case 10:
			return new Pair(3,1);
		case 12:
			return new Pair(4,1);
		case 14:
			return new Pair(5,1);
		case 15:
			return new Pair(0,2);
		case 16:
			return new Pair(1,2);
		case 18:
			return new Pair(2,2);
		case 20:
			return new Pair(3,2);
		case 21:
			return new Pair(4,2);
		case 24:
			return new Pair(5,2);
		case 25:
			return new Pair(0,3);
		case 27:
			return new Pair(1,3);
		case 28:
			return new Pair(2,3);
		case 30:
			return new Pair(3,3);
		case 32:
			return new Pair(4,3);
		case 35:
			return new Pair(5,3);
		case 36:
			return new Pair(0,4);
		case 40:
			return new Pair(1,4);
		case 42:
			return new Pair(2,4);
		case 45:
			return new Pair(3,4);
		case 48:
			return new Pair(4,4);
		case 49:
			return new Pair(5,4);
		case 54:
			return new Pair(0,5);
		case 56:
			return new Pair(1,5);
		case 63:
			return new Pair(2,5);
		case 64:
			return new Pair(3,5);
		case 72:
			return new Pair(4,5);
		case 81:
			return new Pair(5,5);
		}
		return null;
		/*if(i>=1 && i<=10)	return i-1;
		else if(i==12) return 10;
		else if(i>=14 && i<=16) return i-3;
		else if(i==18)	return 14;
		else if(i==20 || i==21)	return i-5;
		else if(i==24 || i==25)	return i-7;
		else if(i==27 || i==28)	return i-8;
		else if(i==30)	return 21;	//
		else if(i==32)	return 22;	//
		else if(i==35 || i==36)		return i-12;
		else if(i==40)	return 25;
		else if(i==42)	return 26;
		else if(i==45)	return 27;
		else if(i==48 || i==49)		return i-20;
		else if(i==54)	return 30;
		else if(i==56)	return 31;
		else if(i==63 || i==64)	return i-31;
		else if(i==72)		return 34;
		else	return 35;
		*/	
		
	}

	/**
	 * Sprawdza czy kafel jest juz zajety
	 * @param a		liczba ktora jest na kaflu
	 * @return		prawde jezeli jest zajety wpp falsz
	 */
	boolean isInUse(int a){
		Pair p = indexKafla(a);
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
		Pair p = indexKafla(a);
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
