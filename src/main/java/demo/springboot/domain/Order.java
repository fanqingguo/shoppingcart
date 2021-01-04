package demo.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String orderId;
    private Long userId;
}
