package app.impl;

import app.dao.StationDAO;
import app.model.Station;
import app.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private StationDAO stationDAO;

    public StationServiceImpl(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    public void add(Station station) {
        stationDAO.add(station);
    }

    public Station findById(Integer id) {
        return stationDAO.findById(id);
    }

    public List<Station> findAll() {
        return stationDAO.findAll();
    }

    public void update(Station station) {
        stationDAO.update(station);
    }

    public void deleteById(Integer id) {
        stationDAO.deleteById(id);
    }
}
