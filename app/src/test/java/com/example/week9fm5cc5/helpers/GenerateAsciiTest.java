package com.example.week9fm5cc5.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateAsciiTest {
    GenerateAscii generateAscii;

    @Before
    public void setup() {
        generateAscii = new GenerateAscii();
    }

    @Test
    public void testEmptyAndSpace() {
        assertEquals(0, generateAscii.sum(""));
        assertEquals(32, generateAscii.sum(" "));
        assertEquals(64, generateAscii.sum("  "));
    }

    @Test
    public void testRandomAlphabet() {
        assertEquals(104, generateAscii.sum("h"));
        assertEquals(101, generateAscii.sum("e"));
        assertEquals(108, generateAscii.sum("l"));
        assertEquals(119, generateAscii.sum("w"));
        assertEquals(111, generateAscii.sum("o"));
        assertEquals(114, generateAscii.sum("r"));
        assertEquals(100, generateAscii.sum("d"));
    }

    @Test
    public void testString() {
        assertEquals(104+101+108+119+111+114+100, generateAscii.sum("helword"));
    }

    @Test
    public void testCustomAlphabet() {
        // Azerbaijani (🇦🇿)
        assertEquals(231, generateAscii.sum("ç"));
        assertEquals(246, generateAscii.sum("ö"));
        assertEquals(601, generateAscii.sum("ə"));
        assertEquals(287, generateAscii.sum("ğ"));
        assertEquals(351, generateAscii.sum("ş"));
        assertEquals(305, generateAscii.sum("ı"));
        assertEquals(252, generateAscii.sum("ü"));
    }

    @Test
    public void testNumbers() {
        assertEquals(49, generateAscii.sum("1"));
        assertEquals(50, generateAscii.sum("2"));
        assertEquals(51, generateAscii.sum("3"));
        assertEquals(52, generateAscii.sum("4"));
        assertEquals(53, generateAscii.sum("5"));
        assertEquals(54, generateAscii.sum("6"));
        assertEquals(55, generateAscii.sum("7"));
    }

    @Test
    public void testNonAlpha() {
        assertEquals(45, generateAscii.sum("-"));
        assertEquals(46, generateAscii.sum("."));
        assertEquals(41, generateAscii.sum(")"));
        assertEquals(40, generateAscii.sum("("));
        assertEquals(61, generateAscii.sum("="));
        assertEquals(43, generateAscii.sum("+"));
    }
}