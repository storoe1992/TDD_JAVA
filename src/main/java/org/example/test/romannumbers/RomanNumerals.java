package org.example.test.romannumbers;

import java.util.*;

public class RomanNumerals {

    private final static List <RomanNumber> romanNumbers  = new ArrayList<>();
    private final static Map <String, RomanNumber> substractionRules = new HashMap<>();

    static {
        RomanNumber romanNumberI = new RomanNumber("I", 1, 3);
        RomanNumber romanNumberV = new RomanNumber("V", 5, 1);
        RomanNumber romanNumberX = new RomanNumber("X", 10, 3);
        RomanNumber romanNumberL = new RomanNumber("L", 50, 1);
        RomanNumber romanNumberC = new RomanNumber("C", 100, 3);
        RomanNumber romanNumberD = new RomanNumber("D", 500, 1);
        RomanNumber romanNumberM = new RomanNumber("M", 1000, 3);

        romanNumbers.add(romanNumberI);
        romanNumbers.add(romanNumberV);
        romanNumbers.add(romanNumberX);
        romanNumbers.add(romanNumberL);
        romanNumbers.add(romanNumberC);
        romanNumbers.add(romanNumberD);
        romanNumbers.add(romanNumberM);

        Collections.sort(romanNumbers,(x,y)-> x.getArabicValue() < y.getArabicValue() ? -1 : 1);

        substractionRules.put("V",romanNumberI);
        substractionRules.put("X",romanNumberI);
        substractionRules.put("L",romanNumberX);
        substractionRules.put("C",romanNumberX);
        substractionRules.put("D",romanNumberC);
        substractionRules.put("M",romanNumberC);
    }

    public static String arabicToRoman(int number){
        return arabicToRoman(number,new StringBuilder());
    }

    public static String arabicToRoman(int number,StringBuilder stringBuilder){
        RomanNumber maxRomanNumberRepresentation = getMaxRomanNumberRepresentation(number);
        if(maxRomanNumberRepresentation.getArabicValue() > number){
            RomanNumber substractionRomanNumber = substractionRules.get(maxRomanNumberRepresentation.getRomanNumber());
            int substraction = maxRomanNumberRepresentation.getArabicValue() - substractionRomanNumber.getArabicValue();
            if(number - substraction == 0)
                stringBuilder
                        .append(substractionRomanNumber.getRomanNumber())
                        .append(maxRomanNumberRepresentation.getRomanNumber());
            else{
                int maxCantValue = substractionRomanNumber.getMaxCantValue();
                if(maxCantValue < number && substraction < number){
                    stringBuilder
                            .append(substractionRomanNumber)
                            .append(maxRomanNumberRepresentation);
                    int result = number - maxRomanNumberRepresentation.getArabicValue() + substractionRomanNumber.getArabicValue();
                    if(result != 0)
                        arabicToRoman(result, stringBuilder);
                }else {
                    RomanNumber inmediateInferior = getInmediateInferior(maxRomanNumberRepresentation);
                    stringBuilder.append(inmediateInferior);
                    int result = number - inmediateInferior.getArabicValue();
                    if (result != 0)
                        arabicToRoman(result, stringBuilder);
                }
            }
        }else{
            int result = appendWhileMaxNumber(number, maxRomanNumberRepresentation, stringBuilder);
            if(result != 0)
                arabicToRoman(result,stringBuilder);
        }

        return stringBuilder.toString();
    }


    private static int appendWhileMaxNumber(int number,RomanNumber maxRomanNumberRepresentation,StringBuilder stringBuilder){
        int result = number;
        int maxCharacter = countCharacter(stringBuilder.toString(),maxRomanNumberRepresentation.getRomanNumber().toCharArray()[0]);
        if(number >= maxRomanNumberRepresentation.getArabicValue() && maxCharacter < maxRomanNumberRepresentation.getCantRepetitions() && number != 0){
            stringBuilder.append(maxRomanNumberRepresentation);
            result = number - maxRomanNumberRepresentation.getArabicValue();
        }
        return result;
    }

    private static int countCharacter(String str,char character){
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if(aChar == character)
                count++;
        }
        return count;
    }

    private static RomanNumber getInmediateInferior(RomanNumber superior){
        RomanNumber result = superior;
        for (RomanNumber romanNumber : romanNumbers) {
            if(romanNumber.getArabicValue() < superior.getArabicValue())
                result = romanNumber;
        }
        return result;
    }

    private static RomanNumber getMaxRomanNumberRepresentation(int number,RomanNumber maxRomanNumberRepresentation){
        int maxCantNumber = maxRomanNumberRepresentation.getArabicValue() * maxRomanNumberRepresentation.getCantRepetitions();
        int resta = number - maxCantNumber;
        if(resta > 0){
            Optional<RomanNumber> first = romanNumbers
                    .stream()
                    .filter(rn -> rn.getArabicValue() > maxRomanNumberRepresentation.getArabicValue())
                    .findFirst();
            if(first.isPresent())
                return getMaxRomanNumberRepresentation(number,first.get());
            else return maxRomanNumberRepresentation;
        }else return maxRomanNumberRepresentation;
    }

    private static   RomanNumber getMaxRomanNumberRepresentation(int number) {
        RomanNumber romanNumberResult = null;
        for (RomanNumber romanNumber : romanNumbers) {
            if(romanNumber.getArabicValue() <= number)
                romanNumberResult = romanNumber;
        }
        return getMaxRomanNumberRepresentation(number,romanNumberResult);
    }
}
