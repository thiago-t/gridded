package com.example.thiago.gridMap.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MapTest {

    @Test
    public void map_ShoulFail_WhenLessThanFour() {
        String coord = "ABC";
        Map undertest = new Map(5, coord);

        boolean result = undertest.less(coord);

        assertFalse(result);
    }
}
