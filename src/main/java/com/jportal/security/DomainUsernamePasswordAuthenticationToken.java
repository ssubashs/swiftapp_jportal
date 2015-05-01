package com.jportal.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.jportal.model.Useraccess;

public final class DomainUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    

    public DomainUsernamePasswordAuthenticationToken(String principal, String credentials) {
        super(principal, credentials);
        
    }

    public DomainUsernamePasswordAuthenticationToken(Useraccess principal, String credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        
    }
    
    private static final long serialVersionUID = -5138870746127783L;
}
