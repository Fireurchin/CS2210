/**
 * 
 * @author Mingpei Dou, mdou, 251056543, CS2210A, 25/09/2020, Assignment 01 2020
 *
 */
public class Symmetric { // public class Symmetric
	static int intArr[] = {};

	public static void main(String args[]) {
		System.out.println(isSymmetric(intArr, intArr.length));
	}

	public static boolean isSymmetric(int[] A, int n) { // scans array and determines symmetry
		if (n != A.length) { // handles inaccurate array length
			System.out.println("Inaccurate Array Length");
			return false; // return false if n is different from array size
		}
		if (n > 1) { // array is symmetric if single-valued, test for array with multiple values
			for (int i = 0; i < n; i++) { // search and compare every value in array
				int g = n - i - 1;
				if (A[i] != A[g]) // search and compare all values such that at least one is asymmetric
					return false; // return false if array is asymmetric
			}
		} else if (n < 1) { // array must store n>=1 values, as specified by the assignment instructions
			System.out.println("Invalid Array Size");
			return false;
		}
		return true; // return true if all values such that array is symmetrical
	}
}
