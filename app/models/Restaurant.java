package models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Entity
@Table(name="restaurants")
    public class Restaurant {
    @Id
    @SequenceGenerator(name="restaurantSeq", sequenceName="sq_restaurant", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="restaurantSeq")
    @Column(name = "ID", nullable = false)
    private Long id;

    private String restaurantName;
    @Column(name = "description")
    private String description;
    @Column(name = "reviewrating")
    private Double reviewrating;
    @Column(name = "reviewcount")
    private Integer reviewcount;
    @Column(name = "activemenu")
    private Integer activemenu;
    @Column(name = "logoimageurl")
    private String logoimageurl;
    @Column(name = "coverimageurl")
    private String coverimageurl;
    @Column(name = "pricing")
    private Integer pricing;
    @Column(name = "workingtimefrom")
    private Timestamp workingtimefrom;
    @Column(name = "workingtimeto")
    private Timestamp workingtimeto;
    @Column(name = "minimumcanceltime")
    private Timestamp minimumcanceltime;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "restaurantName", nullable = true, precision = 0)
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String name) {
        this.restaurantName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReviewrating() {
        return reviewrating;
    }

    public void setReviewrating(Double reviewrating) {
        this.reviewrating = reviewrating;
    }

    public Integer getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(Integer reviewcount) {
        this.reviewcount = reviewcount;
    }

    public Integer getActivemenu() {
        return activemenu;
    }

    public void setActivemenu(Integer activemenu) {
        this.activemenu = activemenu;
    }


    public String getLogoimageurl() {
        return logoimageurl;
    }

    public void setLogoimageurl(String logoimageurl) {
        this.logoimageurl = logoimageurl;
    }

    public String getCoverimageurl() {
        return coverimageurl;
    }

    public void setCoverimageurl(String coverimageurl) {
        this.coverimageurl = coverimageurl;
    }

    public Integer getPricing() {
        return pricing;
    }

    public void setPricing(Integer pricing) {
        this.pricing = pricing;
    }

    public Timestamp getWorkingtimefrom() {
        return workingtimefrom;
    }

    public void setWorkingtimefrom(Timestamp workingtimefrom) {
        this.workingtimefrom = workingtimefrom;
    }

    public Timestamp getWorkingtimeto() {
        return workingtimeto;
    }

    public void setWorkingtimeto(Timestamp workingtimeto) {
        this.workingtimeto = workingtimeto;
    }


    public Timestamp getMinimumcanceltime() {
        return minimumcanceltime;
    }

    public void setMinimumcanceltime(Timestamp minimumcanceltime) {
        this.minimumcanceltime = minimumcanceltime;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


}