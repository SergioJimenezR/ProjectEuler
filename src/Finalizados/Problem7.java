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
	 * divisor por debajo (ya contabilizado). Por ejemplo, para el número 100, la
	 * raíz es 10, y tiene como divisor al 50 -entre otros-, pero ya estaba el 2
	 * contabilizado también. Probablemente la mediana de los divisores siempre sea
	 * la raíz, en caso de que la raíz de N sea un número natural. El razonamiento
	 * también está basado en que No existe M > raiz(N) tal que M*M <= N.
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
