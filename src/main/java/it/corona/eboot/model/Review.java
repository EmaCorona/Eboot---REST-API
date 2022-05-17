package it.corona.eboot.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "review")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "creation_datetime", insertable = false)
    @JsonIgnore
    private LocalDateTime creationDatetime;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @JsonGetter(value = "product_name")
    public String getProductName(){
        return this.product.getName();
    }

    @JsonGetter(value = "user")
    public String getUsername(){
        return this.user.getUsername();
    }

}