package com.napier.sem;

/**
 * Class for InOrOutCity
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class InOrOutCity {
    private String place;
    private long population;
    private long inCityPopulation;
    private float inCityPercentage;
    private long outCityPopulation;
    private float outCityPercentage;

    /**
     * Constructor for InOrOutCity
     * @param place
     * @param population
     * @param inCityPopulation
     * @param inCityPercentage
     * @param outCityPopulation
     * @param outCityPercentage
     */
    public InOrOutCity(String place, long population, long inCityPopulation, float inCityPercentage, long outCityPopulation, float outCityPercentage){
        // Place name
        this.place = place;
        // Place total population
        this.population = population;
        // People living inside city population
        this.inCityPopulation = inCityPopulation;
        // People living inside city percentage
        this.inCityPercentage = inCityPercentage;
        // People living outside city population
        this.outCityPopulation = outCityPopulation;
        // People living outside city percentage
        this.outCityPercentage = outCityPercentage;
    }

    /**
     * Constructor for InOrOutCity
     */
    public InOrOutCity(){

    }

    /**
     * Returns the place
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets a value for the place
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Returns the population
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Sets a value for the population
     * @param population
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Returns inCityPopulation
     * @return inCityPopulation
     */
    public long getInCityPopulation() {
        return inCityPopulation;
    }

    /**
     * Sets a value for inCityPopulation
     * @param inCityPopulation
     */
    public void setInCityPopulation(long inCityPopulation) {
        this.inCityPopulation = inCityPopulation;
    }

    /**
     * Returns the inCityPercentage
     * @return inCityPercentage
     */
    public float getInCityPercentage() {
        return inCityPercentage;
    }

    /**
     * Sets a value for the inCityPercentage
     * @param inCityPercentage
     */
    public void setInCityPercentage(float inCityPercentage) {
        this.inCityPercentage = inCityPercentage;
    }

    /**
     * Returns the outCityPopulation
     * @return outCityPopulation
     */
    public long getOutCityPopulation() {
        return outCityPopulation;
    }

    /**
     * Sets a value for the outCityPopulation
     * @param outCityPopulation
     */
    public void setOutCityPopulation(long outCityPopulation) {
        this.outCityPopulation = outCityPopulation;
    }

    /**
     * Returns outCityPercentage
     * @return outCityPercentage
     */
    public float getOutCityPercentage() {
        return outCityPercentage;
    }

    /**
     * Sets a value for outCityPercentage
     * @param outCityPercentage
     */
    public void setOutCityPercentage(float outCityPercentage) {
        this.outCityPercentage = outCityPercentage;
    }
}
