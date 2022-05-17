package it.corona.eboot.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import it.corona.eboot.enums.ShippingMethod;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "shipping_method")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "creation_datetime", insertable = false)
    private LocalDateTime creationDatetime;

    public void setName(ShippingMethod shippingMethod){
        this.name = shippingMethod.toString();
    }

}