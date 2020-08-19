package com.markus.veggarden.model.plant;

import com.markus.veggarden.model.construction.*;

import java.util.ArrayList;

public class Plant{
    private String name;
    private int growingDuration;
    private int startMonth;

    protected ArrayList<Plant> recommendedNeighbours = new ArrayList<>();
    protected ArrayList<Plant> forbiddenNeighbours = new ArrayList<>();

    // possible values for neighbour Rank
    public static final int RECOMMENDED = 1;
    public static final int NEUTRAL = 0;
    public static final int NOT_ALLOWED = -1;

    private int nutrition_demand;

    // POSSIBLE VALUES FOR NUTRITION DEMAND (TODO: ENUM)
    public static final int GREEN_MANURING = 0;
    public static final int LOW_DEMAND = 1;
    public static final int MEDIUM_DEMAND = 2;
    public static final int HIGH_DEMAND = 3;

    public Plant(String name, int growingDuration, int startMonth) {
        this.name = name;
        this.growingDuration = growingDuration;
        this.startMonth = startMonth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeighbourRank(Plant neighbour) {
        if(neighbour == null) return NEUTRAL;

        if (forbiddenNeighbours.contains(neighbour)) {
            return NOT_ALLOWED;
        } else if (recommendedNeighbours.contains(neighbour)) {
            return RECOMMENDED;
        } else{
            return NEUTRAL;
        }
    }

    public void water(){
        System.out.println("water");
    }

    public boolean get_todays_tasks() {
        water();
        return true;
    }

    public void addRecommendedNeighbour(Plant neighbour){
        recommendedNeighbours.add(neighbour);
    }

    public void addForbiddenNeighbour(Plant neighbour){
        forbiddenNeighbours.add(neighbour);
    }

    // Finds Plant Elements by a given Name
    public static Plant findPlant(String name, ArrayList<Plant> availablePlants) {
        for (Plant singlePlant:availablePlants) {
            if(singlePlant.getName().equals(name)){
                System.out.println(singlePlant.getClass().getName());
                return singlePlant;
            }
        }
        System.out.println("Kein Element mit dem Namen " + name + " vorhanden");
        return null;
    }

    // Method for Test in Console to Create Initial Plants
    public static ArrayList<Plant> load_plants() {
        ArrayList<Plant> availablePlants = new ArrayList<>();
        Plant cucumber = new Plant("Gurke", 45, 4);
        Plant zucchini = new Plant("Zucchini", 50, 4);
        Plant onion = new Plant("Zwiebel", 30, 3);
        Plant tomato = new Plant("Tomate", 100, 5);
        Plant carrot = new Plant("Karotte", 20, 4);

        availablePlants.add(cucumber);
        availablePlants.add(zucchini);
        availablePlants.add(onion);
        availablePlants.add(tomato);
        availablePlants.add(carrot);

        carrot.addRecommendedNeighbour(tomato);
        carrot.addRecommendedNeighbour(onion);

        tomato.addRecommendedNeighbour(onion);
        tomato.addForbiddenNeighbour(cucumber);

        cucumber.addForbiddenNeighbour(zucchini);
        cucumber.addRecommendedNeighbour(onion);

        zucchini.addForbiddenNeighbour(cucumber);
        zucchini.addRecommendedNeighbour(onion);

        onion.addRecommendedNeighbour(cucumber);
        onion.addRecommendedNeighbour(zucchini);
        return availablePlants;
    }

}
