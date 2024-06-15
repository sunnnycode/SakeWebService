package org.sake.api.domain.userorder.controller.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sake.api.domain.store.controller.model.StoreResponse;
import org.sake.api.domain.storemenu.controller.model.StoreMenuResponse;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderDetailResponse {

    private UserOrderResponse userOrderResponse;

    private StoreResponse storeResponse;

    private List<StoreMenuResponse> storeMenuResponseList;

}
