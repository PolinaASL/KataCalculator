import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        return input;
    }

    public static void main(String[] args) {
        System.out.println("Input: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        String Num1 = parts[0];
        String operator = parts[1];
        String Num2 = parts[2];

        int romanNumber1 = romanToArabic(Num1);
        int romanNumber2 = romanToArabic(Num2);

        int arabicNumber1 = 0;
        int arabicNumber2 = 0;

        if (romanNumber1 == -1 || romanNumber2 == -1) {
            try {
                arabicNumber1 = Integer.parseInt(Num1);
                arabicNumber2 = Integer.parseInt(Num2);
            } catch (NumberFormatException e) {
                System.out.println("throw Exception");
                return;
            }
        }

        if ((arabicNumber1 < 11 && arabicNumber1 > 0) && (arabicNumber2 < 11 && arabicNumber2 > 0)) {
            int arabicOutput;
            switch (operator) {
                case "+":
                    arabicOutput = arabicNumber1 + arabicNumber2;
                    System.out.println("Output: " + arabicOutput);
                    break;
                case "-":
                    arabicOutput = arabicNumber1 - arabicNumber2;
                    System.out.println("Output: " + arabicOutput);
                    break;
                case "*":
                    arabicOutput = arabicNumber1 * arabicNumber2;
                    System.out.println("Output: " + arabicOutput);
                    break;
                case "/":
                    arabicOutput = arabicNumber1 / arabicNumber2;
                    System.out.println("Output: " + arabicOutput);
                    break;
                default:
                    return;
            }
        }
        if ((romanNumber1 < 11 && romanNumber1 > 0) && (romanNumber2 < 11 && romanNumber2 > 0)) {
            int romanOutput;
            switch (operator) {
                case "+":
                    romanOutput = romanNumber1 + romanNumber2;
                    if (romanOutput <= 0) {
                        System.out.println("throws Exception");
                        return;
                    } else {
                        String romanFinalOutput = arabicToRoman(romanOutput);
                        System.out.println("Output: " + romanFinalOutput);
                    }
                    break;
                case "-":
                    romanOutput = romanNumber1 - romanNumber2;
                    if (romanOutput <= 0) {
                        System.out.println("throws Exception");
                        return;
                    } else {
                        String romanFinalOutput = arabicToRoman(romanOutput);
                        System.out.println("Output: " + romanFinalOutput);
                    }
                    break;
                case "*":
                    romanOutput = romanNumber1 * romanNumber2;
                    if (romanOutput <= 0) {
                        System.out.println("throws Exception");
                        return;
                    } else {
                        String romanFinalOutput = arabicToRoman(romanOutput);
                        System.out.println("Output: " + romanFinalOutput);
                    }
                    break;
                case "/":
                    romanOutput = romanNumber1 / romanNumber2;
                    if (romanOutput <= 0) {
                        System.out.println("throws Exception");
                        return;
                    } else {
                        String romanFinalOutput = arabicToRoman(romanOutput);
                        System.out.println("Output: " + romanFinalOutput);
                    }
                    break;
                default:
                    System.out.println("throws Exception");
                    return;
            }
        }
    }
    private static int romanToArabic(String romanNumber) {
        String[] romanValue = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] arabicValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < romanValue.length; i++) {
            if (romanNumber.equals(romanValue[i])) {
                return arabicValues[i];
            }
        }
        System.out.println("throws Exception");
        return -1;
    }
    private static String arabicToRoman(int romanNumber) {
        int[] arabicNumerals = {100, 50, 10, 5, 1};
        String[] romanNumerals = {"C", "L", "X", "V", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arabicNumerals.length; i++) {
            while (romanNumber >= arabicNumerals[i]) {
                result.append(romanNumerals[i]);
                romanNumber -= arabicNumerals[i];
            }
        }
        return result.toString();
    }
}
