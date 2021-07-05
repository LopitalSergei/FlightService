package laptev.flightservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long city_id;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "country")
    private String country;

    @Column(name = "count_of_people")
    private int count_of_people;

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCount_of_people() {
        return count_of_people;
    }

    public void setCount_of_people(int count_of_people) {
        this.count_of_people = count_of_people;
    }
}
