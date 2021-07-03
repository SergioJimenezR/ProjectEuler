package Finalizados;

public class Problem28 {

	public static void main(String[] args) {
		System.out.println(sumarDiagonales(crearMatrizEspiral(1001)));
	}

	public static int[][] crearMatrizEspiral(int N) {
		int[][] M = new int[N][N];
		for (int anillo = 0, valorDeComienzo = 1; anillo <= N / 2; anillo++, valorDeComienzo += diferencia(anillo))
			rellenarAnillo(M, anillo, valorDeComienzo);
		return M;
	}

	public static int diferencia(int anillo) { // Diferencia del valor de comienzo entre el anillo indicado y anterior.
		if (anillo == 1)
			return 1;
		else
			return 8 * (anillo - 1);
	}

	public static void rellenarAnillo(int[][] M, int anillo, int valorDeComienzo) {

		if (anillo == 0) {
			M[M.length / 2][M.length / 2] = valorDeComienzo;
		} else {
			int N = 2 * anillo;

			int f = M.length / 2 - anillo + 1;
			int c = M.length / 2 + anillo;

			for (int i = 0; i < 4; i++) { // Por cada lateral:
				for (int j = 0; j < N; j++) { // Avanza...
					switch (i) {
					case 0:
						M[f++][c] = valorDeComienzo++;
						break;
					case 1:
						M[f][c--] = valorDeComienzo++;
						break;
					case 2:
						M[f--][c] = valorDeComienzo++;
						break;
					case 3:
						M[f][c++] = valorDeComienzo++;
						break;
					}
				}
				switch (i) { // ... y gira.
				case 0:
					f--;
					c--;
					break;
				case 1:
					c++;
					f--;
					break;
				case 2:
					f++;
					c++;
					break;
				}
			}
		}
	}

	public static void imprimirMatriz(int[][] M) {
		for (int f = 0; f < M.length; f++) {
			for (int c = 0; c < M[0].length; c++)
				System.out.print(M[f][c] + " ");
			System.out.println();
		}
	}

	public static int sumarDiagonales(int[][] M) {
		int sumatorio = -M[M.length / 2][M.length / 2];
		for (int i = 0; i < M.length; i++)
			sumatorio += M[i][i] + M[i][M.length - 1 - i];
		return sumatorio;
	}

}
