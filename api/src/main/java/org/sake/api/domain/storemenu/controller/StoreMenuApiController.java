package org.sake.api.domain.storemenu.controller;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.api.Api;
import org.sake.api.domain.storemenu.business.StoreMenuBusiness;
import org.sake.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store-menu")
public class StoreMenuApiController {

    private final StoreMenuBusiness storeMenuBusiness;

    @GetMapping("/search")
    public Api<List<StoreMenuResponse>> search(
            @RequestParam Long storeId
    ){
        var response = storeMenuBusiness.search(storeId);
        return Api.OK(response);
    }
}
