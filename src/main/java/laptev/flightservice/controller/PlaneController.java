package laptev.flightservice.controller;

import laptev.flightservice.model.Plane;
import laptev.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {

    private FlightService flightService;

    @Autowired
    public PlaneController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping(value = "/planes")
    public ResponseEntity<?> create(@RequestBody Plane plane) {
        flightService.create(plane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/planes")
    public ResponseEntity<List<Plane>> read() {
        final List<Plane> planes = flightService.readPlanes();

        return planes != null && !planes.isEmpty()
                ? new ResponseEntity<>(planes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/planes/{id}")
    public ResponseEntity<Plane> read(@PathVariable(name = "id") long plane_id) {
        final Plane plane = flightService.readPlane(plane_id);

        return plane != null
                ? new ResponseEntity<>(plane, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/planes/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long plane_id, @RequestBody Plane plane) {
        final boolean updated = flightService.update(plane, plane_id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/planes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long plane_id) {
        final boolean deleted = flightService.deletePlane(plane_id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
