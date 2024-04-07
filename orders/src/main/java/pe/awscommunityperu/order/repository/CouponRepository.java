package pe.awscommunityperu.order.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import pe.awscommunityperu.order.model.domain.Coupon;
import reactor.core.publisher.Mono;

@Repository
public class CouponRepository {

    public Mono<Coupon> redeemCoupons(String code) {
        return WebClient.create("http://localhost:8080").post()
                .uri("/coupons/{couponCode}/redeem", code)
                .retrieve()
                .bodyToMono(Coupon.class);
    }
}
