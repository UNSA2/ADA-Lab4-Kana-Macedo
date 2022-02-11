package multiplicacionDeMatrices;

public class StrassenTest {

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3, 4 }, { 4, 3, 0, 1 }, { 5, 6, 1, 1 }, { 0, 2, 5, 6 } };

		int[][] B = { { 1, 0, 5, 1 }, { 1, 2, 0, 2 }, { 0, 3, 2, 3 }, { 1, 2, 1, 2 } };

		printArray(A);
		printArray(B);

		printArray(strassen(B, A));

	}

	static int[][] strassen(int[][] A, int[][] B) {

		int n = A.length;

		int[][] resultado = null;

		if (n == 1)
			resultado = new int[][] { { A[0][0] * B[0][0] } };

		else {
			int mitad = n / 2;
			int[][] A11 = new int[mitad][mitad];
			int[][] A12 = new int[mitad][mitad];
			int[][] A21 = new int[mitad][mitad];
			int[][] A22 = new int[mitad][mitad];
			int[][] B11 = new int[mitad][mitad];
			int[][] B12 = new int[mitad][mitad];
			int[][] B21 = new int[mitad][mitad];
			int[][] B22 = new int[mitad][mitad];

			dividirMatriz(A, A11, A12, A21, A22);
			dividirMatriz(B, B11, B12, B21, B22);

			int[][] P1 = strassen(sumar(A11, A22), sumar(B11, B22));
			int[][] P2 = strassen(sumar(A21, A22), B11);
			int[][] P3 = strassen(A11, restar(B12, B22));
			int[][] P4 = strassen(A22, restar(B21, B11));
			int[][] P5 = strassen(sumar(A11, A12), B22);
			int[][] P6 = strassen(restar(A21, A11), sumar(B11, B12));
			int[][] P7 = strassen(restar(A12, A22), sumar(B21, B22));

			int[][] R11 = sumar(restar(sumar(P1, P4), P5), P7);
			int[][] R12 = sumar(P3, P5);
			int[][] R21 = sumar(P2, P4);
			int[][] R22 = sumar(restar(sumar(P1, P3), P2), P6);

			resultado = unirMatriz(R11, R12, R21, R22);
		}

		return resultado;

	}

	static void dividirMatriz(int[][] Matriz, int[][] m11, int[][] m12, int[][] m21, int[][] m22) {

		int t = Matriz.length / 2;

		for (int i1 = 0, i2 = t; i1 < t; i1++, i2++) {
			for (int j1 = 0, j2 = t; j1 < t; j1++, j2++) {
				m11[i1][j1] = Matriz[i1][j1];
				m12[i1][j1] = Matriz[i1][j2];
				m21[i1][j1] = Matriz[i2][j1];
				m22[i1][j1] = Matriz[i2][j2];
			}
		}
	}

	static int[][] unirMatriz(int[][] m11, int[][] m12, int[][] m21, int[][] m22) {
		int n = m11.length * 2;
		int[][] Matriz = new int[n][n];
		int t = Matriz.length / 2;

		for (int i1 = 0, i2 = t; i1 < t; i1++, i2++) {
			for (int j1 = 0, j2 = t; j1 < t; j1++, j2++) {
				Matriz[i1][j1] = m11[i1][j1];
				Matriz[i1][j2] = m12[i1][j1];
				Matriz[i2][j1] = m21[i1][j1];
				Matriz[i2][j2] = m22[i1][j1];
			}
		}
		return Matriz;
	}

	static int[][] sumar(int[][] A, int[][] B) {
		int n = A.length;
		int[][] matrizSuma = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				matrizSuma[i][j] = A[i][j] + B[i][j];
			}
		return matrizSuma;
	}

	static int[][] restar(int[][] A, int[][] B) {
		int n = A.length;
		int[][] matrizResta = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrizResta[i][j] = A[i][j] - B[i][j];
		return matrizResta;
	}

	static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static int[][] RellenarMatriz() {

		return null;
	}
}
