package week1.day2.ha;

public class Palindrome {

	public static void main(String[] args) {
		int input =121;
        int rem = 0;
		for (int i = input; i >0; i=i/10) {
		rem = (rem*10+i%10);
		System.out.println(rem);
		int output = rem;
		if (input==output) {
			System.out.println("Palindrome number :"+input);
			
		}
		}
	}

}
