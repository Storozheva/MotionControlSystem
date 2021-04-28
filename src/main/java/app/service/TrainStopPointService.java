package app.service;


import app.model.TrainStopPoint;

import java.util.List;

public interface TrainStopPointService {

    void add(TrainStopPoint trainStopPoint);

    TrainStopPoint findById(Integer id);

    List<TrainStopPoint> findAll();

    void update(TrainStopPoint trainStopPoint);

    void deleteById(Integer id);
}
