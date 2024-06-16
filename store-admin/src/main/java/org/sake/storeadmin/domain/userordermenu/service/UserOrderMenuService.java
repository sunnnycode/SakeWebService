package org.sake.storeadmin.domain.userordermenu.service;

import lombok.RequiredArgsConstructor;
import org.sake.db.userordermenu.UserOrderMenuEntity;
import org.sake.db.userordermenu.UserOrderMenuRepository;
import org.sake.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserOrderMenuService {

    private final UserOrderMenuRepository userOrderMenuRepository;

    public List<UserOrderMenuEntity> getUserOrderMenuList(Long userOrderId){
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }

}