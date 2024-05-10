package com.application.api.security

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.util.*

@Entity
@DiscriminatorValue(value="ADMIN")
class Admin(
    id: String,
    email: String,
    pwd: String,
    firstName: String,
    lastName: String,
    roles: String,
    enabled: Boolean,
    accountNonExpired: Boolean,
    accountNonLocked: Boolean,
    credentialsNonExpired: Boolean,
    created: Date,
    modified: Date
): User(
    id,
    email,
    pwd,
    firstName,
    lastName,
    roles,
    enabled,
    accountNonExpired,
    accountNonLocked,
    credentialsNonExpired,
    created,
    modified
) {
    constructor(): this("","","","","","",true,
        true, true,true,Date(),Date())
}