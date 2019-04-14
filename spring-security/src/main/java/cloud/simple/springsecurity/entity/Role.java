package cloud.simple.springsecurity.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @author xiangbingzhang
 * @date 2019-01-12
 **/
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String role;
}
