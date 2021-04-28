package app.service;


import app.model.Route;

import java.util.List;

public interface RouteService {

    void add(Route route);

    Route findById(Integer id);

    List<Route> findAll();

    void update(Route route);

    void deleteById(Integer id);
}
