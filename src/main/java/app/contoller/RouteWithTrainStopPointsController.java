package app.contoller;

import app.service.RouteWithTrainStopPointsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RouteWithTrainStopPointsController {

    private RouteWithTrainStopPointsService routeWithTrainStopPoints;

    public RouteWithTrainStopPointsController(RouteWithTrainStopPointsService routeWithTrainStopPoints) {
        this.routeWithTrainStopPoints = routeWithTrainStopPoints;
    }

    @PostMapping("/add/{route_id}/{stop_point_id}")
    public void addFile(@PathVariable("route_id") Integer routeId, @PathVariable("stop_point_id") Integer stopPointId) {
        routeWithTrainStopPoints.addTrainStopPoint(routeId, stopPointId);
    }

    @DeleteMapping("/delete/{route_id}/{stop_point_id}")
    public void deleteFile(@PathVariable("route_id") Integer routeId, @PathVariable("stop_point_id") Integer stopPointId) {
        routeWithTrainStopPoints.deleteTrainStopPoint(routeId, stopPointId);
    }
}
