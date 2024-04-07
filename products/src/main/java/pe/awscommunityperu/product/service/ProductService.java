package pe.awscommunityperu.product.service;

import pe.awscommunityperu.product.model.domain.Product;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ProductService {

    Flux<Product> findByIds(List<String> ids);
}
