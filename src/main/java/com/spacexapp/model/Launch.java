package com.spacexapp.model;

import java.util.Map;

public class Launch {
    private final String missionName;
    private final int launchYear;
    private final Map<String, String> links;

    public Launch(int launchYear, String missionName, Map<String, String> links) {
        this.launchYear = launchYear;
        this.missionName = missionName;
        this.links = links;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public String getMissionName() {
        return missionName;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Launch{" +
                "missionName='" + missionName + '\'' +
                ", launchYear=" + launchYear +
                ", links=" + links +
                '}';
    }
}
