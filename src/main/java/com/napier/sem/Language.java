package com.napier.sem;

/**
 * Class for Language
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class Language {
    // Language
    private String language;
    // Language Population
    private long population;
    // Language Percentage
    private float percentage;

    /**
     * Language Constructor
     * @param language
     * @param population
     * @param percentage
     */
    public Language(String language, long population, float percentage){
        this.language = language;
        this.population = population;
        this.percentage = percentage;
    }

    /**
     * Language Constructor
     */
    public Language(){

    }

    /**
     * Returns language
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets a value for language
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Returns population
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Sets a value for population
     * @param population
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Returns percentage
     * @return percentage
     */
    public float getPercentage() {
        return percentage;
    }

    /**
     * Sets a value for percentage
     * @param percentage
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
