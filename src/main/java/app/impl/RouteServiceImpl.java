package app.impl;

import app.dao.RouteDAO;
import app.model.Route;
import app.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteDAO routeDAO;

    public RouteServiceImpl(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    public void add(Route route) {
        routeDAO.add(route);
    }

    public Route findById(Integer id) {
        return routeDAO.findById(id);
    }

    public List<Route> findAll() {
        return routeDAO.findAll();
    }

    public void update(Route route) {
        routeDAO.update(route);
    }

    public void deleteById(Integer id) {
        routeDAO.deleteById(id);
    }
}
