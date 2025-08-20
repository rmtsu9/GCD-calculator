/**
 * GCD Calculator - Extended Euclidean Algorithm
 * 
 * Program to calculate Extended Euclidean Algorithm for solving Linear Diophantine equations
 * Equation format: ax + by = c
 * 
 * Features:
 * - Find gcd(a, b) and Bezout coefficients (s, t)
 * - Find particular and general solutions
 * - Display all n values where x ≥ 0 and y ≥ 0
 * 
 * Usage:
 * java GCD <a> <b> <c>  or  java GCD (then input values interactively)
 * 
 * @author GCD Calculator
 * @version 1.0
 */

import java.util.Scanner;

public class GCD {
	/**
	 * Extended Euclidean Algorithm
	 * Find gcd(a, b) and coefficients s, t such that sa + tb = gcd(a, b)
	 * 
	 * @param a First integer
	 * @param b Second integer
	 * @return array [gcd, s, t] where gcd = sa + tb
	 */
	static long[] extgcd(long a, long b) {
		long r1 = a, r2 = b;
		long s1 = 1, s2 = 0;
		long t1 = 0, t2 = 1;
		while (r2 != 0) {
			long q = r1 / r2;
			long temp = r1; temp -= q * r2; r1 = r2; r2 = temp;
			temp = s1; temp -= q * s2; s1 = s2; s2 = temp;
			temp = t1; temp -= q * t2; t1 = t2; t2 = temp;
		}
		return new long[]{r1, s1, t1};
	}

	/**
	 * Main function of the program
	 * Accept values a, b, c and solve equation ax + by = c
	 * 
	 * @param args command line arguments [a, b, c] (optional)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a, b, c;
		
		// Input from command line or interactive input
		if (args.length >= 3) {
			a = Long.parseLong(args[0]);
			b = Long.parseLong(args[1]);
			c = Long.parseLong(args[2]);
		} else {
			System.out.print("a = "); a = sc.nextLong();
			System.out.print("b = "); b = sc.nextLong();
			System.out.print("c = "); c = sc.nextLong();
		}

		System.out.println("Problem: " + a + "x + " + b + "y = " + c);
		

		// Step 1-2: Find gcd and Bezout coefficients
		long[] result = extgcd(a, b);
		long d = result[0];  // gcd(a, b)
		long s = result[1];  // coefficient of a
		long t = result[2];  // coefficient of b
		
		System.out.println("1. gcd(a, b) = d = " + d);
		System.out.println("2. sa + tb = s = " + s + ", t = " + t);
		
		// Step 3: Check if equation has integer solutions
		if (c % d != 0) {
			System.out.println("3) " + c + " is not divisible by " + d + " -> No integer solutions");
			sc.close();
			return;
		}
		
		// Step 3: Find particular solution
		long k = c / d;
		long x0 = s; x0 *= k;  // x₀ = s × (c/d)
		long y0 = t; y0 *= k;  // y₀ = t × (c/d)
		System.out.println("3. x0 = s⋅c/d (x0 = " + x0 + "), y0 = t⋅c/d (y0 = " + y0 + ")");
		
		// Step 4: Find general solution
		long stepX = b / d;  // Value that x increases for each n
		long stepY = a / d;  // Value that y decreases for each n
		System.out.println("4. x = x0 + (b/d)n, y = y0 − (a/d)n = (x = " + x0 + " + (" + b + "/" + d + ")n, y = " + y0 + " − (" + a + "/" + d + ")n)");
		
		System.out.println("5. All N values:");
		
		// Find range of n that makes x ≥ 0 and y ≥ 0
		// For y ≥ 0: y0 - stepY*n ≥ 0 → n ≤ y0/stepY
		long maxN = y0;
		if (stepY > 0) {
			maxN /= stepY;
		} else {
			maxN = Long.MAX_VALUE;
		}
		
		// For x ≥ 0: x0 + stepX*n ≥ 0 → n ≥ -x0/stepX
		long minN;
		if (stepX > 0) {
			double neg_x = -x0;
			neg_x /= stepX;
			minN = (long)Math.ceil(neg_x);
		} else {
			minN = Long.MIN_VALUE;
		}
		
		// Find valid range
		long minValid = Math.max(minN, Long.MIN_VALUE);
		long maxValid = Math.min(maxN, Long.MAX_VALUE);
		
		// Display results
		if (maxValid != Long.MAX_VALUE && minValid != Long.MIN_VALUE && minValid <= maxValid) {
			// Case with intersection - there is a range of n where both x,y ≥ 0
			// Display all N values in one line
			System.out.print("All N: ");
			for (long n = minValid; n <= maxValid; n++) {
				if (n > minValid) System.out.print(", ");
				System.out.print(n);
			}
			System.out.println();
			
			// Display details for each n
			for (long n = minValid; n <= maxValid; n++) {
				long x_value = x0; 
				long temp_x = stepX; temp_x *= n; x_value += temp_x;
				
				long y_value = y0;
				long temp_y = stepY; temp_y *= n; y_value -= temp_y;
				
				if (x_value >= 0 && y_value >= 0) {
					System.out.println("n = " + n + " -> x = " + x_value + ", y = " + y_value);
				}
			}
		} else {
			// Case without intersection - display possible n values separately
			System.out.print("All N: ");
			boolean first = true;
			if (maxN != Long.MAX_VALUE) {
				System.out.print(maxN);
				first = false;
			}
			if (minN != Long.MIN_VALUE) {
				if (!first) System.out.print(", ");
				System.out.print(minN);
			}
			System.out.println();
			
			// Display results for each possible n
			if (maxN != Long.MAX_VALUE) {
				long x_when_y_pos = x0;
				long temp_calc = stepX; temp_calc *= maxN; x_when_y_pos += temp_calc;
				
				long y_when_y_pos = y0;
				temp_calc = stepY; temp_calc *= maxN; y_when_y_pos -= temp_calc;
				
				System.out.println("n = " + maxN + " -> x = " + x_when_y_pos + ", y = " + y_when_y_pos);
			}
			
			if (minN != Long.MIN_VALUE) {
				long x_when_x_pos = x0;
				long temp_calc = stepX; temp_calc *= minN; x_when_x_pos += temp_calc;
				
				long y_when_x_pos = y0;
				temp_calc = stepY; temp_calc *= minN; y_when_x_pos -= temp_calc;
				
				System.out.println("n = " + minN + " -> x = " + x_when_x_pos + ", y = " + y_when_x_pos);
			}
		}
		
		sc.close(); // Close Scanner
	}
}
