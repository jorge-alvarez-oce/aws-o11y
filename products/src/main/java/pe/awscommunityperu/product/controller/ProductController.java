package pe.awscommunityperu.product.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.awscommunityperu.product.model.domain.Product;
import pe.awscommunityperu.product.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/products")
    public Flux<Product> findProductsByIds(@RequestParam("ids") String[] ids) {
        return productService.findByIds(List.of(ids))
                .doOnSubscribe(subscription -> log.debug("Products By Ids"));
    }

    @GetMapping(path = "/uuid")
    public Mono<String> uuid() {
        return Mono.just(UUID.randomUUID().toString());
    }
}
