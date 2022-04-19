package egg.edu.spring.service;

import egg.edu.spring.entity.User;
import egg.edu.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void create(User userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        userRepository.save(user);
    }

    @Transactional
    public void update(User userDTO) {
        User user = userRepository.findById(userDTO.getUsername()).get();


        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(String username) {

        return userRepository.findById(username).get();
    }

    @Transactional
    public void deleteById(String username) {
        userRepository.deleteById(username);
    }
}
