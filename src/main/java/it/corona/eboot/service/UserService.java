package it.corona.eboot.service;

import it.corona.eboot.enums.UserStatus;
import it.corona.eboot.exception.UserNotFoundException;
import it.corona.eboot.model.User;
import it.corona.eboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> findAll(){
       return userRepository.findAll();
    }

    public List<User> findActiveUsers(){
        return userRepository.findByStatus();
    }

    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else throw new UserNotFoundException("User not found");
    }

    public List<User> findByOrdersGreaterThan(Double amount){
        return userRepository.findByOrdersGreaterThan(amount);
    }

    public User update(@RequestBody User requestUser){
        User responseUser = findById(requestUser.getId());
        if(requestUser.getUsername() != null){
            responseUser.setUsername(requestUser.getUsername());
        }
        if (requestUser.getEmail() != null){
            responseUser.setEmail(requestUser.getEmail());
        }
        if(requestUser.getPassword() != null){
            responseUser.setPassword(requestUser.getPassword());
        }
        if(requestUser.getTelephone() != null){
            responseUser.setTelephone(requestUser.getTelephone());
        }
        if(requestUser.getNewsletter() != null){
            responseUser.setNewsletter(requestUser.getNewsletter());
        }
        return userRepository.save(responseUser);
    }

    public User delete(Integer id){
        User user = findById(id);
        user.setStatus(UserStatus.DELETED);
        return save(user);
    }



    public User reactivateUser(Integer id){
        User user = findById(id);
        user.setStatus(UserStatus.ACTIVE);
        return save(user);
    }


}
