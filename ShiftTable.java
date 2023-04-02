public class ShiftTable {

  public static final String allChars =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

  public String createShiftTable(String offsetChar) {
    offsetChar = offsetChar.toUpperCase();
    int offsetInd = allChars.indexOf(offsetChar);

    // determining length of characters to remove from back of allChars
    int lengthToRemoveFromBack = offsetInd;

    // bringing the length of characters from the back to front of resulting string
    String result =
      allChars.substring(allChars.length() - lengthToRemoveFromBack) +
      allChars.substring(0, allChars.length() - lengthToRemoveFromBack);

    return result;
  }
}
