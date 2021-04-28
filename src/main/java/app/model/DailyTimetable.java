package app.model;

import lombok.Data;

import java.util.List;

@Data
public class DailyTimetable {

    private List<Route> routeList;
}
