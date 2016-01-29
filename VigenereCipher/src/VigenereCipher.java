import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
	System.out.print("Would you like to encode or decode a message?  ");
	String response = in.nextLine();
	String message, key;
	switch(response) {
	case "encode":
	    System.out.print("Enter a string to encode:  ");
	    message = in.nextLine();
	    System.out.print("Enter the key:  ");
	    key = in.nextLine();
	    encode(message, key);
	    break;
	case "decode":
	    System.out.print("Enter a string to decode:  ");
	    message = in.nextLine();
	    System.out.print("Enter the Key:  ");
	    key = in.nextLine();
	    decode(message, key);
	    break;
	default:
	    System.out.println("Invalid input, options are \"encode\" and \"decode\"");
	    break;
	} // switch(response)
	
	in.close();
    } // void main(String[] args)

    public static void encode(String message, String key) {
	char cEncoded;
	int cDecoded, keyChange;
	    for (int index = 0; index < message.length(); index++) {
		keyChange = key.charAt(index % key.length()) - 'a';
		cDecoded = message.charAt(index);
		cEncoded = (char) ((((cDecoded - 'a') + keyChange) % 26) + 'a');
		System.out.printf("%c", cEncoded);
	    } // for (index)
	    System.out.println();
    } // void encode(String message)
    
    public static void decode(String message, String key) {
    	char cDecoded;
    	int cEncoded, keyChange, result;
    	    for (int index = 0; index < message.length(); index++) {
		keyChange = key.charAt(index % key.length()) - 'a';
    		cEncoded = message.charAt(index);
    		result = cEncoded - 'a' - keyChange;
    		if (result < 0)
    		    result += 26;
    		cDecoded = (char) (result + 'a');
    		System.out.printf("%c", cDecoded);
    	    } // for (index)
    	    System.out.println();
        } // void decode(String message)

}
