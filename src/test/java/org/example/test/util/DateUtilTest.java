package org.example.test.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DateUtilTest {

    DateUtil dateUtil;

    @Before
    public void setup(){
        dateUtil = new DateUtil();
    }

    @Test
    public void return_true_when_year_is_divisible_by_400() {
        //arrange
        int some400DivisibleNumber = 1600;
        //act
        boolean isLeapYear = dateUtil.isLeapYear(some400DivisibleNumber);
        //assert
        assertThat(isLeapYear,is(true));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_400(){
        //arrange
        int someNumberDivisibleNumberBy100ButNotBy400 = 1900;
        //act
        boolean isLeapYear = dateUtil.isLeapYear(someNumberDivisibleNumberBy100ButNotBy400);
        //assert
        assertThat(isLeapYear,is(false));
    }


    @Test
    public void return_when_year_is_divisible_by_4_but_not_by_100(){
        //arrange
        int someNumberDivisibleNumberBy4ButNotBy100 = 1996;
        //act
        boolean isLeapYear = dateUtil.isLeapYear(someNumberDivisibleNumberBy4ButNotBy100);
        //assert
        assertThat(isLeapYear,is(true));
    }

    @Test
    public void return_false_when_year_is_not_divisible_by_4(){
        //arrange
        int someNumberNotDivisibleBy4= 1997;
        //act
        boolean isLeapYear = dateUtil.isLeapYear(someNumberNotDivisibleBy4);
        //assert
        assertThat(isLeapYear,is(false));
    }
}