package org.sake.api.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.api.Api;
import org.sake.api.domain.store.business.StoreBusiness;
import org.sake.api.domain.store.controller.model.StoreRegisterRequest;
import org.sake.api.domain.store.controller.model.StoreResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/store")
public class StoreOpenApiController {

    private final StoreBusiness storeBusiness;

    @PostMapping("/register")
    public Api<StoreResponse> register(
            @Valid
            @RequestBody Api<StoreRegisterRequest> request
    ){
        var response = storeBusiness.register(request.getBody());
        return Api.OK(response);

    }
}
