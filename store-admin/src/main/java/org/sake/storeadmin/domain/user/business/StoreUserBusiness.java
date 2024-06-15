package org.sake.storeadmin.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.sake.db.store.StoreRepository;
import org.sake.db.store.enums.StoreStatus;
import org.sake.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.sake.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.sake.storeadmin.domain.user.converter.StoreUserConverter;
import org.sake.storeadmin.domain.user.service.StoreUserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreUserBusiness {

    private final StoreUserConverter storeUserConverter;

    private final StoreUserService storeUserService;

    private final StoreRepository storeRepository; // TODO SERVICE 로 변경하기

    public StoreUserResponse register(
            StoreUserRegisterRequest request
    ){
            var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTRED);

            var entity = storeUserConverter.toEntity(request, storeEntity.get());

            var newEntity = storeUserService.register(entity);

            var response = storeUserConverter.toResponse(newEntity, storeEntity.get());

            return response;
    }
}
