package org.sake.api.domain.user.converter;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.annotation.Converter;
import org.sake.api.common.api.Api;
import org.sake.api.common.error.ErrorCode;
import org.sake.api.common.exception.ApiException;
import org.sake.api.domain.user.controller.model.UserRegisterRequest;
import org.sake.api.domain.user.controller.model.UserResponse;
import org.sake.db.user.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request){

        return Optional.ofNullable(request)
                .map(it -> {
                    // to entity
                    return UserEntity.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .address(request.getAddress())
                            .build();

                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
    }

    public UserResponse toResponse(UserEntity userEntity) {

        return Optional.ofNullable(userEntity)
            .map(it ->{
                // to response
                return UserResponse.builder()
                        .id(userEntity.getId())
                        .name(userEntity.getName())
                        .email(userEntity.getEmail())
                        .address(userEntity.getAddress())
                        .registeredAt(userEntity.getRegisteredAt())
                        .unregisteredAt(userEntity.getUnregisteredAt())
                        .lastLoginAt(userEntity.getLastLoginAt())
                        .build();
            })
                    .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
        }
    }

