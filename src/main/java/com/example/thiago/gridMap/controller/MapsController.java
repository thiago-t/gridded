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
    public ResponseEntity<Map> get(@PathVariable int mapId) {
        Map map = service.get(mapId);

        if (map == null) {
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
    public ResponseEntity newMap(@RequestParam("stringMap") String stringMap) {

        if (!service.isSquare(stringMap)) {
            return ResponseEntity.badRequest().body("It must be a square");
        }
        return ok(service.createMap(stringMap));
    }
}