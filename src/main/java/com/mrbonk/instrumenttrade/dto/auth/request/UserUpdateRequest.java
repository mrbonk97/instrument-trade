package com.mrbonk.instrumenttrade.dto.auth.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    String email;
    String name;
    String password;
    String phoneNumber;
    String profileImage;
}
