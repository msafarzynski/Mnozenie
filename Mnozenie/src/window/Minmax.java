package window;

import java.util.ArrayList;

public class Minmax {

	
	State minMaxStep(State state, int depth)
	{
		
		int max = 0;
		int result = 0;
		State maxChild = state;
		ArrayList<State> children = state.generateChildStates();
		if(children.size()!=0)maxChild =children.get(0);
		
		for(State s: children)
		if( ( result= minMax(s, depth-1))>max)
		{
			maxChild = s;
			max = result;
		}
		return maxChild;
	}
	
	int minMax(State state, int depth)
	{
		
		int minmax = 0;
		int result = 0;
		
		if((depth<=0)||(state.generateChildStates().size()==0)||Math.abs(Ewaluacja.evaluate(state.getBoard()))>90000)return Ewaluacja.evaluate(state.getBoard());
		else
			if (state.getTurn()==Owner.PLAYER1)//maksymalizujący
			{
				for(State s : state.generateChildStates())
				{
					if((result = minMax(s, depth-1))>minmax)
					{
						minmax = result;
					}
				}
			
			}
			else
				if(state.getTurn()==Owner.PLAYER2)//minimalizujacy
				{
					for(State s : state.generateChildStates())
					{
						if((result = minMax(s, depth-1))<minmax)
						{
							minmax = result;
						}
					}
				}
		return minmax;
				
	}

}
