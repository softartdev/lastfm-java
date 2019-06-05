package com.softartdev.util

import org.junit.Assert.assertEquals
import org.junit.Test

class StringUtilitiesTest {

    @Test
    fun md5() {
        val actual = StringUtilities.md5("")
        val expected = "d41d8cd98f00b204e9800998ecf8427e"
        assertEquals(expected, actual)
    }
}