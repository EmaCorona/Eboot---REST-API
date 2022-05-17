package it.corona.eboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import it.corona.eboot.enums.ProductStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @Lob
    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "model_height")
    private Double modelHeight;

    @Column(name = "model_size", length = 45)
    private String modelSize;

    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "ref", length = 10)
    private String ref;

    @Column(name = "creation_datetime", insertable = false, length = 45)
    private String creationDatetime;

    @ManyToMany
    @JoinTable(name = "product_care_istructions",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "care_istruction_id"))
    @JsonIgnore
    private List<CareIstruction> careIstructions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonIgnore
    private List<Size> sizes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private List<Material> materials = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public void setStatus(ProductStatus status){
       this.status = status.toString();
    }


}