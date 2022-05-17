package it.corona.eboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "`order`")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "creation_datetime", insertable = false)
    private LocalDateTime creationDatetime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", referencedColumnName="id", nullable = false)
    private List<Item> items = new ArrayList<>();

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shipping_id", nullable = false)
    private Shipping shippingMethod;



}