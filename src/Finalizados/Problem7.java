package Finalizados;

public class Problem7 {

	public static void main(String[] args) {
		System.out.println(NesimoPrimo(10001));
	}

	public static int NesimoPrimo(int N) { // O(N)
		int i = 1;
		for (int primos = 1; primos <= N; i++)
			if (esPrimo(i))
				primos++;
		return i - 1;
	}

	/*
	 * Tiene complejidad O(raiz(n)) porque, aunque puedan existir divisores por
	 * encima, en caso de existir: siempre cada uno se va a corresponder con otro
	 * divisor por debajo (ya contabilizado). Por ejemplo, para el n�mero 100, la
	 * ra�z es 10, y tiene como divisor al 50 -entre otros-, pero ya estaba el 2
	 * contabilizado tambi�n. Probablemente la mediana de los divisores siempre sea
	 * la ra�z, en caso de que la ra�z de N sea un n�mero natural. El razonamiento
	 * tambi�n est� basado en que No existe M > raiz(N) tal que M*M <= N.
	 * (Importante: Esta complejidad no sirve para contabilizar todos los
	 * divisores).
	 */
	public static boolean esPrimo(int n) { // O(raiz(N)).
		if (n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
