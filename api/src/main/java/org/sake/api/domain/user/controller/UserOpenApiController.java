package org.sake.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.api.Api;
import org.sake.api.domain.token.controller.model.TokenResponse;
import org.sake.api.domain.user.business.UserBusiness;
import org.sake.api.domain.user.controller.model.UserLoginRequest;
import org.sake.api.domain.user.controller.model.UserRegisterRequest;
import org.sake.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    private final UserBusiness userBusiness;

    // 사용자 가입 요청
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ) {
        var response = userBusiness.register(request.getBody());
        return Api.OK(response);
    }

    // 로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
        @Valid
        @RequestBody Api<UserLoginRequest> request
    ){
        var response = userBusiness.login(request.getBody());
        return Api.OK(response);
    }
}

