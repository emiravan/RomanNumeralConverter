
// RomanNumeralConverter.java
import java.util.Scanner;

public class RomanNumeralConverter {
  public static void main(String[] args) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    System.out.print("Enter number: ");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt(); // Örneğin 2234
    sc.close();

    String output = "";

    for (int i = 0; i < values.length; i++) {
      while (number >= values[i]) {
        output += numerals[i];
        number -= values[i];
      }
    }

    System.out.println("Roman numeral: " + output.toString());
  }

  public static String multiplyString(String str, int times) {
    if (times <= 0)
      return "";
    String result = "";
    for (int i = 0; i < times; i++)
      result += str;
    return result;
  }
}
