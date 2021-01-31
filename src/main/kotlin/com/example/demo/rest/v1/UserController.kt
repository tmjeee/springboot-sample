package com.example.demo.rest.v1

import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.sql.DataSource

data class User(
 val username: String,
 val description: String) {}

@RestController
class UserController @Autowired constructor(val service: UserService): V1Controller() {

    @GetMapping(value = ["/users"])
    fun getUsers(): List<User> {
        System.out.println("******************************** ${service.findUsers()}");
        return listOf(
                User("user1", "User 1"),
                User("user2", "User 2"),
                User("user3", "User 3")
        );
    }

    @GetMapping(value = ["/user/{username}"])
    fun getUser(@PathVariable username: String): User {
        return User(username, "${username} description");
    }

}