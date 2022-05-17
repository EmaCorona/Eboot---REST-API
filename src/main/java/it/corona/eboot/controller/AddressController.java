package it.corona.eboot.controller;

import it.corona.eboot.model.Address;
import it.corona.eboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;


   // Aggiunta indirizzo per utente (Da rifare con Spring Security)
    @PostMapping("/user/{userId}/save-address")
    public Address save(@PathVariable Integer userId, @RequestBody Address address){
        return  addressService.save(userId,address);
    }

    // Lista di Indirizzi in base all'ID dell'utente
    @GetMapping("user-addresses/{id}")
    public List<Address> findByUserId(@PathVariable Integer id){
        return addressService.findByUserId(id);
    }

}
