package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.User;
import source.repository.UserRepository;
import source.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
userRepository.delete(id);
    }

    @Override
    public Iterable<User> findAllByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
