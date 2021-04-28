package app.service;

public interface RouteWithTrainStopPointsService {

    void addTrainStopPoint(Integer routeId, Integer trainStopPointId);

    void deleteTrainStopPoint(Integer routeId, Integer trainStopPointId);
}
