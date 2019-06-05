package com.softartdev.lastfm

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.lang.NullPointerException

class AlbumTest {

    private var album: Album? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val clazz = String::class.java
        val constructor = Album::class.java.getDeclaredConstructor(clazz, clazz, clazz)
        constructor.isAccessible = true
        album = constructor.newInstance(null, null, null)
        constructor.isAccessible = false
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        album = null
    }

    @Test
    fun getArtist() {
        assertNull(album?.artist)
    }

    @Test
    fun getReleaseDate() {
        assertNull(album?.releaseDate)
    }

    @Test
    fun getTracks() {
        assertNull(album?.tracks)
    }

    @Test
    fun getInfo() {
        assertNull(Album.getInfo(null, null, null))
    }

    @Test(expected = NullPointerException::class)
    fun addTags() {
        Album.addTags(null, null, null, null)
    }

    @Test(expected = NullPointerException::class)
    fun removeTag() {
        Album.removeTag(null, null, null, null)
    }

    @Test(expected = NullPointerException::class)
    fun getTags() {
        Album.getTags(null, null, null)
    }

    @Test(expected = NullPointerException::class)
    fun search() {
        Album.search(null, null)
    }

    @Test
    fun getBuylinks() {
        assertTrue(Album.getBuylinks(null, null, null, null).isEmpty())
    }

    @Test
    fun getTopTags() {
        assertTrue(Album.getTopTags(null, null, null).isEmpty())
    }

    @Test
    fun getShouts() {
        assertTrue(Album.getShouts(null, null, null) is PaginatedResult)
    }

}