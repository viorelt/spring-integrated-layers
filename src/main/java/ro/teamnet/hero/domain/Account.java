package ro.teamnet.hero.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Account.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */
@Entity
@Table(name="ACCOUNT")
public class Account implements UserDetails {
    @Id
    @Column(name="ID_ACCOUNT")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PERSON", referencedColumnName = "ID_PERSON")
    private Person person;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
