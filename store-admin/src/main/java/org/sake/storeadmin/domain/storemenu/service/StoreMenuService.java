package org.sake.storeadmin.domain.storemenu.service;

import lombok.RequiredArgsConstructor;
import org.sake.db.storemenu.StoreMenuEntity;
import org.sake.db.storemenu.enums.StoreMenuRepository;
import org.sake.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreMenuService {

    private final StoreMenuRepository storeMenuRepository;

    public StoreMenuEntity getStoreMenuWithThrow(Long id){
        return storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED)
                .orElseThrow(()-> new RuntimeException("Store menu not found"));
    }
}
