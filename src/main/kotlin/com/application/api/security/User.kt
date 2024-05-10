package com.application.api.security

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
open class User(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(36)")
    var id: String = "",

    @Column(unique = true, nullable = false)
    @NotNull
    @Email
    var email: String = "",

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    var pwd: String = "",

    @NotBlank
    var firstName: String = "",

    @NotBlank
    var lasName: String = "",

    var roles: String = "",
    var enabled: Boolean = true,
    var accountNonExpired: Boolean = true,
    var accountNonLocked: Boolean = true,
    var credentialsNonExpired: Boolean = true,

    @CreationTimestamp
    var created: Date = Date(),

    @UpdateTimestamp
    var modified: Date = Date()
    ): UserDetails {

    constructor(): this(
        "","","","","","",true,
        true,true,true,Date(),Date()
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        roles.split(",")
            .forEach {
                it -> authorities.add(SimpleGrantedAuthority(it.trim()))
            }
        return authorities
    }

    override fun getPassword() = pwd

    override fun getUsername() = email

    override fun isAccountNonExpired() = accountNonExpired

    override fun isAccountNonLocked() = accountNonLocked

    override fun isCredentialsNonExpired() = credentialsNonExpired

    override fun isEnabled() = enabled

}