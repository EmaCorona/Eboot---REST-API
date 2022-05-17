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
@Table(name = "material")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "external_material", length = 45)
    private String externalMaterial;

    @Column(name = "external_value")
    private Integer externalValue;

    @Column(name = "lining_material", length = 45)
    private String liningMaterial;

    @Column(name = "lining_value")
    private Integer liningValue;

    @Column(name = "sole_material", length = 45)
    private String soleMaterial;

    @Column(name = "sole_value")
    private Integer soleValue;

    @Column(name = "style_material", length = 45)
    private String styleMaterial;

    @Column(name = "style_value")
    private Integer styleValue;

}