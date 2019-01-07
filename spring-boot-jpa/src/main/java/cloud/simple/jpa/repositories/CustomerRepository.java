package cloud.simple.jpa.repositories;

import cloud.simple.jpa.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiangbingzhang
 * @data 2019-01-07
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
