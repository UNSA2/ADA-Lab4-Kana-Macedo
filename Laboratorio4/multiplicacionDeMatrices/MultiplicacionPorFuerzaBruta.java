package multiplicacionDeMatrices;

import java.util.Arrays;

public class MultiplicacionPorFuerzaBruta {

	public static void main(String[] args) {
		int[][] array1 = { { 12, 3, 2, 2, 2, 2 }, { 1, 0, 6, 2, 2, 2 }, };

		int[][] array2 = { { 9, 4, 3 }, { 5, 2, 3 }, { 1, 0, 3 }, { 1, 0, 3 }, { 1, 0, 3 }, { 1, 0, 3 }, };
		System.out.println(Arrays.deepToString(multiplicarFuerzaBruta(array1, array2)));
		System.out.print("xd");
	}

	public static int[][] multiplicarFuerzaBruta(int[][] array1, int[][] array2) {
		if (array1[0].length != array2.length) {
			System.out.println("Las matrices son incompatibles para el producto.");
			return null;
		}
		int[][] arrayResult = new int[array1.length][array2[0].length];

		for (int i = 0; i < array2[0].length; i++) {
			System.out.print("{ ");
			for (int j = 0; j < array1.length; j++) {
				System.out.print("( ");
				for (int k = 0; k < array2.length; k++) {
					System.out.print(array1[j][k] + "*" + array2[k][i]);
					if (k != array1[0].length - 1)
						System.out.print(" + ");
					arrayResult[j][i] += array1[j][k] * array2[k][i];
				}
				System.out.print(" )");
			}
			System.out.print(" }\n");
		}
		return arrayResult;
	}
}
