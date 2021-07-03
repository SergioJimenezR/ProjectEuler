package Finalizados;

import java.math.BigInteger;

public class Problem15 {

	public static void main(String[] args) {

		/*
		 * REFLEXI�N 1: Los 2 �nicos tipos de movimientos permitidos son: O bien,
		 * descender una fila; o bien, desplazarse a la derecha. Podemos utilizar un
		 * sistema bivalente -como el sistema binario- para contabilizarlo y regularlo:
		 * Por ejemplo, el valor "1" significar� descender una fila, y el valor "0"
		 * significar� desplazarse a la derecha; o viceversa bajo convenio.
		 * 
		 * REFLEXI�N 2: Puesto que debemos llegar desde la esquina superior izquierda
		 * hasta la esquina inferior derecha, significa que, en un contexto de un
		 * sistema N filas x N columnas, deberemos descender N filas y desplazarnos N
		 * veces hacia la derecha. Es decir, en nuestro sistema binario, habr�n
		 * exactamente N unos y N ceros, y en total 2*N movimientos.
		 * 
		 * SINTETIZACI�N DE LA SOLUCI�N: Por tanto, �cu�ntos n�meros binarios existen
		 * con 20 unos y 40 cifras totales?
		 * 
		 * SOLUCI�N 1: Avanzar paso a paso desde el n�mero 0 hasta el 11111...1 (con 2*N
		 * cifras), y contar cu�ntos n�meros existen con N ceros.
		 * 
		 * SOLUCI�N 2: Avanzar en el sistema decimal, desde el n�mero 0 hasta el
		 * 1.048.575, el cual equivale a 1111-1111-1111-1111-1111, y a cada paso,
		 * convertir a binario y contar ceros.
		 * 
		 * SOLUCI�N 3: Backtracking, recorrer todas las posibilidades conjugando ceros y
		 * unos desde 00000...0 hasta 11111...1 (con 2*N cifras), y contar cu�ntos nodos
		 * existen con N ceros.
		 * 
		 * SOLUCI�N 4: Aplicar teor�a matem�tica: �lgebra y combinatoria de
		 * permutaciones. En general, el n�mero de permutciones de m objetos, en los que
		 * hay m1, m2, ..., mk iguales entre s�, es: m! / (m1! * m2! * ... * mk!).
		 * 
		 * REFLEXI�N NECESARIA PARA SOLUCI�N 4: El tipado "long" concluye en 2^63-1, el
		 * cual no llega a 40!, vi�ndonos en la obligaci�n de utilizar BigInteger por
		 * virtualizaci�n.
		 * 
		 */

		// SOLUCI�N = 40! / (20! * 20!)
		System.out.println(factorial(40).divide(factorial(20).multiply(factorial(20))));

	}

	public static BigInteger factorial(int n) {
		if (n > 1)
			return (new BigInteger(n + "")).multiply(factorial(n - 1));
		else
			return new BigInteger("1");
	}

	public static String binario(int decimal) {
		String binario = "";
		for (; decimal >= 2; decimal /= 2)
			binario = decimal % 2 + binario; // Hecho por concatenaci�n de String.
		return decimal + binario;
	}

}
