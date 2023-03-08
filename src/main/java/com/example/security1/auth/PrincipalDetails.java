package com.example.security1.auth;

import com.example.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Security 가 /login URL 로 요청이 오면 낚아채서 로그인 진행
 * 로그인 진행이 완료가 되면 Security session 을 만들어준다. (Security ContextHolder 라는 Key 값으로 Session 에 저장)
 * Security 가 가지고 있는 Session (Security ContextHolder) 에 저장할 수 있는 Object 는 Authentication 타입의 객체이어야 함
 * Authentication 안에 User 정보가 있어야 됨.
 * User Object 타입 => UserDetails 타입 객체
 *
 * Security Session => Authentication => UserDetails (UserDetails 를 구현한 PrincipalDetails)
 */

public class PrincipalDetails implements UserDetails {

    private User user;  // Composition

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 해당 User 의 권한을 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

    @Override
    public boolean isEnabled() {
        return true;
    }

}
