package org.example.test.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StringUtilTest {

    StringUtil stringUtil;

    @Before
    public void setup(){
         stringUtil = new StringUtil();
    }


    @Test
    public void when_not_empty_string_it_will_return_false(){
        //arrange
        String anyNotEmptyString = "not_empty_string";
        //act
        boolean isEmptyString = stringUtil.isEmpty(anyNotEmptyString);
        //assert
        assertFalse(isEmptyString);
    }

    @Test
    public void when_empty_string_it_will_return_true(){
        //arrange
        String emptyString = "";
        //act
        boolean isEmptyString = stringUtil.isEmpty(emptyString);
        //assert
        assertTrue(isEmptyString);
    }

    @Test
    public void when_null_string_it_will_return_true(){
        //arrange
        String nullString = null;
        //act
        boolean isEmptyString = stringUtil.isEmpty(nullString);
        //assert
        assertTrue(isEmptyString);
    }

    @Test
    public void when_string_with_space_it_will_return_true(){
        //arrange
        String spaceString = " ";
        //act
        boolean isEmptyString = stringUtil.isEmpty(spaceString);
        //assert
        assertTrue(isEmptyString);
    }
}