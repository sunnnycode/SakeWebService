package org.sake.api.domain.userorder.producer;

import lombok.RequiredArgsConstructor;
import org.sake.api.common.rabbitmq.Producer;
import org.sake.common.message.model.UserOrderMessage;
import org.sake.db.userorder.UserOrderEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserOrderProducer {

    private final Producer producer;

    private static final String EXCHANGE = "sake.exchange";
    private static final String ROUTE_KEY = "sake.key";

    public void sendOrder(UserOrderEntity userOrderEntity){
        sendOrder(userOrderEntity.getId());
    }

    public void sendOrder(Long userOrderId){
        var message = UserOrderMessage.builder()
                .userOrderId(userOrderId)
                .build();

        producer.producer(EXCHANGE, ROUTE_KEY, message);
        System.out.println("fgdgd");
    }
}