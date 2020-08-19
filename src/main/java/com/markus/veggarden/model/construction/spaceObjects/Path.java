package com.markus.veggarden.model.construction.spaceObjects;

import com.markus.veggarden.model.construction.*;
// Paths to walk trough the Vegtable Garden
public class Path implements Space {
    @Override
    public String getName() {
        return "Path";
    }

    @Override
    public String[] getTodaysTasks() {
        return new String[0];
    }

    @Override
    public int getNeighbourRank() {
        return 0;
    }
}
