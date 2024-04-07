package pe.awscommunityperu.order.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import pe.awscommunityperu.order.model.domain.Product;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public class ProductRepository {

    public Flux<Product> findByIds(List<String> ids){
        return WebClient.create("http://localhost:9090").get()
                .uri(builder -> builder.path("/products")
                        .queryParam("ids", ids)
                        .build())
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
