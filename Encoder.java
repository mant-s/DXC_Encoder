public class Encoder {

  public String encode(String decodedText, String offsetChar) {
    decodedText = decodedText.toUpperCase();
    offsetChar = offsetChar.toUpperCase();

    ShiftTable table = new ShiftTable();
    final String referenceTable = ShiftTable.allChars;
    final String shiftedTable = table.createShiftTable(offsetChar);

    // creating a template for the resulting string, with the offset character as the first character
    StringBuilder encodedText = new StringBuilder();
    encodedText.append(offsetChar);

    // encoding each character and adding it to encodedText
    for (int i = 0; i < decodedText.length(); i++) {
      char currentLetter = decodedText.charAt(i);

      // checking for characters not in shiftTable and adding it, unedited, to encodedText
      if (referenceTable.indexOf(currentLetter) == -1) {
        encodedText.append(currentLetter);
        continue;
      }

      // getting encoded character and adding to encodedText
      int ind = referenceTable.indexOf(currentLetter);
      encodedText.append(shiftedTable.charAt(ind));
    }

    return encodedText.toString();
  }
}
