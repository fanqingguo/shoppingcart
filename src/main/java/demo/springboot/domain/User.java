package demo.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Data
@Entity
public class User {
    @Id //主键
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String address;
}
