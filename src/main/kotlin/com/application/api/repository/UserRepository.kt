package com.application.api.repository

import com.application.api.security.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>{
  fun findOneByEmail(email: String): User?
}