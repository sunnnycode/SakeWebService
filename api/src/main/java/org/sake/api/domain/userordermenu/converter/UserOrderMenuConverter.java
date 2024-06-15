package org.sake.api.domain.userordermenu.converter;

import org.sake.api.common.annotation.Converter;
import org.sake.db.storemenu.StoreMenuEntity;
import org.sake.db.userorder.UserOrderEntity;
import org.sake.db.userordermenu.UserOrderMenuEntity;

@Converter
public class UserOrderMenuConverter {

    public UserOrderMenuEntity toEntity(
            UserOrderEntity userOrderEntity,
            StoreMenuEntity storeMenuEntity
    ){
        return UserOrderMenuEntity.builder()
                .userOrderId(userOrderEntity.getId())
                .storeMenuId(storeMenuEntity.getId())
                .build()
                ;
    }
}
