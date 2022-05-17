package it.corona.eboot.service;

import it.corona.eboot.enums.GenericStatus;
import it.corona.eboot.exception.AddressNotFoundException;
import it.corona.eboot.model.Address;
import it.corona.eboot.model.User;
import it.corona.eboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    public List<Address> findByUserId(Integer userId){
        return addressRepository.findByUserId(userId);
    }

    public Address save(Integer id,Address address){
        User user = userService.findById(id);
        address.setStatus(GenericStatus.ACTIVE);
        user.addNewAddress(address);
        addressRepository.save(address);
        userService.save(user);
        return address;
    }

    public Address findById(Integer id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            return address.get();
        }else throw new AddressNotFoundException("Address not found");
    }

}
