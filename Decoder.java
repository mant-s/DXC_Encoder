public class Decoder {

  public String decode(String encodedText) {
    encodedText = encodedText.toUpperCase();
    String offsetChar = Character.toString(encodedText.charAt(0));

    ShiftTable table = new ShiftTable();
    final String referenceTable = ShiftTable.allChars;
    final String shiftedTable = table.createShiftTable(offsetChar);

    // creating a template for the resulting string
    StringBuilder decodedText = new StringBuilder();

    // decoding each character and adding it to decodedText
    for (int i = 1; i < encodedText.length(); i++) {
      char currentLetter = encodedText.charAt(i);

      // checking for spaces and adding it, unedited, to decodedText
      if (referenceTable.indexOf(currentLetter) == -1) {
        decodedText.append(currentLetter);
        continue;
      }

      // getting decoded character and adding to decodedText
      int ind = shiftedTable.indexOf(currentLetter);
      decodedText.append(referenceTable.charAt(ind));
    }

    return decodedText.toString();
  }
}
