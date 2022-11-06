import java.util.Scanner;

public class CalcKata {
    static char operator;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input: ");
        String input = scn.nextLine();
        System.out.println("Output: ");
        int num1,num2,num3,num4,res;
        String resRim;
        char[] data = new char[100];
        for (int i = 0; i < input.length(); i++) {
            data[i] = input.charAt(i);
            if (data[i] == '+') operator = '+';
            if (data[i] == '-') operator = '-';
            if (data[i] == '*') operator = '*';
            if (data[i] == '/') operator = '/';
        }
        String stroke = String.valueOf(data);
        String[] massive = stroke.split("[+-/*]");
        String data1 = massive[0].trim();
        try {
            String data3 = massive[1];
        } catch (Exception a) {
            System.out.println("Cтрока не является математической операцией");
        }
        if (massive.length > 2) {
            try {
                throw new Exception();
            }
            catch (Exception b) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            }
        }
        String data2 = massive[1].trim();
        converters operation = new converters();
        num1 = operation.convertRimToArab(data1);
        num2 = operation.convertRimToArab(data2);
        if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
            try {
                throw new Exception();
            } catch (Exception c) {
                System.out.println("Используются одновременно разные системы счисления");
            }
        } else if (num1 < 0 && num2 < 0) {
            num3 = Integer.parseInt(data1);
            num4 = Integer.parseInt(data2);
            if (num3 > 10 || num4 > 10) {
                try {
                    throw new Exception();
                } catch (Exception d) {
                    System.out.println("Размер вводимых чисел не удовлетворяет заданию");
                }
            } else {
                res = operation.calculate(num3, num4, operator);
                System.out.println(res);
            }
        } else {
            res = operation.calculate(num1, num2, operator);
            if (res < 1) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Результатом работы с римскими числами могут быть только положительные числа");
                }
            } else {
                resRim = operation.convertArabToRim(res);
                System.out.println(resRim);
            }
        }
    }
}
class converters {
    String convertArabToRim (int arab) {
        String[] rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String a = rim[arab];
        return a;
    }
    int convertRimToArab (String rim) {
        if (rim.equals("I")) return 1;
        else if (rim.equals("II")) return 2;
        else if (rim.equals("III")) return 3;
        else if (rim.equals("IV")) return 4;
        else if (rim.equals("V")) return 5;
        else if (rim.equals("VI")) return 6;
        else if (rim.equals("VII")) return 7;
        else if (rim.equals("VIII")) return 8;
        else if (rim.equals("IX")) return 9;
        else if (rim.equals("X")) return 10;
        else return -1;
    }
    int calculate (int number1, int number2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                try {
                    result = number1 / number2;
                } catch (Exception f) {
                    System.out.println("На ноль делить нельзя");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}

