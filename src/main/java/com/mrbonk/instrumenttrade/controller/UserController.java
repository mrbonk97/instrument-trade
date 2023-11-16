package com.mrbonk.instrumenttrade.controller;

import com.mrbonk.instrumenttrade.dto.Response;
import com.mrbonk.instrumenttrade.dto.auth.request.UserUpdateRequest;
import com.mrbonk.instrumenttrade.model.User;
import com.mrbonk.instrumenttrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/users/")
@RestController
public class UserController {
    private final UserService userService;

    @PutMapping("/me")
    public User updateUser(Authentication authentication, @RequestBody UserUpdateRequest userUpdateRequest) {
        Long userId = Long.valueOf(authentication.getName());
        return userService.updateUser(userId, userUpdateRequest.getEmail(), userUpdateRequest.getPassword(), userUpdateRequest.getName(), userUpdateRequest.getProfileImage());
    }

    @DeleteMapping("/me")
    public Response<String> deleteUser(Authentication authentication) {
        Long userId = Long.valueOf(authentication.getName());
        return Response.success("계정 삭제 완료");
    }
}
