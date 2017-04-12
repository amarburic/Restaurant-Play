package models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @SequenceGenerator(name="locationSeq", sequenceName="sq_location", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="locationSeq")
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Location() {

    }

    public Location(String name) {
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
