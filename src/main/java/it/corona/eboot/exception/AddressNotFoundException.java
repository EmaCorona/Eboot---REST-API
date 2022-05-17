package it.corona.eboot.exception;


public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(String message){
        super(message);
    }

    public AddressNotFoundException(){
        super();
    }

}
