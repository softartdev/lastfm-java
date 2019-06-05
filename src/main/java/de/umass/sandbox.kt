package de.umass

import de.umass.lastfm.User
import java.text.DateFormat

fun main() {
    val key = "b25b959554ed76058ac220b7b2e0a026" //this is the key used in the Last.fm API examples
    val user = "JRoar"
    val chart = User.getWeeklyArtistChart(user, 10, key)
    val format = DateFormat.getDateInstance()
    val from = format.format(chart.from)
    val to = format.format(chart.to)
    println("Charts for $user for the week from $from to $to")
    val artists = chart.entries
    for (artist in artists) {
        println(artist.name)
    }
}
