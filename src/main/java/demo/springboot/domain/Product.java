package demo.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;


@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
}
