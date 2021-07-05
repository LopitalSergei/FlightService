package laptev.flightservice.model;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @Column(name = "plane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plane_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "plane_class")
    private String plane_class;

    @Column(name = "number_of_seats")
    private int number_of_seats;

    public long getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(long plane_id) {
        this.plane_id = plane_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlane_class() {
        return plane_class;
    }

    public void setPlane_class(String plane_class) {
        this.plane_class = plane_class;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }
}
