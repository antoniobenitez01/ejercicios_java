package wally;

import java.util.Scanner;

public class Wally_game {
	//Programa de juego de tablero ccuya funcion es encontrar donde esta escondido un personaje (por casisllas)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int filas = 5;
		int columnas = 4;
		
		//CORRECCIÓN - Las columnas y las filas están al revés! 
		int tablero [][] = new int [columnas][filas]; //creacion del array
		
		//valor aleatorio de la posicion de wally
		int X = (int) (5 * Math.random()) ;
		int Y = (int) (4 * Math.random()) ;
		
		//darle a todos los valores un valor fijo (he elegido 0 que hace referencia a ausencia) para a posterior cambiar el valor de la posicion de wally a 1
		for(int i =0 ; i<columnas ; i++) {
			for(int j =0 ; j<filas ; j++) {
				tablero[i][j]=0;
			}
		}
		
		tablero[X][Y]=1; //aquí está wally
		//System.out.println("AQUI ESTA WALLY (PRUEBA)" + X + Y);
		int x;
		int y;
		int intento = 1;
		int result =1;
		
		do {
			
			System.out.println("INTENTO "+ intento + ":");
			System.out.println("Introduzca la coordenada X");
			x = sc.nextInt();
			System.out.println("Introduzca la coordenada Y");
			y = sc.nextInt();
			
			//CORRECCIÓN - Bucle innecesario! Provoca un error donde te dice "AHÍ NO ESTABA WALLY" aún si aciertas en el primer intento
			//si falla el primer intento
			for(int i = 0 ; i < 3 ; i++) {
				intento++;
				System.out.println("AHÍ NO ESTABA WALLY");
				System.out.println("INTENTO "+ intento + ":");
				System.out.println("Introduzca la coordenada X");
				x = sc.nextInt();
				System.out.println("Introduzca la coordenada Y");
				y = sc.nextInt();
				if(tablero[X][Y] == tablero[x][y]) {result = 1; break;}
				else {result=0;}
			}
			
			//CORRECCIÓN - "Break" solo debe utilizarse en el contexto de un condicional switch!
			break;
			
		}while((tablero[X][Y] != tablero[x][y]));
		
		//CORRECCIÓN - Condición no mal construida, pero resulta innecesaria si se construye el bucle do-while anterior correctamente
		if(result==1) {
			System.out.println("Enhorabuena!"); //si gana
		}
		else if(result==0) {
			System.out.println("YOU LOST.");//si pierde
		}
		
		//mostrar tablero con la posicion ded wally 
		System.out.println("Wally se muestra como un 1");
		for(int i = 0 ; i<filas ; i++) {
			for(int j = 0 ; j<columnas ; j++) {
				System.out.print(tablero[j][i]+" ");
				//System.out.println(tablero[0][i]+" "+tablero[1][i]+" "+tablero[2][i]+" "+tablero[3][i]);
			}
			System.out.println();
		}
	}

}
