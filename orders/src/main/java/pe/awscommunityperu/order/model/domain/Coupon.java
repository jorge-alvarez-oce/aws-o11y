package pe.awscommunityperu.order.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Coupon {

    private String code;
    private double factor;
}
