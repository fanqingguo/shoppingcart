package demo.springboot.service.impl;

import demo.springboot.domain.User;
import demo.springboot.domain.UserRepository;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insertByUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> findByUsers(User user) {
        List<User> all = userRepository.findAll(Example.of(user));
        return all;
    }
}
