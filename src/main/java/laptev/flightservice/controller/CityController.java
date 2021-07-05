package laptev.flightservice.controller;

import laptev.flightservice.model.City;
import laptev.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    private FlightService flightService;

    @Autowired
    public CityController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping(value = "/cities")
    public ResponseEntity<?> create(@RequestBody City city) {
        flightService.create(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/cities")
    public ResponseEntity<List<City>> read() {
        final List<City> cities = flightService.readCities();

        return cities != null && !cities.isEmpty()
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/cities/{id}")
    public ResponseEntity<City> read(@PathVariable(name = "id") long city_id) {
        final City city = flightService.readCity(city_id);

        return city != null
                ? new ResponseEntity<>(city, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/cities/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long city_id, @RequestBody City city) {
        final boolean updated = flightService.update(city, city_id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long city_id) {
        final boolean deleted = flightService.deleteCity(city_id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
