import java.util.Scanner;

public class VigenereCipher {

	/** 
	 * encode takes in an int and a String
	 *  to return an encoded String using
	 *  Vigenere Cipher method
	 *  
	 * @param int n 
	 * @param String str
	 * @return String 
	 */
	public static String encode (String key, String str) {
		/* Set the base as the value of 'a', first character in the alphabet */
		int base = (int) 'a';
		char[] encoded = str.toCharArray();
		char[] keyArray = key.toCharArray();

		/* Encode each character in the original string */
		for (int i = 0; i < encoded.length; i++) {
			int val = (int) (encoded[i] - 2 * base + keyArray[i % keyArray.length]);
			encoded[i] = (char) (val % 26 + base);
		}

		return new String(encoded);
	}

	/**
	 * decode takes in an int and a String 
	 *  to return an decoded String using
	 *  Vigenere Cipher method
	 *  
	 * @param int n 
	 * @param String str
	 * @return String 
	 */
	public static String decode (String key, String str) {
		/* Set the base as the value of 'a', first character in the alphabet */
		int base = (int) 'a';
		char[] decoded = str.toCharArray();
		char[] keyArray = key.toCharArray();

		/* Decode each character in the original string */
		for (int i = 0; i < decoded.length; i++) {
			int val = (int) (decoded[i] - keyArray[i % keyArray.length]);
			if (val >= 0) {
				decoded[i] = (char) (val % 26 + base);
			} else {
				decoded[i] = (char) (val + 26 + base);
			}
		}

		return new String(decoded);
	}

	/**
	 * inputOperator checks user input and acts accordingly
	 *  The string that the user enters after is assumed to be all lowercase
	 *   with no whitespace
	 * 
	 * @return int
	 */
	public static int inputOperator () {
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();

		try {
			/* User input can be "encode", "decode"
			 *  or anything else that would terminate the program */
			if (response.compareTo("encode") == 0) {
				System.out.print("Enter the string to encode: ");
				String plaintext = in.nextLine();
				
				System.out.print("Enter the key: ");
				String key1 = in.nextLine();
				
				String encoded = new String(encode (key1, plaintext));
				System.out.println(encoded);
			} else if (response.compareTo("decode") == 0) {
				System.out.print("Enter the string to decode: ");
				String ciphertext = in.nextLine();
				
				System.out.print("Enter the key: ");
				String key2 = in.nextLine();
				
				String decoded = new String(decode (key2, ciphertext));
				System.out.println(decoded);
			} else {
				System.out.println("Valid options are \"encode\" or \"decode\"");
			}
		} finally {
			in.close();
		}

		return 0;
	}

	/**
	 * main runs the program
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		/* Program description */
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher");
		System.out.print("Would you like to encode or decode a message? ");
		inputOperator();
	}
}
