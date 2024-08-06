package com.ak_meer.form_app.model;

import com.ak_meer.form_app.repo.UserRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "user_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable , UserDetails   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String role;
    private List<String> authorities;
    private boolean isActive;
    private boolean isEnabled;
    private boolean isNotLocked;
    private String verificationCode;
    private boolean isVerified;
    private Date joinDate;
    private Date lastLoginDate;
    private Date createDate;
    private Date lastUpdateDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    public boolean isEnabled(boolean isEnabled) {
        return this.isEnabled = isEnabled;
    }
    public boolean isVerified(boolean isVerified) {
        return this.isVerified = isVerified;
    }


}