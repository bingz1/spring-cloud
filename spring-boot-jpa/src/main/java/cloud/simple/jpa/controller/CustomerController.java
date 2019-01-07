package cloud.simple.jpa.controller;

import cloud.simple.jpa.dto.Customer;
import cloud.simple.jpa.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author xiangbingzhang
 * @data 2019-01-07
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/index")
    public String index() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        repository.save(new Customer("Bauer", "Dessler"));
        return "success";
    }

    @GetMapping("/findAll")
    public List<Customer> findAll() {
        List<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("*************************");
        return customers;
    }

    @GetMapping("findOne")
    public Customer findOne() {
        Customer customer = new Customer();
        customer.setId(1L);

        Example<Customer> example = Example.of(customer);

        Optional<Customer> result = repository.findOne(example);
        customer = result.get();
        if (result != null) {
            System.out.println(result.toString());
        }
        System.out.println("-------------------------------------------");
        return customer;
    }

    @GetMapping("delete")
    public boolean delete(){
        Customer customer = new Customer();
        customer.setId(1L);
        repository.delete(customer);
        return true;
    }
}
