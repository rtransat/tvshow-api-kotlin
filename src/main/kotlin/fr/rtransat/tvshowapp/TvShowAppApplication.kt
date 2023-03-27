package fr.rtransat.tvshowapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TvShowAppApplication

fun main(args: Array<String>) {
    runApplication<TvShowAppApplication>(*args)
}
