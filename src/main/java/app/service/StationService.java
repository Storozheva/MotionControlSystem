package app.service;


import app.model.Station;

import java.util.List;

public interface StationService {

    void add(Station station);

    Station findById(Integer id);

    List<Station> findAll();

    void update(Station station);

    void deleteById(Integer id);
}
