package Finalizados;

public class Problem2 {
	public static void main(String[] args) {

		int i = 0, j = 1, aux, contador = 0;
		System.out.print(i + " " + j + " ");

		while (i + j <= 4000000) {
			aux = i;
			i = j;
			j = aux + i; // La que se va corriendo por delante es j.
			System.out.print(j + " ");
			if (j % 2 == 0)
				contador += j;
		}

		System.out.println("\nContador: " + contador);
	}
}
