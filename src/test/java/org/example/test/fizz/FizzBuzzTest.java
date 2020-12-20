package org.example.test.fizz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FizzBuzzTest {


    @Test
    public void when_number_divisible_by_3_return_Fizz() {
        //arrange
        int someNumberDivisibleBy3 = 3;
        int anotherNumberDivisibleBy3 = 6;
        //act
        String resultSomeNumberDivisibleBy3 = FizzBuzz.fizzBuzz(someNumberDivisibleBy3);
        String resultAnotherNumberDivisibleBy3 = FizzBuzz.fizzBuzz(anotherNumberDivisibleBy3);
        //assert
        assertThat(resultSomeNumberDivisibleBy3,is("Fizz"));
        assertThat(resultAnotherNumberDivisibleBy3,is("Fizz"));
    }

    @Test
    public void when_number_divisible_by_5_return_Buzz() {
        //arrange
        int someNumberDivisibleBy5 = 5;
        int anotherNumberDivisibleBy5 = 10;
        //act
        String resultSomeNumberDivisibleBy5 = FizzBuzz.fizzBuzz(someNumberDivisibleBy5);
        String resultAnotherNumberDivisibleBy5 = FizzBuzz.fizzBuzz(anotherNumberDivisibleBy5);
        //assert
        assertThat(resultSomeNumberDivisibleBy5,is("Buzz"));
        assertThat(resultAnotherNumberDivisibleBy5,is("Buzz"));
    }

    @Test
    public void when_number_divisible_by_5_and_3_return_FizzBuzz() {
        //arrange
        int someNumberDivisibleBy5And3 = 15;
        int anotherNumberDivisibleBy5And3 = 30;
        //act
        String resultSomeNumberDivisibleBy5And3 = FizzBuzz.fizzBuzz(someNumberDivisibleBy5And3);
        String resultAnotherNumberDivisibleBy5And3 = FizzBuzz.fizzBuzz(anotherNumberDivisibleBy5And3);
        //assert
        assertThat(resultSomeNumberDivisibleBy5And3,is("FizzBuzz"));
        assertThat(resultAnotherNumberDivisibleBy5And3,is("FizzBuzz"));
    }

    @Test
    public void when_number_not_divisible_by_5_and_3_return_same_number() {
        //arrange
        int someNumberNotDivisibleBy3 = 2;
        int someNumberNotDivisibleBy5 = 16;
        //act
        String resultSomeNumberNotDivisibleBy3 = FizzBuzz.fizzBuzz(someNumberNotDivisibleBy3);
        String resultSomeNumberNotDivisibleBy5 = FizzBuzz.fizzBuzz(someNumberNotDivisibleBy5);
        //assert
        assertThat(resultSomeNumberNotDivisibleBy3,is("2"));
        assertThat(resultSomeNumberNotDivisibleBy5,is("16"));
    }
}