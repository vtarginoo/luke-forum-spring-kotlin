package br.luke.luke_forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class LukeForumApplication

fun main(args: Array<String>) {
	runApplication<LukeForumApplication>(*args)
}
