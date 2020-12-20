package org.example.test.romannumbers;

public class RomanNumber implements Comparable<RomanNumber>{
    private String romanNumber;
    private int arabicValue;
    private int cantRepetitions;

    public RomanNumber(String romanNumber, int arabicValue,int cantRepetitions) {
        this.romanNumber = romanNumber;
        this.arabicValue = arabicValue;
        this.cantRepetitions = cantRepetitions;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public int getArabicValue() {
        return arabicValue;
    }

    @Override
    public int compareTo(RomanNumber comparator) {
        return comparator.getArabicValue();
    }

    public int getCantRepetitions() {
        return cantRepetitions;
    }

    public String toString(){
        return romanNumber;
    }

    public int getMaxCantValue(){
        return cantRepetitions * arabicValue;
    }
}
