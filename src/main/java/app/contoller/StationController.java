package app.contoller;


import app.model.Station;
import app.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController {

    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/stations")
    public void add(@RequestBody Station stationMonthInfo) {
        stationService.add(stationMonthInfo);
    }

    @GetMapping("/stations/{id}")
    public Station getStationById(@PathVariable("id") Integer id) {
        return stationService.findById(id);
    }

    @GetMapping("/stations")
    public List<Station> getStations() {
        return stationService.findAll();
    }

    @PutMapping("/stations")
    public void update(@RequestBody Station station) {
        stationService.update(station);
    }

    @DeleteMapping("/stations/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        stationService.deleteById(id);
    }
}
