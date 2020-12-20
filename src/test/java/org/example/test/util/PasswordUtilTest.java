package org.example.test.util;

import org.example.test.util.PasswordUtil;
import org.junit.Test;

import static org.example.test.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(WEAK,PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_only_letters_and_numbers(){
        assertEquals(MEDIUM,PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void medium_when_has_only_letters_and_numbers_andSymbols(){
        assertEquals(STRONG,PasswordUtil.assessPassword("abcd1234!"));
    }

}