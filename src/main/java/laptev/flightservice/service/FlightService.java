package laptev.flightservice.service;

import laptev.flightservice.model.City;
import laptev.flightservice.model.Plane;

import java.util.List;

public interface FlightService {
    void create(Plane plane);

    void create(City city);

    List<Plane> readPlanes();

    List<City> readCities();

    Plane readPlane(long plane_id);

    City readCity(long city_id);

    boolean update(Plane plane, long plane_id);

    boolean update(City city, long city_id);

    boolean deletePlane(long plane_id);

    boolean deleteCity(long city_id);
}
