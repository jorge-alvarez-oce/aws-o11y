package pe.awscommunityperu.order.service;

import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Void> performOrder();
}
