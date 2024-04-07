package pe.awscommunityperu.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.awscommunityperu.product.model.domain.Product;
import pe.awscommunityperu.product.repository.ProductRepository;
import pe.awscommunityperu.product.service.ProductService;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Flux<Product> findByIds(List<String> ids) {
        return productRepository.findByIds(ids)
                .map(productInfo -> new Product(productInfo.getId(),productInfo.getName(),productInfo.getPrice()));
    }
}
