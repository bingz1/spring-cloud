package cloud.simple.springsecurity.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author xiangbingzhang
 * @date 2019-01-13
 **/
@Entity
@Data
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 映射为字段，值不能为空
     */
    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
