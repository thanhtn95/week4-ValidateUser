package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import user.model.User;
import user.repository.UserRepository;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
