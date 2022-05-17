package it.corona.eboot.controller;

import it.corona.eboot.model.User;
import it.corona.eboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    // Lista di tutti gli utenti
    @GetMapping("/all-users")
    public List<User> getUsersList(){
        return userService.findAll();
    }


    // Lista di tutti gli utenti attivi
    @GetMapping("/users")
    public List<User> findActiveUsers(){
        return userService.findActiveUsers();
    }


    // Ricerca utente per id
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }


    // Aggiornamento utente
    @PutMapping("/user/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }


    // Eliminazione utente (Stato impostato su Deleted)
    @PutMapping("/user/delete/{id}")
    public User delete(@PathVariable Integer id){
        return userService.delete(id);
    }


    // Abilitazione utente (Stato impostato su Active)
    @PutMapping("/user/reactivate/{id}")
    public User reactivateUser(@PathVariable Integer id){
        return userService.reactivateUser(id);
    }


    // Lista di utenti che hanno fatto un ordine superiore al valore specificato
    @GetMapping("/users/order-greater-than/{amount}")
    public List<User> findByOrderGreaterThan(@PathVariable Double amount){
        return userService.findByOrdersGreaterThan(amount);
    }

}
