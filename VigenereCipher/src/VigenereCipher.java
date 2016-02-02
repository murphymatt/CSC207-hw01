import java.util.Scanner;

public class VigenereCipher {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("This program encrypts and decrypts messages " +
				"using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message?  ");
		String option = in.nextLine().toLowerCase();

		if (option.equals("encode") || option.equals("decode")) {
			System.out.printf("Enter a string to %s:  ", option);
			String message = in.nextLine().toLowerCase();
			System.out.printf("Enter a key:  ");
			String key = in.nextLine().toLowerCase();
			iterateMessage(message, key, option);
		} else {
			System.out.println("Invalid input, options are \"encode\" " +
					"and \"decode\"");
		}

		in.close();
	} // void main(String[] args)

	public static void iterateMessage(String message, String key,
			String option) {
		int start, keyChar;
		char[] newMessage = new char[message.length()];

		// Iterate through letters within message
		for (int index = 0; index < message.length(); index++) {
			// set keyChar according to position within message
			keyChar = key.charAt(index % key.length()) - 'a';
			start = message.charAt(index) - 'a';

			if (start < 0 || start > 25 || keyChar < 0 || keyChar > 25) {
				System.out.println("Message and key must contain only " +
						"lowercase characters.");
				return;
			} else if (option.equals("encode")) {
				//System.out.printf("%c", encode(start, keyChar));
				newMessage[index] = encode(start, keyChar);
			} else if (option.equals("decode")) {
				//System.out.printf("%c", decode(start, keyChar));
				newMessage[index] = decode(start, keyChar);
			} else {
				System.out.println("Error, incorrect option. Terminating...");
				return;
			} // if/else
		}

		System.out.println(new String(newMessage));
	} // void iterateMessage(String message, String key, String option)

	public static char encode(int start, int keyChar) {
		int endToInt = (start + keyChar) % 26;
		return (char) (endToInt + 'a');
	} // encode(int start, int keyChar)

	public static char decode(int start, int keyChar) {
		int endToInt = (start - keyChar);
		if (endToInt < 0)
			endToInt += 26;
		return (char) (endToInt + 'a');
	} // encode(int start, int keyChar)
}
