package com.rahuj.rahuj.models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = true)
    private String login;
    @Column(unique = true, nullable = true)
    private String email;
    private String password;
    public Boolean locked;
    public Boolean enable;

    public Client(String login, String email, String password, Boolean locked, Boolean enable,
            List<Expenditure> expenditureList, List<Revenue> revenueList) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.enable = enable;
        this.expenditureList = expenditureList;
        this.revenueList = revenueList;
    }

    @OneToMany(mappedBy = "user")
    private List<Expenditure> expenditureList;

    @OneToMany(mappedBy = "user")
    private List<Revenue> revenueList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return Collections.singleton(authority);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @Override
    public String getPassword(){
        return password;
    }
}
