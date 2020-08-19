package com.markus.veggarden.model.construction;

// Space Objects can be either Plants or Paths
public interface Space {
    String getName();
    String[] getTodaysTasks();
    int getNeighbourRank();
}
