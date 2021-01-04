package demo.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author LiuYingJie
 * @version 1.0
 * @date 2020/11/1
 **/
@Data
@Entity(name = "order_item")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String orderId;
    private Long num;
    private BigDecimal price;
    private BigDecimal sumPrice;
    private String productName;
}
