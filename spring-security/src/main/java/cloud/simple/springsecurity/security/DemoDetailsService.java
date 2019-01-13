package cloud.simple.springsecurity.security;

import cloud.simple.springsecurity.entity.User;
import cloud.simple.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xiangbingzhang
 * @date 2019-01-12
 **/
@Service
public class DemoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("********name******" + name);
        User user = userRepository.findByUsername(name);
        return user;
    }
}
