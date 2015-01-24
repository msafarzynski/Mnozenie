/**
 * 
 */
package window;

/**
 * Dodatkowe funkcje wspomagajace gre
 */
public abstract class Functions {
	
	/**
	 * Funkcja ktora wylicza wspolrzadne w tablicy kafelkow 6x6
	 * @param i		liczba ktora jest na kaflu - wynik mnozenia
	 * @return		klasa Pair - wspolrzedne x i y w tablicy kafli
	 */
	public static Pair indexKafla(int i){
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
	}


	/**
	 * Funkcja ktora wylicza jaki numer powinien byc na kafelku
	 * @param x		wspolrzedna x w tablicy kafelkow
	 * @param y		wspolrzedna y w tablicy kafelkow
	 * @return		numer na kaflu
	 */
	public static int numerKafla(int x, int y){
		switch(y){
		case 0:
			switch(x){
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
			switch(x){
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
			switch(x){
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
			switch(x){
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
			switch(x){
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
			switch(x){
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
	}
};
