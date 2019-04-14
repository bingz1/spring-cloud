package cloud.simple.springsecurity.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * @author xiangbingzhang
 * @date 2019-01-12
 **/
@Entity
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

}


