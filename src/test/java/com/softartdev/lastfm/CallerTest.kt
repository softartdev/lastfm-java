package com.softartdev.lastfm

import com.softartdev.lastfm.cache.FileSystemCache
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.net.MalformedURLException
import java.net.Proxy

class CallerTest {

    private var caller: Caller? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val constructor = Caller::class.java.getDeclaredConstructor()
        constructor.isAccessible = true
        caller = constructor.newInstance()
        constructor.isAccessible = false
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        caller = null
    }

    @Test
    fun getInstance() {
        assertNotNull(caller)
    }

    @Test
    fun setApiRootUrl() {
        val defaultApiField = Caller::class.java.getDeclaredField("DEFAULT_API_ROOT")
        defaultApiField.isAccessible = true
        val expected = defaultApiField.get(caller)
        defaultApiField.isAccessible = false

        val apiField = Caller::class.java.getDeclaredField("apiRootUrl")
        apiField.isAccessible = true
        val actual = apiField.get(caller)

        assertEquals(expected, actual)

        caller?.setApiRootUrl(null)
        assertNull(apiField.get(caller))
        apiField.isAccessible = false
    }

    @Test
    fun setProxy() {
        val expected = Proxy.NO_PROXY
        caller?.proxy = expected
        val actual = caller?.proxy
        assertEquals(expected, actual)
    }

    @Test
    fun getProxy() {
        assertNull(caller?.proxy)
    }

    @Test
    fun setUserAgent() {
        caller?.userAgent = null
        assertNull(caller?.userAgent)
    }

    @Test
    fun getUserAgent() {
        assertEquals("tst", caller?.userAgent)
    }

    @Test
    fun getCache() {
        assertTrue(caller?.cache is FileSystemCache)
    }

    @Test
    fun setCache() {
        caller?.cache = null
        assertNull(caller?.cache)
    }

    @Test
    @Suppress("DEPRECATION")
    fun setDebugMode() {
        caller?.isDebugMode = true
        assertTrue(caller?.isDebugMode == true)
    }

    @Test
    @Suppress("DEPRECATION")
    fun isDebugMode() {
        assertFalse(caller?.isDebugMode == true)
    }

    @Test
    fun getLogger() {
        assertNotNull(caller?.logger)
    }

    @Test
    fun getLastResult() {
        assertNull(caller?.lastResult)
    }

    @Test(expected = NullPointerException::class)
    fun call() {
        caller?.call(null, "", emptyMap())
    }

    @Test(expected = MalformedURLException::class)
    fun openConnection() {
        caller?.openConnection(null)
    }
}