package it.corona.eboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.corona.eboot.enums.PaymentMethod;
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
@Table(name = "payment")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "bank", nullable = false, length = 45)
    private String bank;

    @Lob
    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "secret_code", nullable = false, length = 3)
    private String secretCode;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "creation_datetime", insertable = false)
    private LocalDateTime creationDatetime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public void setMethod(PaymentMethod method){
        this.method = method.toString();
    }

}