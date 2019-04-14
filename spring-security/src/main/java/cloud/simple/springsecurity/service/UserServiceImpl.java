package cloud.simple.springsecurity.service;

import cloud.simple.springsecurity.entity.User;
import cloud.simple.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xiangbingzhang
 * @date 2019-01-13
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

}