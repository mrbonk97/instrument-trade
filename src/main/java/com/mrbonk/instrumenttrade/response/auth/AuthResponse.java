package com.mrbonk.instrumenttrade.response.auth;

import com.mrbonk.instrumenttrade.model.Image;
import com.mrbonk.instrumenttrade.model.Provider;
import com.mrbonk.instrumenttrade.model.Role;
import com.mrbonk.instrumenttrade.model.User;
import com.mrbonk.instrumenttrade.utils.JwtTokenUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Long id;
    private String email;
    private String name;
    private Image profileImage;
    private Boolean emailVerified;
    private Role role;
    private Provider provider;
    private String providerId;
    private String JwtToken;

    public AuthResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.emailVerified = user.getEmailVerified();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.providerId = user.getProviderId();
        this.JwtToken = JwtTokenUtils.generateToken(user.getId());
    }
}
