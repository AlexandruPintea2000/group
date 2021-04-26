package com.napier.sem;

public class InOrOutCity {
    private String place;
    private long population;
    private long inCityPopulation;
    private float inCityPercentage;
    private long outCityPopulation;
    private float outCityPercentage;

    public InOrOutCity(String place, long population, long inCityPopulation, float inCityPercentage, long outCityPopulation, float outCityPercentage){
        this.place = place;
        this.population = population;
        this.inCityPopulation = inCityPopulation;
        this.inCityPercentage = inCityPercentage;
        this.outCityPopulation = outCityPopulation;
        this.outCityPercentage = outCityPercentage;
    }

    public InOrOutCity(){

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getInCityPopulation() {
        return inCityPopulation;
    }

    public void setInCityPopulation(long inCityPopulation) {
        this.inCityPopulation = inCityPopulation;
    }

    public float getInCityPercentage() {
        return inCityPercentage;
    }

    public void setInCityPercentage(float inCityPercentage) {
        this.inCityPercentage = inCityPercentage;
    }

    public long getOutCityPopulation() {
        return outCityPopulation;
    }

    public void setOutCityPopulation(long outCityPopulation) {
        this.outCityPopulation = outCityPopulation;
    }

    public float getOutCityPercentage() {
        return outCityPercentage;
    }

    public void setOutCityPercentage(float outCityPercentage) {
        this.outCityPercentage = outCityPercentage;
    }
}
