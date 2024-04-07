package pe.awscommunityperu.product.repository;

import org.springframework.stereotype.Repository;
import pe.awscommunityperu.product.model.infrastructure.ProductInfo;
import reactor.core.publisher.Flux;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Repository
public class ProductRepository {

    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;
    private final DynamoDbAsyncTable<ProductInfo> customerDynamoDbAsyncTable;

    public ProductRepository(DynamoDbEnhancedAsyncClient asyncClient) {
        this.enhancedAsyncClient = asyncClient;
        this.customerDynamoDbAsyncTable = asyncClient.table(ProductInfo.TABLE_NAME, TableSchema.fromBean(ProductInfo.class));
    }

    public Flux<ProductInfo> findByIds(List<String> ids){
        return Flux.from(customerDynamoDbAsyncTable.scan()
                .items());
    }
}
