package calculator;

class ArabicNumber extends Number{

    ArabicNumber(int value){
        this.value = value;
        this.type = "arabic";
    }

    ArabicNumber(String value){
        this.value = Integer.parseInt(value);
        this.type = "arabic";
    }
}
