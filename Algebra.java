// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    // System.out.println(plus(2, -3));   // 2 + 3
	   	// System.out.println(minus(2,7));  // 2 - 7
 		// System.out.println(times(3,-4));  // 3 * 4
   		// System.out.println(plus(2,times(4,-2)));  // 2 + 4 * 2
		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(-3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		// System.out.println(div(1,-3));    // 5 / 5  
   		// System.out.println(div(-25,7));   // 25 / 7
   		// System.out.println(mod(-13,5));   // 25 % 7
   		// System.out.println(mod(121,-6));  // 120 % 6    
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1 >= 0) {
			while (x1 > 0) {
				x2 ++;
				x1 --;
		}
	}
		else {
			while (x1 < 0) {
				x2--;
				x1 ++;
			}
		}
		return x2;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 >= 0) {
			while (x2 > 0) {
				x1 --;
				x2 --;
			}
		}
		else {
			while(x2 < 0) {
				x1 ++;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean pos = false;
		if(x1 > 0 && x2 > 0 || x1 < 0 && x2 < 0) {
			pos = true;
		}
		x1 = Math.abs(x1);
		x2 = Math.abs(x2);
		int mult = x1;
		while (x2 != 1) {
			mult = plus(mult, x1);
			x2 --;
		}
		if(pos == false) {
			mult = minus(minus(mult, mult), mult); 
		}
		return mult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int r = 1, n2 = Math.abs(n);
		while (n2 > 0) {
			r = times(r, x);
			n2 --;
		}
			return r; 
	}



	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int y1 = Math.abs(x1), y2 = Math.abs(x2), count = 0;
		while(y1 >= y2) {
			y1 = minus(y1, y2);
			count ++;
		}
		if(x1 < 0 && x2 > 0 || x1 > 0 && x2 < 0) {
			return times(-1, count);
		}
		else { return count; }
	}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int count = div(x1, x2);
		int x3 = times(count, x2);
		return x1-x3;
		// what to do when (-)
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int s = 0;
		for(int i = 0; i * i <= x; i++) {
			if (i * i == x) {
				return i;
			}
			else if ((i + 1) * (i + 1) > x) {
				return i;
			}
			s = i;
		}
		return s;
		}
	}  	  