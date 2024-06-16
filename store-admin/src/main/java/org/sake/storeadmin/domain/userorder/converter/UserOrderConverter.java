package org.sake.storeadmin.domain.userorder.converter;

import org.sake.db.userorder.UserOrderEntity;
import org.sake.storeadmin.domain.userorder.controller.model.UserOrderResponse;
import org.springframework.stereotype.Service;

@Service
public class UserOrderConverter {

    public UserOrderResponse toResponse(UserOrderEntity userOrderEntity){
        return UserOrderResponse.builder()
                .id(userOrderEntity.getId())
                .userId(userOrderEntity.getUserId())
                .storeId(userOrderEntity.getStoreId())
                .status(userOrderEntity.getStatus())
                .amount(userOrderEntity.getAmount())
                .orderedAt(userOrderEntity.getOrderedAt())
                .acceptedAt(userOrderEntity.getAcceptedAt())
                .deliveryStartedAt(userOrderEntity.getDeliveryStartedAt())
                .receivedAt(userOrderEntity.getReceivedAt())
                .build();
    }
}
