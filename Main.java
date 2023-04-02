import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // String plainText = "hello world!";
    // String offsetChar = "f";
    boolean cont = true;
    final String referenceTable = ShiftTable.allChars;

    // setting up a scanner for user inputs
    Scanner scanner = new Scanner(System.in);

    while (cont) {
      // processing input for encoding or decoding
      System.out.println(
        "Would you like to encode or decode your string?\nType 'E' to encode, and 'D' to decode."
      );

      String encodeDecode = (scanner.nextLine()).toUpperCase();
      while (
        encodeDecode == null ||
        (!encodeDecode.equals("E") && !encodeDecode.equals("D"))
      ) {
        if (encodeDecode == null) {
          System.out.println(
            "No input received. Please try again.\nWould you like to encode or decode your string?\nType 'E' to encode, and 'D' to decode."
          );
        } else {
          System.out.println(
            "Invalid input. Please try again.\nWould you like to encode or decode your string?\nType 'E' to encode, and 'D' to decode."
          );
        }
        encodeDecode = (scanner.nextLine()).toUpperCase();
      }

      // processing input for string to encode/decode
      if (encodeDecode.equals("E")) {
        System.out.println("Please enter the string you would like to encode:");
      } else {
        System.out.println("Please enter the string you would like to decode:");
      }

      String inputText = scanner.nextLine();
      while (inputText == null) {
        System.out.println(
          "No input received. Please try again.\nPlease enter the string you would like to encode/decode:"
        );
        inputText = scanner.nextLine();
      }

      // processing offset character
      String offsetChar = "";
      if (encodeDecode.equals("E")) {
        System.out.println("Please enter the offset character:");
        offsetChar = (scanner.nextLine()).toUpperCase();

        while (
          offsetChar == null || (referenceTable.indexOf(offsetChar) == -1)
        ) {
          if (offsetChar == null) {
            System.out.println(
              "No input detected. Please try again.\nPlease enter the offset character:"
            );
          } else if (referenceTable.indexOf(offsetChar) == -1) {
            System.out.println(
              "Invalid input. Please try again.\nPlease enter the offset character:"
            );
          }
          offsetChar = scanner.nextLine();
        }
      }

      // encoding/decoding, depending on user's inputs
      if (encodeDecode.equals("E")) {
        Encoder encoder = new Encoder();
        String encodedText = encoder.encode(inputText, offsetChar);
        System.out.printf("Your encoded text is:\n%s\n", encodedText);
      } else if (encodeDecode.equals("D")) {
        Decoder decoder = new Decoder();
        String decodedText = decoder.decode(inputText);
        System.out.printf("Your decoded text is:\n%s\n", decodedText);
      }

      // enabling user to determine if they want to encode/decode another string
      System.out.println("Encode/decode another string?\nY: Yes\nN: No");
      String shouldCont = (scanner.nextLine()).toUpperCase();
      while (
        shouldCont == null ||
        !(shouldCont.equals("Y") || shouldCont.equals("N"))
      ) {
        if (shouldCont == null) {
          System.out.println(
            "No input detected. Please try again.\nEncode/decode another string?\nY: Yes\nN: No"
          );
        } else {
          System.out.println(
            "Invalid input detected. Please try again.\nEncode/decode another string?\nY: Yes\nN: No"
          );
        }
        shouldCont = (scanner.nextLine()).toUpperCase();
      }
      if (shouldCont.equals("N")) {
        cont = false;
      }
    }
    scanner.close();
  }
}
