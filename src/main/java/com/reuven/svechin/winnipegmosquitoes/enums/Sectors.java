package com.reuven.svechin.winnipegmosquitoes.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The class represents an emam of city sectors
 */
public enum Sectors {
    NORTH_WEST,
    NORTH_EAST,
    SOUTH_WEST,
    SOUTH_EAST,
    RURAL;
    private static final List<Sectors> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Sectors randomSector()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
