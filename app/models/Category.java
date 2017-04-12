package models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @SequenceGenerator(name="categorySeq", sequenceName="sq_category", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categorySeq")
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
