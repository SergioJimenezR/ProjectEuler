package Finalizados;

public class Problem12 {

	public static void main(String[] args) {
		boolean continuar = true;
		for (int nth = 7, triangular = 28; continuar; nth++, triangular += nth)
			if (contadorDivisores(triangular) > 500) {
				System.out.println(triangular);
				continuar = false;
			}
	}

	public static int contadorDivisores(int N) {
		int contador = 2;
		for (int i = 2; i <= N / 2; i++)
			if (N % i == 0)
				contador++;
		return contador;
	}

}
