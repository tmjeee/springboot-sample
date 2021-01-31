package com.example.demo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.sql.ResultSet
import javax.sql.DataSource

data class User(
        val id: Int,
        val name: String,
        val email: String
){}

@Service
class UserService @Autowired constructor(
        @Qualifier("datasource") val datasource: DataSource,
        @Qualifier("datasource2") val datasource2: DataSource){

    @Transactional(transactionManager= "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED)
    fun findUsers(): List<User> {
        System.out.println("********* datasouce1 ${datasource}")
        System.out.println("********* datasouce2 ${datasource2}")
        val s: List<User>  = JdbcTemplate(datasource).query("SELECT id, name, email, dateOfBirth FROM user") {
            rs: ResultSet, rowNum: Int ->
                User(rs.getInt("id"), rs.getString("name"), rs.getString("email"))
        }
        return s;
    }

}