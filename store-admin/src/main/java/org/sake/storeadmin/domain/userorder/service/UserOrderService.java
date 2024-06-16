package org.sake.storeadmin.domain.userorder.service;

import lombok.RequiredArgsConstructor;
import org.sake.db.userorder.UserOrderEntity;
import org.sake.db.userorder.UserOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;

    public Optional<UserOrderEntity> getUserOrder(Long id){
        return userOrderRepository.findById(id);
    }
}