package com.example.thiago.gridMap.repository;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.Map;

import static java.util.Arrays.asList;
import com.example.thiago.gridMap.domain.Map;

public class MapRepository {

    public static List<Map> maps = asList(
            new Map(3, "BOOROORRE"),
            new Map(2, "BOOROORRE"),
            new Map(4, "BOOROORRE"));

    public Map get(int mapId) {
        Map teste = null;
        for(int i=0; i<maps.size(); i++) {
            teste = maps.get(i);
            return teste;
        }
        return teste;
    }



    public List<Map> getAll() {
        return maps.stream().collect(Collectors.toList());
    }
}
