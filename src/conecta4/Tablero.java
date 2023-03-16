package conecta4;

import java.util.Arrays;

public class Tablero {

	private int columnas = 7;
	private int filas = 6;
	private char[][] tablero = new char[filas][columnas];
	private int[] huecosColumnas = new int[7];
	private char turno;
	private boolean esGanador;

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

		esGanador = false;
	}

	public void coloca(int donde) {

		if (donde == 6) {
			donde = 6;
		}

		if (tablero[huecosColumnas[donde]][donde] == '-') {

			
				tablero[huecosColumnas[donde]][donde] = turno;
				huecosColumnas[donde]--;
				Ganador(turno, huecosColumnas[donde], donde);
				turno = (turno == 'X') ? 'O' : 'X';

		}

	}

	public boolean isEsGanador() {
		return esGanador;
	}

	public void Ganador(char turno, int fila, int columna) {
		int contador = 0;
		while (contador != 4 && fila < filas) {

			if (tablero[fila][columna] == turno) {

				contador++;

			}
			if (contador == 4) {
				esGanador = true;
			}
			fila++;
		}
	}

//	public void Ganador(int donde, int filas, int columna) {
//		int contador = 1;
////		for (int i = 0; i < filas; i++) {
////			for (int j = 0; j < columnas; j++) {
////				int contador = 1;
////				if(tablero[huecosColumnas[donde]][donde] == tablero[huecosColumnas[donde] - 1][donde] ) {
////					contador++;
////					if(contador == 4) {
////						
////					}
////				}
////				
////			}
////		}
//		while(contador !=4) {
//			
//		}
//		
//	}

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
		for (int i = 0; i < columnas; i++) {
			devolver += i + " ";
		}
		return devolver;

	}

}
