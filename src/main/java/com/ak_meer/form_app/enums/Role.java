package com.ak_meer.form_app.enums;

import com.ak_meer.form_app.constants.Authorities;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Role {
    ADMIN(Authorities.ADMIN_AUTH), USER(Authorities.USER_AUTH), WORKER(Authorities.WORKER_AUTH), PALLET_WORKER(Authorities.PALLET_WORKER_AUTH), MANAGER(Authorities.MANAGER_AUTH);


    private final List<String> authorities;

    Role(List<String> authorities) {
        this.authorities = authorities;
    }


}
