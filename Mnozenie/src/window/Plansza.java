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
	Kafelek[] kafelki = new Kafelek[36];
	
	public Plansza(){
		super();
		setBounds(229, 125, 300, 300);
		setLayout(new GridLayout(6, 6, 0, 0));
		dodajKafle();
	}
	
	void dodajKafle(){
		int x;
		for(int i=0; i<36;i++){
			//kafelki[i].Init(Integer.toString(IndexKafla(i)));
			x = numerKafla(i+1);
			kafelki[i] = new Kafelek(Integer.toString(x));
			add(kafelki[i]);
		}
	}
	
	int numerKafla(int i){
		if(i>=1 && i<=10)	return i;
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
		
	}
	
	int indexKafla(int i){
		if(i>=1 && i<=10)	return i-1;
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
	
		
	}

	
	boolean isInUse(int a){
		if(kafelki[indexKafla(a)].isInUse())
			return true;
		return false;
	}
	
	void setInUse(int a, Player player){
		if(player == Player.PLAYER1)
			kafelki[indexKafla(a)].setInUse(Color.MAGENTA);
		else
			kafelki[indexKafla(a)].setInUse(Color.ORANGE);
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
	boolean isInUse(){
		if(inUse)
			return true;
		return false;
	}
	void setInUse(Color c){
		setBackground(c);
		inUse = true;
	}
}
