package app.impl;

import app.dao.RouteWithTrainStopPointsDAO;
import app.model.RouteWithTrainStopPoints;
import app.service.RouteWithTrainStopPointsService;
import org.springframework.stereotype.Service;

@Service
public class RouteWithTrainStopPointsServiceImpl implements RouteWithTrainStopPointsService {

    private RouteWithTrainStopPointsDAO routesWithTrainStopPointsDAO;

    public RouteWithTrainStopPointsServiceImpl(RouteWithTrainStopPointsDAO routesWithTrainStopPointsDAO) {
        this.routesWithTrainStopPointsDAO = routesWithTrainStopPointsDAO;
    }

    @Override
    public void addTrainStopPoint(Integer routeId, Integer trainStopPointId) {
        RouteWithTrainStopPoints routeWithTrainStopPoints = new RouteWithTrainStopPoints();
        routeWithTrainStopPoints.setRouteId(routeId);
        routeWithTrainStopPoints.setTrainStopPointId(trainStopPointId);
        routesWithTrainStopPointsDAO.add(routeWithTrainStopPoints);
    }

    @Override
    public void deleteTrainStopPoint(Integer routeId, Integer trainStopPointId) {
        routesWithTrainStopPointsDAO.delete(routeId, trainStopPointId);
    }
}
