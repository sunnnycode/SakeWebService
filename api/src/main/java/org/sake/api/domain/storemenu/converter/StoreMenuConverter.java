package org.sake.api.domain.storemenu.converter;

import org.sake.api.common.annotation.Converter;
import org.sake.api.common.error.ErrorCode;
import org.sake.api.common.exception.ApiException;
import org.sake.api.domain.storemenu.controller.model.StoreMenuRegisterRequest;
import org.sake.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.sake.db.storemenu.StoreMenuEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Converter
public class StoreMenuConverter {

    public StoreMenuEntity toEntity(StoreMenuRegisterRequest request){

        return Optional.ofNullable(request)
                .map(it ->{
                    return StoreMenuEntity.builder()
                            .storeId(request.getStoreId())
                            .name(request.getName())
                            .amount(request.getAmount())
                            .thumbnail(request.getThumbnailUrl())
                            .build()
                            ;

                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    public StoreMenuResponse toResponse(
            StoreMenuEntity storeMenuEntity
    ){
        return Optional.ofNullable(storeMenuEntity)
                .map(it -> {
                    return StoreMenuResponse.builder()
                            .id(storeMenuEntity.getId())
                            .name(storeMenuEntity.getName())
                            .storeId(storeMenuEntity.getStoreId())
                            .amount(storeMenuEntity.getAmount())
                            .status(storeMenuEntity.getStatus())
                            .thumbnailUrl(storeMenuEntity.getThumbnail())
                            .likeCount(storeMenuEntity.getLikeCount())
                            .sequence(storeMenuEntity.getSequence())
                            .build()
                            ;
                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT));
    }

    public List<StoreMenuResponse> toResponse(
            List<StoreMenuEntity> list
    ){
        return list.stream()
                .map(it ->toResponse(it))
                .collect(Collectors.toList());
    }


}
