package it.corona.eboot.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "size")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Lob
    @Column(name = "value")
    private String value;

    @Column(name = "availability", nullable = false)
    private Integer availability;

}