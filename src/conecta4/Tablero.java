package conecta4;

import java.util.Arrays;

public class Tablero {

	private int columnas = 7;
	private int filas = 6;
	private char[][] tablero = new char[filas][columnas];
	private int[] huecosColumnas = new int[7];
	private int turno;

	public Tablero() {

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				tablero[i][j] = '-';
			}
		}

		for (int i = 0; i < columnas; i++) {
			huecosColumnas[i] = filas - 1;
		}
		turno = 1;

	}

	public void coloca(int donde) {

		if (donde == 5) {
			donde = 5;
		}

		if (tablero[huecosColumnas[donde]][donde] == '-') {
			
			if (turno == 1) {
				tablero[huecosColumnas[donde]][donde] = 'x';
				huecosColumnas[donde]--;
				turno = 2;
			}
			else if (turno == 2) {
				tablero[huecosColumnas[donde]][donde] = 'o';
				huecosColumnas[donde]--;
				turno = 1;
			}

			
		}
		
	}

	@Override
	public String toString() {
		String devolver = "";

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				devolver += tablero[i][j] + " ";
			}
			devolver += "\n";
			
		}
		devolver += "_ _ _ _ _ _ _  \n";
		for(int i = 0; i < columnas; i++) {
			devolver += i + " ";
		}
		return devolver;

	}

}
