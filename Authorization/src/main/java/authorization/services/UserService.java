package authorization.services;

import authorization.models.User;
import authorization.repos.UserRepo;
import authorization.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo userRepository;

    @Autowired
    private final SecurityUtils passwordEncoder;


    public boolean createUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public void saveUser(User user){
        userRepository.save(user);}

    public List<User> getAllUsers(){
        return userRepository.findAll();}

    public User findByUsername(String username){
        return userRepository.findByUsername(username);}


    public User findByID(Long id) {
        return userRepository.findByID(id);
    }

    public List<User> findByIds(Set<Long> ids) {
        List<User> toReturn = new ArrayList<>();
        for (Long id: ids) {
            toReturn.add(userRepository.findByID(id));
        }
        return toReturn;
    }
}
