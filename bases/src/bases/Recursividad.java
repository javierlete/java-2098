package bases;

import java.math.BigInteger;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(factorial(50));

		BigInteger resultado = factorialIterativo(new BigInteger("100000"));

		System.out.println(resultado);
		System.out.println(resultado.toString().length());
	}

	/*
	 * 5! = 5 * 4 * 3 * 2 * 1 5! = 5 * 4! 4! = 4 * 3! 3! = 3 * 2! 2! = 2 * 1! 1! = 1
	 */
	public static BigInteger factorial(BigInteger numero) {
		if (numero.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		}

		return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
	}

	public static BigInteger factorialIterativo(BigInteger numero) {
		BigInteger resultado = BigInteger.ONE;
		
		for (BigInteger n = numero; n.compareTo(BigInteger.ONE) >= 0; n = n.subtract(BigInteger.ONE)) {
			resultado = resultado.multiply(n);
		}
		
		return resultado;
	}

	public static long factorial(long numero) {
		if (numero == 1) {
			return 1;
		}

		return numero * factorial(numero - 1);
	}

}
