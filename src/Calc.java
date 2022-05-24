
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
class  Calc{
    static Scanner scanner = new Scanner(System.in);
    static String result;


    static String numToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }


    static String romanToNumber(String roman) {
        if (roman.equals("I")) {
            return "1";
        } else if (roman.equals("II")) {
            return "2";
        } else if (roman.equals("III")) {
            return "3";
        } else if (roman.equals("IV")) {
            return "4";
        } else if (roman.equals("V")) {
            return "5";
        } else if (roman.equals("VI")) {
            return "6";
        } else if (roman.equals("VII")) {
            return "7";
        } else if (roman.equals("VIII")) {
            return "8";
        } else if (roman.equals("IX")) {
            return "9";
        } else if (roman.equals("X")) {
            return "10";
        }

        return roman;
    }
    // конвертер римских в арабские


    public static class Main {
        public static String calc(String input) {
            int num1 = 0;
            int num2 = 0;
            char operand;
            int results = 0;
            String results2;
            String[] str = input.split(" ");
            String str1 = str[0];
            String str2 = str[1];
            String str3 = str[2];
            String str01 = str1.trim();
            String str02 = str2.trim();
            String str03 = str3.trim();
            try {
                num1 = Integer.parseInt(str01);
                num2 = Integer.parseInt(str03);
            }catch (NumberFormatException e){
                System.out.println("trows Exception // т.к. по тз два числа от 1 до 10, не более");
                System.exit(1);
            }
            if (num1 > 10 | num2 > 10){try {
                throw new IOException();
            }catch (IOException e) {
                System.out.println("trows Exception // т.к. по тз два числа от 1 до 10, не более");
                System.exit(1);}}
            operand = str02.charAt(0);
            if (operand == '+') {
                results = num1 + num2;
            } else if (operand == '-') {
                results = num1 - num2;
            } else if (operand == '*') {
                results = num1 * num2;
            } else if (operand == '/') {
                results = num1 / num2;
            }
            results2 = String.valueOf(results);
            return results2;

        } // метод калькулятор

        public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {
            System.out.println("ВВЕДИТЕ ВЫРАЖЕНИЕ");
            System.out.println("пример (3 + 2),(V * II)");
            System.out.println("_________input_________");
            String[] roman1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String inputUser = scanner.nextLine();
            System.out.println("________Output_________");

            String[] roman = inputUser.split(" ");
            if (roman.length != 3) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("trows Exception // т.к. формат строки не удовлетворяет заданию - два операнда и одие оператор");
                    return;
                }
            }
            String m1 = "";
            String op = "";
            String m2 = "";
            try {
                m1 = roman[0];
                m2 = roman[2];
                op = roman[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
            boolean r1 = false, r2 = false;
            boolean a1 = false, a2 = false;
            for (int i = 0; i < roman1.length; i++) {
                if (roman[0].contains(roman1[i])) {
                    r1 = true;
                }
                if (roman[2].contains(roman1[i])) {
                    r2 = true;
                }
                if (roman[0].contains(arab[i])) {
                    a1 = true;                         // проверка какие символы зашли
                }
                if (roman[2].contains(arab[i])) {
                    a2 = true;
                }
            }
            if (r1 & a2) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. используються одновременно разные системы счисления");
                }
            }
            if (r2 & a1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. используються одновременно разные системы счисления");
                }
            }
            if (r1 & r2) {
                String strnum1 = romanToNumber(m1);
                String strnum2 = romanToNumber(m2);
                String inputrome = strnum1 + " " + roman[1] + " " + strnum2;
                result = calc(inputrome);
//
                int resultRome = Integer.parseInt(result);
                try {
                    System.out.println(numToRoman(resultRome));
                } catch (RuntimeException e) {
                    System.out.println("throws Exception //т.к.в римской системе нет отрицательных чисел");
                }
            }
            if (a1 & a2) {
                result = calc(inputUser);
                System.out.println(result);
            }
        }
    }
}