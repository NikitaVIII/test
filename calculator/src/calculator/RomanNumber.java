package calculator;

class RomanNumber  extends Number{
    RomanNumber(int value){
        this.value = value;
        this.type = "roman";
    }

    RomanNumber(String value){
        if (NumberHelper.isCorrect(value)) {
            this.value = NumberHelper.romanToArabic(value);
            this.type = "roman";
        } else {
            throw new RuntimeException("Некорректное или слишком большое римское число");
        }
    }
}