package com.application.api.controller

import com.application.api.security.User
import com.application.api.security.UserDTO
import com.application.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.print.attribute.standard.Media

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getUsers() = userService.getUsers()

    @PostMapping(
        value = ["/admin"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertAdmin( @RequestBody user: UserDTO) = userService.saveAdmin(user)

    @PostMapping(
        value = ["/member"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertMember(
        @RequestBody user: UserDTO
    ) = userService.saveMember(user)

    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteUser(
        @PathVariable(name = "id") id : String
    ) = userService.deleteUser(id)

    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateUser(
        @RequestBody user: User
    ): User? = userService.updateUser(user)

}