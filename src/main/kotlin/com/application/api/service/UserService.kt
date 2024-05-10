package com.application.api.service

import com.application.api.repository.UserRepository
import com.application.api.security.Member
import com.application.api.security.User
import com.application.api.security.UserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService : UserDetailsService {

    @Autowired
    lateinit var repository : UserRepository
    val encoder : BCryptPasswordEncoder(11)

    override fun loadUserByUsername(email: String?): User? {
        return email?.let { repository.findOneByEmail(it) } ?: throw RuntimeException("User not found: $email")
    }

    fun saveMember(user: UserDTO): User {
        val member = Member()
        member.email = user.email
        member.firstName = user.firstName
        member.lasName = user.lastName
        member.pwd = user.password
        member.roles = "MEMBER"
        return repository.save(member)
    }



}