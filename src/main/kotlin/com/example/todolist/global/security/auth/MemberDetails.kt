package com.example.todolist.global.security.auth

import com.example.todolist.global.role.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class MemberDetails(
    private val memberEmail: String
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority?> =
        mutableListOf(SimpleGrantedAuthority(Role.MEMBER.name))
    override fun getPassword(): String? = null
    override fun getUsername(): String = memberEmail
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = isAccountNonExpired && isAccountNonLocked && isCredentialsNonExpired

}

