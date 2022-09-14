package com.example.game.entity;

import com.example.game.entity.enums.ERole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(unique = true)
    private String email;
    @Column(length = 3000)
    private String password;
    private Long gold = Long.valueOf(10);

    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"))
    Set<ERole> role = new HashSet<>();
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User(){
    }

    public User(Long id,
                String username,
                String email,
                String password,
                Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * SECURITY
     */
    @Override
    public String getPassword(){
        return password;
    }

        @Override
        public boolean isAccountNonExpired () {
        return true;
    }

        @Override
        public boolean isAccountNonLocked () {
        return true;
    }

        @Override
        public boolean isCredentialsNonExpired () {
        return true;
    }

        @Override
        public boolean isEnabled () {
        return true;
    }

}
