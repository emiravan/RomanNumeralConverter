import java.util.Scanner;

public class RomanNumeralConverter {
  // Method to convert an integer to a Roman numeral using String
  public static String intToRoman(int number) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    String result = "";

    for (int i = 0; i < values.length; i++) {
      while (number >= values[i]) {
        result += numerals[i];
        number -= values[i];
      }
    }

    return result;
  }

  // Method to convert a Roman numeral to an integer
  public static int romanToInt(String s) {
    char[] romanSymbols = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    int[] romanValues = { 1, 5, 10, 50, 100, 500, 1000 };

    int total = 0;
    int prevValue = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      int value = getValue(ch, romanSymbols, romanValues);

      if (value < prevValue) {
        total -= value;
      } else {
        total += value;
      }

      prevValue = value;
    }

    return total;
  }

  // Helper method to get the integer value of a Roman numeral character
  private static int getValue(char ch, char[] romanSymbols, int[] romanValues) {
    for (int i = 0; i < romanSymbols.length; i++) {
      if (romanSymbols[i] == ch) {
        return romanValues[i];
      }
    }
    return 0; // Return 0 if symbol is not found
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number (or Roman numeral): ");
    String input = sc.nextLine();

    if (input.matches("\\d+")) { // Check if input is a number
      int number = Integer.parseInt(input);
      String romanNumeral = intToRoman(number);
      System.out.println("Roman numeral: " + romanNumeral);
    } else if (input.matches("[IVXLCDM]+")) { // Check if input is a Roman numeral
      int integerValue = romanToInt(input);
      System.out.println("Integer value: " + integerValue);
    } else {
      System.out.println("Invalid input. Please enter a valid number or Roman numeral.");
    }
  }
}
