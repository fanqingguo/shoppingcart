package demo.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;



@Entity  //定义对象将会成为被JPA管理的实体，将映射到指定的数据库表
@Data
public class Cart implements Serializable {
    @Id     //用于声明一个实体类的属性映射为数据库的主键列
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long prodcutId;
    private Long num;
    private BigDecimal price;
    private String productName;



}
