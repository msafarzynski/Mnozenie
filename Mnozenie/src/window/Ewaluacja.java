package window;

public class Ewaluacja {
	protected int slider1Value = 0;
	protected int slider2Value = 0;
	protected Owner[][] plansza = new Owner[6][6];
	protected Owner turn;
	
 	public Ewaluacja(){
		for(int i = 0 ; i < 6; i++)
			for(int j = 0; j < 6; j++)
				plansza[i][j] = Owner.NONE;
	}
	
	int getSlider1Value(){
		return slider1Value;
	}
	
	int getSlider2Value(){
		return slider2Value;
	}
	
	void setSlider1Value(int a){
		slider1Value = a;
	}
	
	void setSlider2Value(int a){
		slider2Value = a;
	}
	
	void setTurn(Owner player){
		turn = player;
	}
	
	Owner getTurn(){
		return turn;
	}
	
	/**
	 * Ustawia kto zajmuje dane pole na planszy
	 * @param a			liczba na kaflu
	 * @param owner		kto ma zajac pole
	 */
	void setOwner(int a, Owner owner){
		Pair p = Functions.indexKafla(a);
		plansza[p.x][p.y] = owner;
	}
	
	/**
	 * Wyswietla plansze ewaluacji w konsoli
	 */
	void showBoard(){
		for(int y = 0; y < 6; y++){
			for(int x = 0; x < 6; x++){
				System.out.print(plansza[x][y]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	/**
	 * Sprawdza czy gracz wygral
	 * @param a			ostatnio zaznaczony kafelek
	 * @param player	gracz ktory wykonal ruch
	 * @return			prawda jesli gracz ma 4 swoje kafle w linii wpp falsz
	 */
	boolean isWinner(int a, Owner player){
		Pair p = Functions.indexKafla(a);
		int count, x, y;
		boolean isGroup;
		
		//trzeba sprawdzic w poziomie a potem pionie
		
		//poziom
		count = 1;
		isGroup = true;
		boolean right_down = true;			//w prawo lub lewo -> 0, 1, dol lub gora -> 0, 1
		x = p.x+1;
		y = p.y;
		while(isGroup && count!=4){		//w prawo i lewo
			if(x>5){
				right_down = false;
				x = p.x-1;
			}
			if(x<0)
				break;
			if(plansza[x][y] == player){
				if(right_down)
					x++;
				else
					x--;
				count++;
				
			}
			else
				if(right_down){
					right_down = false;
					x = p.x-1;
				}
				else
					isGroup = false;
		}
		if(count == 4)
			return true;
		
		isGroup = true;
		count = 1;
		right_down = true;
		x = p.x;
		y = p.y+1;
		while(isGroup && count!=4){		//w prawo i lewo
			if(y>5){
				right_down = false;
				y = p.y-1;
			}
			if(y<0)
				break;
			if(plansza[x][y] == player){
				if(right_down)
					y++;
				else
					y--;
				count++;
				
			}
			else
				if(right_down){
					right_down = false;
					y = p.y-1;
				}
				else
					isGroup = false;
		}
		if(count == 4)
			return true;
		return false;
	}
}
