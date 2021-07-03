package Finalizados;

import java.math.BigInteger;

public class Problem15 {

	public static void main(String[] args) {

		/*
		 * REFLEXIÓN 1: Los 2 únicos tipos de movimientos permitidos son: O bien,
		 * descender una fila; o bien, desplazarse a la derecha. Podemos utilizar un
		 * sistema bivalente -como el sistema binario- para contabilizarlo y regularlo:
		 * Por ejemplo, el valor "1" significará descender una fila, y el valor "0"
		 * significará desplazarse a la derecha; o viceversa bajo convenio.
		 * 
		 * REFLEXIÓN 2: Puesto que debemos llegar desde la esquina superior izquierda
		 * hasta la esquina inferior derecha, significa que, en un contexto de un
		 * sistema N filas x N columnas, deberemos descender N filas y desplazarnos N
		 * veces hacia la derecha. Es decir, en nuestro sistema binario, habrán
		 * exactamente N unos y N ceros, y en total 2*N movimientos.
		 * 
		 * SINTETIZACIÓN DE LA SOLUCIÓN: Por tanto, ¿cuántos números binarios existen
		 * con 20 unos y 40 cifras totales?
		 * 
		 * SOLUCIÓN 1: Avanzar paso a paso desde el número 0 hasta el 11111...1 (con 2*N
		 * cifras), y contar cuántos números existen con N ceros.
		 * 
		 * SOLUCIÓN 2: Avanzar en el sistema decimal, desde el número 0 hasta el
		 * 1.048.575, el cual equivale a 1111-1111-1111-1111-1111, y a cada paso,
		 * convertir a binario y contar ceros.
		 * 
		 * SOLUCIÓN 3: Backtracking, recorrer todas las posibilidades conjugando ceros y
		 * unos desde 00000...0 hasta 11111...1 (con 2*N cifras), y contar cuántos nodos
		 * existen con N ceros.
		 * 
		 * SOLUCIÓN 4: Aplicar teoría matemática: álgebra y combinatoria de
		 * permutaciones. En general, el número de permutciones de m objetos, en los que
		 * hay m1, m2, ..., mk iguales entre sí, es: m! / (m1! * m2! * ... * mk!).
		 * 
		 * REFLEXIÓN NECESARIA PARA SOLUCIÓN 4: El tipado "long" concluye en 2^63-1, el
		 * cual no llega a 40!, viéndonos en la obligación de utilizar BigInteger por
		 * virtualización.
		 * 
		 */

		// SOLUCIÓN = 40! / (20! * 20!)
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
			binario = decimal % 2 + binario; // Hecho por concatenación de String.
		return decimal + binario;
	}

}
