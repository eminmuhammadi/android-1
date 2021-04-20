package com.example.week9fm5cc5.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceCharactersTest {
    ReplaceCharacters replaceCharacters;

    @Before
    public void setup() {
        replaceCharacters = new ReplaceCharacters();
    }

    @Test
    public void testNull() {
        assertEquals("", replaceCharacters.generate(""));
        assertEquals(" ", replaceCharacters.generate(" "));
    }

    @Test
    public void testNoChanges() {
        assertEquals("ABDE", replaceCharacters.generate("ABDE"));
        assertEquals("abde", replaceCharacters.generate("abde"));
        assertEquals("12345", replaceCharacters.generate("12345"));
        assertEquals("------", replaceCharacters.generate("------"));
    }

    @Test
    public void testPositive() {
        assertEquals("m", replaceCharacters.generate("f"));
        assertEquals("M", replaceCharacters.generate("F"));
        assertEquals("5", replaceCharacters.generate("c"));
        assertEquals("5", replaceCharacters.generate("C"));
    }

    @Test
    public void testLongString() {
        assertEquals("10m01", replaceCharacters.generate("10f01"));
        assertEquals("000000000MAB", replaceCharacters.generate("000000000FAB"));
        assertEquals("AAAAAAAAAAAAA5AAAAAAAAAAAA", replaceCharacters.generate("AAAAAAAAAAAAAcAAAAAAAAAAAA"));
        assertEquals("ssss--5--ssss", replaceCharacters.generate("ssss--C--ssss"));
    }

    @Test
    public void testPositiveLong() {
        assertEquals("mmmm", replaceCharacters.generate("ffff"));
        assertEquals("MMMM", replaceCharacters.generate("FFFF"));
        assertEquals("5555", replaceCharacters.generate("cccc"));
        assertEquals("5555", replaceCharacters.generate("CCCC"));
    }
}