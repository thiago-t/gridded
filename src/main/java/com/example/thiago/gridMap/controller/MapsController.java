package com.example.thiago.gridMap.controller;

import com.example.thiago.gridMap.domain.Map;
import com.example.thiago.gridMap.service.MapService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/grid")
public class MapsController {

    public final MapService service = new MapService();

    @GetMapping("/{mapId}") // list map info by mapId
    public ResponseEntity<Map>get(@PathVariable int mapId) {
        Map map = service.get(mapId);

        if(map == null) {
            return notFound().build();
        }

        return ok(map);
    }

    @GetMapping
    public List<Map> listMaps() {
        List<Map> listMaps = new ArrayList<>();

        for (var map : service.getAll()) {
            listMaps.add(map);
        }
        return listMaps;
    }

    @PostMapping
    public ArrayList<ArrayList<Character>> newMap(@RequestParam("stringMap") String stringMap) {
        /*ArrayList<ArrayList<Character>> mapListA = new ArrayList<>();
        double sqrt = Math.sqrt(stringMap.length());

        for(int i=0; i<sqrt; i++) {
            ArrayList<Character> mapListB = new ArrayList<>();
            for(int k=0; k<sqrt; k++) {
                mapListB.add(stringMap.charAt((int)sqrt*i+k));
            }
            mapListA.add(mapListB);
        }
        return mapListA;*/
        return service.createMap(stringMap);
    }
}
