package com.ss.jb.five.Assignment_5_2;


interface PerformOperation {
	boolean check(int a);
}

public class Assignment_5_2_1 {
	public Assignment_5_2_1(String[] args) {
		if (args == null || args.length == 0) {
			return;
		}
		
		Lambdas lamb = new Lambdas();

		int cases = Integer.parseInt(args[0]);
		PerformOperation p;

		if (args.length == (cases * 2) + 1) {
			for (int i = 1; i < args.length; i += 2) {
				switch (Integer.parseInt(args[i])) {
				case 1:
					p = Lambdas.isOdd();
					if (Lambdas.checker(p, Integer.parseInt(args[i + 1]))) {
						System.out.println("ODD");
					} else {
						System.out.println("EVEN");
					}
					break;
				case 2:
					p = Lambdas.isPrime();
					if (Lambdas.checker(p, Integer.parseInt(args[i + 1]))) {
						System.out.println("PRIME");
					} else {
						System.out.println("COMPOSITE");
					}
					break;
				case 3:
					p = Lambdas.isPalindrome();
					if (Lambdas.checker(p, Integer.parseInt(args[i + 1]))) {
						System.out.println("PALINDROME");
					} else {
						System.out.println("NOT PALINDROME");
					}
					break;
				default:
					System.out.println("Incorrect argument");
				}
			}
		} else {
			System.out.println("There are not the right number of arguments");
		}

	}
}

class Lambdas {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public static PerformOperation isOdd() {
		return x -> {
			if (x % 2 == 0) {
				return false;
			}
			return true;
		};
	}

	public static PerformOperation isPrime() {
		return x -> {
			for (int i = 2; i * i <= x; i++) {
				if (x % i == 0) {
					return false;
				}
			}
			return true;
		};
	}

	public static PerformOperation isPalindrome() {
		return x -> {
			if (x == Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString())) {
				return true;
			}
			return false;
		};
	}
}
