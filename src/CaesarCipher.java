import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("This program encrypts and decrypts messages using the Caesar Cipher.");
	System.out.print("Would you like to encode or decode a message?  ");
	String response = in.nextLine();
	String message;
	switch(response) {
	case "encode":
	    System.out.print("Enter a string to encode:  ");
	    message = in.nextLine();
	    encode(message);
	    break;
	case "decode":
	    System.out.print("Enter a string to decode:  ");
	    message = in.nextLine();
	    decode(message);
	    break;
	default:
	    System.out.println("Invalid input, options are \"encode\" and \"decode\"");
	    break;
	} // switch(response)
	
	in.close();
    } // void main(String[] args)

    public static void encode(String message) {
	char cEncoded;
	int cDecoded;
	for (int key = 0; key < 26; key++) {
	    System.out.printf("key = %d: ", key);
	    for (int index = 0; index < message.length(); index++) {
		cDecoded = message.charAt(index);
		cEncoded = (char) ((((cDecoded - 'a') + key) % 26) + 'a');
		System.out.printf("%c", cEncoded);
	    } // for (index)
	    System.out.println();
	} // for (key)
    } // void encode(String message)
    
    public static void decode(String message) {
	char cDecoded;
	int cEncoded, result;
	for (int key = 0; key < 26; key++) {
	    System.out.printf("key = %d: ", key);
	    for (int index = 0; index < message.length(); index++) {
		cEncoded = message.charAt(index);
		result = cEncoded - 'a' - key;
		if (result < 0)
		    result += 26;
		cDecoded = (char) (result + 'a');
		System.out.printf("%c", cDecoded);
	    } // for (index)
	    System.out.println();
	} // for (key)
    } // void decode(String message)
} // class CaesarCipher
