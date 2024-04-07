package pe.awscommunityperu.product.model.infrastructure;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class ProductInfo {

    public static String TABLE_NAME = "Product";

    @Getter(onMethod_=@DynamoDbPartitionKey)
    private String id;
    private String name;
    private double price;

}
