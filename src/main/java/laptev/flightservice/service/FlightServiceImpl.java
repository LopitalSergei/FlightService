package laptev.flightservice.service;

import laptev.flightservice.model.City;
import laptev.flightservice.model.Plane;
import laptev.flightservice.repository.CityRepository;
import laptev.flightservice.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void create(Plane plane) {
        planeRepository.save(plane);
    }

    @Override
    public void create(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<Plane> readPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public List<City> readCities() {
        return cityRepository.findAll();
    }

    @Override
    public Plane readPlane(long plane_id) {
        return planeRepository.getById(plane_id);
    }

    @Override
    public City readCity(long city_id) {
        return cityRepository.getById(city_id);
    }

    @Override
    public boolean update(Plane plane, long plane_id) {
        if (planeRepository.existsById(plane_id)) {
            plane.setPlane_id(plane_id);
            planeRepository.save(plane);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(City city, long city_id) {
        if (cityRepository.existsById(city_id)) {
            city.setCity_id(city_id);
            cityRepository.save(city);
        }
        return false;
    }

    @Override
    public boolean deletePlane(long plane_id) {
        if (planeRepository.existsById(plane_id)) {
            planeRepository.deleteById(plane_id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCity(long city_id) {
        if (cityRepository.existsById(city_id)) {
            cityRepository.deleteById(city_id);
        }
        return false;
    }
}
