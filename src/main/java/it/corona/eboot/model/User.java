package it.corona.eboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import it.corona.eboot.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "telephone", nullable = false, length = 10)
    private String telephone;

    @Lob
    @Column(name = "status", insertable = false)
    @JsonSetter
    private String status;

    @Column(name = "verified", nullable = false)
    private Boolean verified;

    @Column(name = "newsletter", nullable = false)
    private Boolean newsletter;

    @Column(name = "creation_datetime", insertable = false)
    private LocalDateTime creationDatetime;

    @Column(name = "disabled_datetime")
    private LocalDateTime disabledDatetime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @JsonIgnore
    private List<Authority> authorities = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnore
    private List<Product> wishlist = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private List<CartItem> cartItems = new ArrayList<>();

    public void setStatus(UserStatus status){
        this.status = status.toString();
    }

    public void addNewAddress(Address address){
        address.setUser(this);
        this.addresses.add(address);
    }

    public void addNewOrder(Order order){
        order.setUser(this);
        this.orders.add(order);
    }

    public void addNewPaymentMethod(Payment payment){
        payment.setUser(this);
        this.payments.add(payment);
    }

    public void saveNewProduct(Product product){
        this.wishlist.add(product);
    }



}