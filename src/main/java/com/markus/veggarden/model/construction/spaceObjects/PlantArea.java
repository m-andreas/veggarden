package com.markus.veggarden.model.construction.spaceObjects;

import com.markus.veggarden.model.construction.*;
import com.markus.veggarden.model.plant.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Every Plant Area can include multible Plants => See Intercropping
public class PlantArea implements Space {
    private ArrayList<Plant> plants;
    private int nutrition_demand;

    public PlantArea(){
        plants = new ArrayList<>();
        nutrition_demand = Plant.HIGH_DEMAND;
    }

    public boolean add_plant(Plant plantToAdd){
        if(plants.contains(plantToAdd)){
            return false;
        }
        plants.add(plantToAdd);
        return true;
    }

    // Removes all Elements with the Same name as the one passed by parameter
    public boolean removePlant(Plant plantToRemove){
        if(!plants.contains(plantToRemove)){
            return false;
        }
        plants.remove(plantToRemove);
        return true;
    }

    public ArrayList<ArrayList<Plant>> getNotAllowedPlantPairs(){
        ArrayList<ArrayList<Plant>> notAllowedPlantPairs = new ArrayList<>();
        for (Plant plant:plants) {
            notAllowedPlantPairs.add(getNotAllowedPlantsForSingle(plant));
        }
        return notAllowedPlantPairs;
    }

    private ArrayList<Plant> getNotAllowedPlantsForSingle(Plant plantToCheck){
        ArrayList notAllowedPlants = new ArrayList();
        for (Plant singlePlant:plants) {
            if(singlePlant == plantToCheck) continue;
            if(singlePlant.getNeighbourRank(plantToCheck) == Plant.NOT_ALLOWED){
                notAllowedPlants.add(plantToCheck);
            }
        }
        return notAllowedPlants;
    }

    @Override
    public String getName() {
        return "PlantArea";
    }

    @Override
    public String[] getTodaysTasks() {
        return new String[0];
    }

    public int getNextYearsNutritionRecommendation(){
        int next_years_nutrition_recommendation = nutrition_demand - 1;
        if(next_years_nutrition_recommendation < Plant.GREEN_MANURING){
            next_years_nutrition_recommendation = Plant.HIGH_DEMAND;
        }
        return next_years_nutrition_recommendation;
    }

    public int getNeighbourRank() {
        // No Neighbours, no Rank
        if(plants.size()==1) return Plant.NEUTRAL;

        int rank = Plant.NEUTRAL;

        for(Plant plant:plants) {
            float single_rank = check_neighbours_for_single_plant(plant);
            if(single_rank == Plant.NOT_ALLOWED){
                return Plant.NOT_ALLOWED;
            }
        }
        return rank/plants.size() - 1;
    }

    private float check_neighbours_for_single_plant(Plant plantToCheck){
        // No Neighbours, no Rank
        if(plants.size()==1) return Plant.NEUTRAL;

        int rank = Plant.NEUTRAL;

        for(Plant plant:plants) {
            if(plant == plantToCheck) continue;

            int singleRank = plantToCheck.getNeighbourRank(plant);
            if(singleRank == Plant.NOT_ALLOWED){
                return Plant.NOT_ALLOWED;
            }else{
                rank += singleRank;
            }
        }
        return rank/plants.size() - 1;
    }
}
