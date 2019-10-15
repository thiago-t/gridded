package com.example.thiago.gridMap.service;

import com.example.thiago.gridMap.domain.Map;
import com.example.thiago.gridMap.repository.MapRepository;

import java.util.ArrayList;
import java.util.List;

public class MapService {
    public MapRepository repository = new MapRepository();

    public Map get(int mapId) {
        Map map = repository.get(mapId);
        return map;
    }

    public List<Map> getAll() {
        return repository.getAll();
    }

    public ArrayList<ArrayList<Character>> createMap(String stringMap) {
        ArrayList<ArrayList<Character>> mapListA = new ArrayList<>();
        double sqrt = Math.sqrt(stringMap.length());

        for(int i=0; i<sqrt; i++) {
            ArrayList<Character> mapListB = new ArrayList<>();
            for(int k=0; k<sqrt; k++) {
                mapListB.add(stringMap.charAt((int)sqrt*i+k));
            }
            mapListA.add(mapListB);
        }
        return mapListA;
    }

}
