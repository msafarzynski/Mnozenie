package window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class Plansza extends JPanel{
	Kafelek[] kafelki = new Kafelek[36];
	
	public Plansza(){
		super();
		setBounds(229, 125, 300, 300);
		setLayout(new GridLayout(6, 6, 0, 0));
		DodajKafle();
	}
	
	void DodajKafle(){
		int x;
		for(int i=0; i<36;i++){
			//kafelki[i].Init(Integer.toString(IndexKafla(i)));
			x = IndexKafla(i+1);
			kafelki[i] = new Kafelek(Integer.toString(x));
			add(kafelki[i]);
		}
	}
	int IndexKafla(int i){
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
}

class Kafelek extends JLabel{
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
}
