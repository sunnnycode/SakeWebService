package org.sake.api.domain.userorder.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderRequest {

    // 주문
    // 특정 사용자가 특정 메뉴를 주문
    // 특정 사용자 = 로그인 된 세션에 들어 있는 사용자
    // 특정 메뉴 id

    @NotNull
    private List<Long> storeMenuIdList;


    public List<Long> getStoreMenuIdList() {
        return storeMenuIdList;
    }

}
