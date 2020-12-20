package org.example.test.romannumbers;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
public class RomanNumeralsTest {

    @Test
    public void sum_roman_numbers_test_case(){
        String romanNumber1 = RomanNumerals.arabicToRoman(1);
        String romanNumber2 = RomanNumerals.arabicToRoman(2);
        String romanNumber3 = RomanNumerals.arabicToRoman(3);
        String romanNumber5 = RomanNumerals.arabicToRoman(5);
        String romanNumber6 = RomanNumerals.arabicToRoman(6);
        String romanNumber7= RomanNumerals.arabicToRoman(7);
        String romanNumberX= RomanNumerals.arabicToRoman(10);
        String romanNumberXI= RomanNumerals.arabicToRoman(11);
        String romanNumberXV= RomanNumerals.arabicToRoman(15);
        String romanNumberXVI= RomanNumerals.arabicToRoman(16);
        String romanNumberL = RomanNumerals.arabicToRoman(50);
        String romanNumberLVI = RomanNumerals.arabicToRoman(56);
        String romanNumberLX = RomanNumerals.arabicToRoman(60);
        String romanNumberLXX = RomanNumerals.arabicToRoman(70);
        String romanNumberLXXX = RomanNumerals.arabicToRoman(80);
        String romanNumberLXXXI = RomanNumerals.arabicToRoman(81);
        String romanNumberLXXXV = RomanNumerals.arabicToRoman(85);
        String romanNumberLXXXVI = RomanNumerals.arabicToRoman(86);
        String romanNumberCXXVI = RomanNumerals.arabicToRoman(126);
        String romanNumberMMDVII = RomanNumerals.arabicToRoman(2507);
        Assert.assertThat(romanNumber1,is("I"));
        Assert.assertThat(romanNumber2,is("II"));
        Assert.assertThat(romanNumber3,is("III"));
        Assert.assertThat(romanNumber5,is("V"));
        Assert.assertThat(romanNumber6,is("VI"));
        Assert.assertThat(romanNumber7,is("VII"));
        Assert.assertThat(romanNumberX,is("X"));
        Assert.assertThat(romanNumberXI,is("XI"));
        Assert.assertThat(romanNumberXV,is("XV"));
        Assert.assertThat(romanNumberXVI,is("XVI"));
        Assert.assertThat(romanNumberL,is("L"));
        Assert.assertThat(romanNumberLVI,is("LVI"));
        Assert.assertThat(romanNumberLX,is("LX"));
        Assert.assertThat(romanNumberLXX,is("LXX"));
        Assert.assertThat(romanNumberLXXX,is("LXXX"));
        Assert.assertThat(romanNumberLXXXI,is("LXXXI"));
        Assert.assertThat(romanNumberLXXXV,is("LXXXV"));
        Assert.assertThat(romanNumberLXXXVI,is("LXXXVI"));
        Assert.assertThat(romanNumberCXXVI,is("CXXVI"));
        Assert.assertThat(romanNumberMMDVII,is("MMDVII"));
    }

    @Test
    public void substraction_roman_numbers_test_case(){
        String romanNumberIV = RomanNumerals.arabicToRoman(4);
        String romanNumberIX = RomanNumerals.arabicToRoman(9);
        String romanNumberXIV = RomanNumerals.arabicToRoman(14);
        String romanNumberXIX = RomanNumerals.arabicToRoman(19);
        String romanNumberXXIV = RomanNumerals.arabicToRoman(24);
        String romanNumberXL= RomanNumerals.arabicToRoman(40);
        String romanNumberXLIX= RomanNumerals.arabicToRoman(49);
        String romanNumberXC= RomanNumerals.arabicToRoman(90);
        String romanNumberXXIX= RomanNumerals.arabicToRoman(99);
        String romanNumberCD= RomanNumerals.arabicToRoman(400);
        String romanNumberCM= RomanNumerals.arabicToRoman(900);
        Assert.assertThat(romanNumberIV,is("IV"));
        Assert.assertThat(romanNumberIX,is("IX"));
        Assert.assertThat(romanNumberXIV,is("XIV"));
        Assert.assertThat(romanNumberXIX,is("XIX"));
        Assert.assertThat(romanNumberXXIV,is("XXIV"));
        Assert.assertThat(romanNumberXL,is("XL"));
        Assert.assertThat(romanNumberXLIX,is("XLIX"));
        Assert.assertThat(romanNumberXC,is("XC"));
        Assert.assertThat(romanNumberXXIX,is("XCIX"));
        Assert.assertThat(romanNumberCD,is("CD"));
        Assert.assertThat(romanNumberCM,is("CM"));
    }
}