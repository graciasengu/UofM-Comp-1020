/* Recursion.Java
*COMP 1020  SECTION D01
*INSTRUCTOR: Robert Guderian
*NAME: Gracia Sengutuvan
*Assignment: Exercise 8-Ackerman function
*
*Class: Uses recursion to solve the Ackerman function
*		recursively calls the function till base where m=0
*/

public class Recursion {
	public static void main(String[] args) {

		System.out.println(ackermanValue(2, 3));
		System.out.println(ackermanValue(3, 2));
		System.out.println(ackermanValue(0, 3)); // result should 4
		System.out.println(ackermanValue(2, 1)); // result should 5

		//int range[] = new int[] { 3, 100, 35, 3, 5 };
		//System.out.println(calRange(range));

	}

	public static int ackermanValue(int m, int n) {
		if (m == 0)
			return n + 1;
		else if (m > 0 && n == 0)
			return ackermanValue(m - 1, 1);
		else if (m > 0 && n > 0)
			return ackermanValue(m - 1, ackermanValue(m, n - 1));

		return 0;
	}

	/*public static int calRange(int[] range) {
		int minmax[] = new int[2];
		minmax = calRange(range, 0, range[0], range[0]);
		return minmax[1] - minmax[0];
	}

	public static int[] calRange(int[] range, int pos, int min, int max) {
		int minmax[] = new int[2];

		if (range.length - 1 == pos) {
			minmax[0] = min;
			minmax[1] = max;
			return minmax;
		} else if (range[pos] < min) {
			min = range[pos];
			return calRange(range, pos + 1, min, max);
		} else if (range[pos] > max) {
			max = range[pos];
			return calRange(range, pos + 1, min, max);
		} else
			return calRange(range, pos + 1, min, max);

	}
	*/

}
