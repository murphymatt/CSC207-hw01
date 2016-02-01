import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
	System.out.print("Would you like to encode or decode a message?  ");
	String option = in.nextLine();

	if (option.equals("encode") || option.equals("decode")) {
	    String message, key;
	    System.out.printf("Enter a string to %s:  ", option);
	    message = in.nextLine();
	    System.out.printf("Enter a key:  ");
	    key = in.nextLine();
	    String newMessage = iterateMessage(message, key, option);
	    System.out.println(newMessage);
	} else {
	    System.out.println("Invalid input, options are \"encode\" and \"decode\"");
	}

	in.close();
    } // void main(String[] args)

    public static String iterateMessage(String message, String key, String option) {
	int start, keyChar;
	char[] newMessage = new char[message.length()];

	// Iterate through letters within message
	for (int index = 0; index < message.length(); index++) {
	    // set keyChar according to position within message
	    keyChar = key.charAt(index % key.length()) - 'a';
	    start = message.charAt(index) - 'a';

	    if (option.equals("encode")) {
		//System.out.printf("%c", encode(start, keyChar));
		newMessage[index] = encode(start, keyChar);
	    } else if (option.equals("decode")) {
		//System.out.printf("%c", decode(start, keyChar));
		newMessage[index] = decode(start, keyChar);
	    } else {
		System.out.println("Error, incorrect option. Terminating...");
		break;
	    } // if/else
	}

	return new String(newMessage);
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
