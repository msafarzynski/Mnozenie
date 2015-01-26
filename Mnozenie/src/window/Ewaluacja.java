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
	
	Owner[][] getBoard(){
		return plansza;
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
		System.out.println(evaluate(plansza));
	}
	
	void showCheckedBoard(boolean[][] plansza){
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
		while(isGroup && count!=4){		//w gore i dol
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
		
		isGroup = true;
		count = 1;
		right_down = true;
		x = p.x+1;
		y = p.y+1;
		while(isGroup && count!=4){		//na ukos prawo dol i lewo gora
			if(y>5 || x>5){
				right_down = false;
				y = p.y-1;
				x = p.x-1;
			}
			if(y<0 || x<0)
				break;
			if(plansza[x][y] == player){
				if(right_down){
					y++;
					x++;
				}
				else{
					y--;
					x--;
				}
				count++;
				
			}
			else
				if(right_down){
					right_down = false;
					y = p.y-1;
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
		x = p.x-1;
		y = p.y+1;
		while(isGroup && count!=4){		//na ukos lewo dol i prawo gora
			if(y>5 || x<0){
				right_down = false;
				y = p.y-1;
				x = p.x+1;
			}
			if(y<0 || x>5)
				break;
			if(plansza[x][y] == player){
				if(right_down){
					y++;
					x--;
				}
				else{
					y--;
					x++;
				}
				count++;
				
			}
			else
				if(right_down){
					right_down = false;
					y = p.y-1;
					x = p.x+1;
				}
				else
					isGroup = false;
		}
		if(count == 4)
			return true;
		
		return false;
	}
	
	
	static int evaluateDown(Owner[][]board, Owner player)
	{
		int tripleLinesCounter = 0;
		int doubleLinesCounter = 0;
		int singleElementCounter = 0;
	
	int row = 0;
	int column = 0;
	int tempColumn = 0;
	int tempRow = 0;
	int elementCounter = 0;

	boolean [][] checkedDown = new boolean[6][6];
	
	Owner content = player;
	
	for(column = 0;column<6;column++)
		{
			for(row = 0;row<6;row++)
			{
				if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedDown[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
			}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	checkedDown = new boolean[6][6];
	//System.out.println(tripleLinesCounter);
	//System.out.println(doubleLinesCounter);
	//System.out.println(singleElementCounter);
	
	return 1000*tripleLinesCounter+100*doubleLinesCounter+singleElementCounter;
	
	}
	
	static int evaluateRight(Owner[][]board, Owner player)
	{
		int tripleLinesCounter = 0;
		int doubleLinesCounter = 0;
		int singleElementCounter = 0;
	
	int row = 0;
	int column = 0;
	int tempColumn = 0;
	int tempRow = 0;
	int elementCounter = 0;
	
	boolean [][] checkedRight = new boolean[6][6];
	
	Owner content = player;
	
	for(row = 0;row<6;row++)for(column = 0;column<6;column++)
		{
		for(column = 0;column<6;column++)
			{
				if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedRight[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
			}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	checkedRight = new boolean[6][6];
	//System.out.println(tripleLinesCounter);
	//System.out.println(doubleLinesCounter);
	//System.out.println(singleElementCounter);
	return 1000*tripleLinesCounter+100*doubleLinesCounter+singleElementCounter;
	
	}

	static int evaluateDiagonalUp(Owner[][]board, Owner player)
	{
		int tripleLinesCounter = 0;
		int doubleLinesCounter = 0;
		int singleElementCounter = 0;
	
	int row = 0;
	int column = 0;
	int tempColumn = 0;
	int tempRow = 0;
	int elementCounter = 0;
	
	boolean [][] checkedDiagonal = new boolean[6][6];
	
	Owner content = player;
	
	for(int determinant = 0; determinant<6;determinant++)
	{for(row = determinant, column = 0;row>=0&&column <=determinant;row--, column++)
		{
		/////////for(/column = 0;column<=determinant;column++)
			{
			//System.out.println("determinant:"+determinant+"--------c:"+column+"r"+row);
			if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedDiagonal[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
			}
		}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	for(int beginant = 1; beginant<6;beginant++)
	{for(row = 5, column = beginant;row>=beginant&&column <=5;row--, column++)
		{
		/////////for(/column = 0;column<=determinant;column++)
			//System.out.println("beg:"+beginant+"--------c:"+column+"r"+row);
			if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedDiagonal[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
		}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	checkedDiagonal = new boolean[6][6];
	//System.out.println(tripleLinesCounter);
	//System.out.println(doubleLinesCounter);
	//System.out.println(singleElementCounter);
	
	return 1000*tripleLinesCounter+100*doubleLinesCounter+singleElementCounter;
	
	}
	
	
	static int evaluateDiagonalDown(Owner[][]board, Owner player)
	{
		int tripleLinesCounter = 0;
		int doubleLinesCounter = 0;
		int singleElementCounter = 0;
	
	int row = 0;
	int column = 0;
	int tempColumn = 0;
	int tempRow = 0;
	int elementCounter = 0;
	
	boolean [][] checkedDiagonal = new boolean[6][6];
	
	Owner content = player;
	
	for(int determinant = 5; determinant>0;determinant--)
	{for(row = 0, column = determinant;row<=5-determinant&&column<5;row++, column++)
		{
			{
			//System.out.println("determinant:"+determinant+"--------c:"+column+"r"+row);
			if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedDiagonal[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
			}
		}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	for(int beginant = 1; beginant<6;beginant++)
	{for(row = 5, column = beginant;row>=beginant&&column <=5;row--, column++)
		{
			//System.out.println("beg:"+beginant+"--------c:"+column+"r"+row);
			if(board[column][row]==content)
				{
					tempColumn = column;
					tempRow = row;
					//System.out.println("c:"+tempColumn+"r"+tempRow);
					checkedDiagonal[tempColumn][tempRow] = true;
					elementCounter++;
				}
				else 
					{
					
					switch (elementCounter){
					case 1:
						singleElementCounter++;
						break;
					case 2:
						doubleLinesCounter++;
						break;
					case 3:
						tripleLinesCounter++;
						break;
					case 4:
						return 100000;
					default:
						break;
					}
					elementCounter = 0;
					
					}
		}
				switch (elementCounter){
				case 1:
					singleElementCounter++;
					break;
				case 2:
					doubleLinesCounter++;
					break;
				case 3:
					tripleLinesCounter++;
					break;
				case 4:
					return 100000;
				default:
					break;
				}
			elementCounter = 0;
		}
	
	checkedDiagonal = new boolean[6][6];
	//System.out.println(tripleLinesCounter);
	//System.out.println(doubleLinesCounter);
	//System.out.println(singleElementCounter);
	
	return 1000*tripleLinesCounter+100*doubleLinesCounter+singleElementCounter;
	
	}


	static int evaluate(Owner[][] board)
	{
		return evaluateRight(board, Owner.PLAYER1)+evaluateDown(board, Owner.PLAYER1)+evaluateDiagonalUp(board, Owner.PLAYER1)+evaluateDiagonalDown(board, Owner.PLAYER1)-
				(evaluateRight(board, Owner.PLAYER2)+evaluateDown(board, Owner.PLAYER2)+evaluateDiagonalUp(board, Owner.PLAYER2)+evaluateDiagonalDown(board, Owner.PLAYER2));
	}
}
