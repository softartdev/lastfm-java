package de.umass.util;

import static org.junit.Assert.assertEquals;

public class StringUtilitiesTest {

    @org.junit.Test
    public void md5() {
        String actual = StringUtilities.md5("");
        String expected = "d41d8cd98f00b204e9800998ecf8427e";
        assertEquals(expected, actual);
    }
}