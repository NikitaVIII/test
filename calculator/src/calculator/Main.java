package calculator;
import java.util.Scanner;
import java.io.IOException;
import java.lang.RuntimeException;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        while (true){
            String input = in.nextLine();
            if (input.equals("exit")){
                break;
            }
            System.out.println(calc(input));

        }

        in.close();


    }



    public static String calc(String input) throws IOException {
        String[] operands = input.split("\\s+");
        if (operands.length != 3){
            throw new IOException("Некорректный ввод");
        }
        Number a = NumberHelper.getNumber(operands[0]);
        Number b = NumberHelper.getNumber(operands[2]);
        String operator = operands[1];

        if ((a.value < 1 || a.value > 10) || (b.value < 1 || b.value > 10)){
            throw new RuntimeException("Числа должны быть в диапазоне от 1 до 10");
        }

        int result;
        if (a.type.equals(b.type)){
            switch (operator){
                case "+":
                    result = a.value + b.value;
                    if (a.type.equals("arabic")){
                        return Integer.toString(result);
                    }else{
                        return NumberHelper.arabicToRoman(result);
                    }
                case "-":
                    result = a.value - b.value;
                    if (a.type.equals("arabic")){
                        return Integer.toString(result);
                    }else {
                        if (result > 0){
                            return NumberHelper.arabicToRoman(result);
                        }else {
                            throw new RuntimeException("Получится римское число <= 0");
                        }
                    }
                case "/":
                    result = a.value / b.value;
                    if (a.type.equals("arabic")){
                        return Integer.toString(result);
                    }else {
                        if (result < 1){
                            throw new RuntimeException("Получится римское число менее единицы");
                        }
                        return NumberHelper.arabicToRoman(result);
                    }
                case "*":
                    result = a.value * b.value;
                    if (a.type.equals("arabic")){
                        return Integer.toString(result);
                    }else {
                        return NumberHelper.arabicToRoman(result);
                    }
                default:
                    throw new RuntimeException("Неизвестная операция");
            }
        } else {
            throw new RuntimeException("Разные типы чисел");
        }
    }
}