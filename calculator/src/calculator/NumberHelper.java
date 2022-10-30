package calculator;

// Вспомогательный класс для перевода римских чисел в арабские и наоборот
class NumberHelper {

    // 100 - максимальное число, которое может получиться в ответе
    static final String[] romans = new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static final int[] arabics = new int[] { 100, 90, 50, 40, 10, 9, 5, 4, 1};

    // Перевод арабских числе в римские
    static String arabicToRoman(int number){
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < arabics.length) {
            if (number >= arabics[index]) {
                result.append(romans[index]);
                number = number - arabics[index];
            }else {
                index++;
            }
        }

        return result.toString();
    }

    // Перевод римских чисел в арабские
    static int romanToArabic(String number){
        int result = 0;
        for (int i=0; i<romans.length; i++){
            while (number.length() != 0){
                if (romans[i].length() <= number.length()){
                    if (romans[i].equals(number.substring(0,romans[i].length()))){
                        result += arabics[i];
                        number = number.substring(romans[i].length());
                        if (number.length() == 0) {
                            return result;
                        }
                    }else{
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return 0;
    }



    // Метод для определения типа числа
    static Number getNumber(String number){
        Number result;

        try{
            result = new ArabicNumber(number);
        } catch (NumberFormatException e){
            result = new RomanNumber(number);
        }

        return result;
    }


    // Метод проверяет корректность введенного римского числа (для чисел <= 10)
    static boolean isCorrect(String number){
        return number.matches("^(X|IX|IV|V?I{0,3})$");
    }
}
