package app.contoller;


import app.model.TrainStopPoint;
import app.service.TrainStopPointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainStopPointController {

    private TrainStopPointService trainStopPointService;

    public TrainStopPointController(TrainStopPointService trainStopPointService) {
        this.trainStopPointService = trainStopPointService;
    }

    @PostMapping("/points")
    public void add(@RequestBody TrainStopPoint trainStopPointMonthInfo) {
        trainStopPointService.add(trainStopPointMonthInfo);
    }

    @GetMapping("/points/{id}")
    public TrainStopPoint getTrainStopPointById(@PathVariable("id") Integer id) {
        return trainStopPointService.findById(id);
    }

    @GetMapping("/points")
    public List<TrainStopPoint> getTrainStopPoints() {
        return trainStopPointService.findAll();
    }

    @PutMapping("/points")
    public void update(@RequestBody TrainStopPoint trainStopPoint) {
        trainStopPointService.update(trainStopPoint);
    }

    @DeleteMapping("/points/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        trainStopPointService.deleteById(id);
    }
}
