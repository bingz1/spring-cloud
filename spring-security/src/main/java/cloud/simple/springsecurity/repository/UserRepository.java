package cloud.simple.springsecurity.repository;

import cloud.simple.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiangbingzhang
 * @date 2019-01-13
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
