package org.sake.api.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.annotation.Business;
import org.sake.api.common.annotation.UserSession;
import org.sake.api.common.api.Api;
import org.sake.api.domain.token.business.TokenBusiness;
import org.sake.api.domain.token.controller.model.TokenResponse;
import org.sake.api.domain.user.controller.model.UserLoginRequest;
import org.sake.api.domain.user.controller.model.UserRegisterRequest;
import org.sake.api.domain.user.controller.model.UserResponse;
import org.sake.api.domain.user.converter.UserConverter;
import org.sake.api.domain.user.model.User;
import org.sake.api.domain.user.service.UserService;

@RequiredArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;

    private final UserConverter userConverter;

    private final TokenBusiness tokenBusiness;

    /**
     * 사용자에 대한 가입처리 로직
     * 1. request -> entity
     * 2. entity -> save
     * 3. save Entuty -> response
     * 4. response return
     */
    public UserResponse register(UserRegisterRequest request) {

        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);
        return response;


    }

    /**
     * 1. email, password 를 가지고 사용자 체크
     * 2. user entity 로그인 확인
     * 3. token 생성
     * 4. token response
     */
    public TokenResponse login(UserLoginRequest request) {
        var userEntity = userService.login(request.getEmail(), request.getPassword());
        var tokenResponse = tokenBusiness.issueToken(userEntity);
        return tokenResponse;

    }

    public UserResponse me(
            User user
    ) {
        var userEntity = userService.getUserWithThrow(user.getId());
        var response = userConverter.toResponse(userEntity);
        return response;


    }
}


