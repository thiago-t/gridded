package com.example.thiago.gridMap.domain;

public class Map {
    public int mapId;
    public String mapCoord;

    public Map(int mapId, String mapCoord) {
        this.mapId = mapId;
        this.mapCoord = mapCoord;
    }

    public int getMapId() { return mapId; }

    public String getMapCoord() { return mapCoord; }

}
