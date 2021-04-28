package app.impl;

import app.dao.TrainStopPointDAO;
import app.model.TrainStopPoint;
import app.service.TrainStopPointService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStopPointServiceImpl implements TrainStopPointService {

    private TrainStopPointDAO trainStopPointDAO;

    public TrainStopPointServiceImpl(TrainStopPointDAO trainStopPointDAO) {
        this.trainStopPointDAO = trainStopPointDAO;
    }

    public void add(TrainStopPoint trainStopPoint) {
        trainStopPointDAO.add(trainStopPoint);
    }

    public TrainStopPoint findById(Integer id) {
        return trainStopPointDAO.findById(id);
    }

    public List<TrainStopPoint> findAll() {
        return trainStopPointDAO.findAll();
    }

    public void update(TrainStopPoint trainStopPoint) {
        trainStopPointDAO.update(trainStopPoint);
    }

    public void deleteById(Integer id) {
        trainStopPointDAO.deleteById(id);
    }
}
