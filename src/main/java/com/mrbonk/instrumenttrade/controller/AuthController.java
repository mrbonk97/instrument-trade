package com.mrbonk.instrumenttrade.controller;

import com.mrbonk.instrumenttrade.dto.Response;
import com.mrbonk.instrumenttrade.dto.auth.request.AuthRequest;
import com.mrbonk.instrumenttrade.model.User;
import com.mrbonk.instrumenttrade.response.auth.AuthResponse;
import com.mrbonk.instrumenttrade.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @GetMapping("/test")
    public String test() {
        return "auth test";
    }

    @PostMapping("/sign-up")
    public Response<AuthResponse> createUser(@RequestBody AuthRequest authRequest) {
        User user = authService.createUser(authRequest.getEmail(), authRequest.getPassword());
        return Response.success(new AuthResponse(user));
    }

    @PostMapping("/log-in")
    public Response<AuthResponse> loginUser(@RequestBody AuthRequest authRequest) {
        User user = authService.loginUser(authRequest.getEmail(), authRequest.getPassword());
        return Response.success(new AuthResponse(user));
    }

}
