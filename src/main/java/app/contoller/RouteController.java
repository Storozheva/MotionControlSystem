package app.contoller;


import app.model.Route;
import app.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/routes")
    public void add(@RequestBody Route routeMonthInfo) {
        routeService.add(routeMonthInfo);
    }

    @GetMapping("/routes/{id}")
    public Route getRouteById(@PathVariable("id") Integer id) {
        return routeService.findById(id);
    }

    @GetMapping("/routes")
    public List<Route> getRoutes() {
        return routeService.findAll();
    }

    @PutMapping("/routes")
    public void update(@RequestBody Route route) {
        routeService.update(route);
    }

    @DeleteMapping("/routes/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        routeService.deleteById(id);
    }
}
