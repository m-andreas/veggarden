package com.markus.veggarden.model.plot;

import com.markus.veggarden.model.construction.*;

// Plot Objects are basicly Vegtable Patches with a given size
public class Plot {
    private Space[][] plotSpaces;

    public Plot(int length, int witdh) {
        // 3 Plants are allowed per Space
        plotSpaces = new Space[length][witdh];
    }

    public boolean place(Space objectToPlace){
        for (int i = 0; i <= plotSpaces.length; i++) {
            for (int j = 0; j <= plotSpaces[j].length; j++) {
                if (plotSpaces[i][j] == null) {
                    return placeAtSpot(objectToPlace, i, j);
                }
            }
        }
        return false;
    }

    public boolean place(Space objectToPlace, int positionX, int positionY){
        return placeAtSpot(objectToPlace, positionX, positionY);
    }

    public Space[][] getSpaces(){
        return plotSpaces;
    }

    @Override
    public String toString() {
        String plot_image = "";
        Space neighbour = null;
        for (int i = 0; i < plotSpaces.length; i++) {
            for (int y = 0; y < plotSpaces[i].length; y++) {
                Space singleSpace = plotSpaces[i][y];
                if (singleSpace != null) {
                    plot_image += singleSpace.getName() + " => " + singleSpace.getNeighbourRank() + " | ";
                } else {
                    plot_image += "LEER | ";
                }
            }
        }
        return plot_image;
    }

    private boolean placeAtSpot(Space objectToPlace, int positionX, int positionY){
        plotSpaces[positionX][positionY] = objectToPlace;
        return true;
    }
}
