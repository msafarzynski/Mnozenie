package window;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class State {
	
	protected int slider1Value ;
	protected int slider2Value ;
	protected Owner[][] plansza;
	protected Owner turn;
	

	public State(int slider1, int slider2, Owner[][]board, Owner turn)
	{
		this.slider1Value = slider1;
		this.slider2Value = slider2;
		this.plansza = new Owner[6][6];
			for(int i=0; i<board.length; i++)
				  for(int j=0; j<board[i].length; j++)
				    this.plansza[i][j]=board[i][j];
		this.turn = turn;
		
	}
	
	public State(State state)
	{
		this.slider1Value = state.getSlider1Value();
		this.slider2Value = state.getSlider2Value();
		this.plansza = new Owner[6][6];
		for(int i=0; i<state.getBoard().length; i++)
			  for(int j=0; j<state.getBoard()[i].length; j++)
			    this.plansza[i][j]=state.getBoard()[i][j];
		this.turn = state.getTurn();
	}
	void setSlider1Value(int value)
	{
		this.slider1Value = value;
	}
	
	void setSlider2Value(int value)
	{
		this.slider2Value = value;
	}
	
	int getSlider1Value()
	{
		return this.slider1Value;
	}
	
	int getSlider2Value()
	{
		return this.slider2Value;
	}
	void setBoardValue(int x, int y, Owner value)
	{
		this.plansza[x][y] = value;
	}
	
	Owner getTurn()
	{
		return this.turn;
	}
	
	Owner[][] getBoard()
	{
		return this.plansza;
	}
	
	
	private void setTurn(Owner player) {
		this.turn = player;
		
	}
	
	
	void showBoard(){
		System.out.println("--------propozycja------");
		for(int y = 0; y < 6; y++){
			for(int x = 0; x < 6; x++){
				System.out.print(plansza[x][y]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
	
	public ArrayList<State> generateChildStates()
	{
		int columnId =0;
		int rowId  = 0;
		
		State copy;
		
		ArrayList<State> childStates = new ArrayList<State>();
		for(Owner[] row : plansza)
		{
				for(Owner owner: row)
				{
					if(owner==Owner.NONE)
					{
						
						for(int i = 0;i<10;i++)
						{
							if( i*slider1Value == Functions.numerKafla(rowId, columnId))
								
									{copy =new State(this);
									copy.setSlider2Value(i);
									copy.setBoardValue( rowId,columnId, this.getTurn());
									if(copy.getTurn()==Owner.PLAYER1)	copy.setTurn(Owner.PLAYER2);
									else copy.setTurn(Owner.PLAYER1);
									childStates.add(copy);
									
									}
						
							
							if( i*slider2Value == Functions.numerKafla(rowId, columnId))
								{
									copy =new State(this);
									copy.setSlider2Value(i);
									copy.setBoardValue(rowId, columnId, this.getTurn());
									if(copy.getTurn()==Owner.PLAYER1)	copy.setTurn(Owner.PLAYER2);
									else copy.setTurn(Owner.PLAYER1);
									childStates.add(copy);
								} 						
							
						}
					}
					
				columnId++;
				}
				
		rowId++;
		columnId = 0;
		}
		
		System.out.println("==============================================================================================================");
		//for(State s: childStates)s.showBoard();
		return childStates;

	}



}

