import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;

class CountryLanguage
{
    private String CountryCode;
    private String Language;
    private boolean IsOfficial;
    private float Percentage;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public boolean isOfficial() {
        return IsOfficial;
    }

    public void setOfficial(boolean official) {
        IsOfficial = official;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float percentage) {
        Percentage = percentage;
    }

    public CountryLanguage(String countryCode, String language, boolean isOfficial, float percentage) {
        CountryCode = countryCode;
        Language = language;
        IsOfficial = isOfficial;
        Percentage = percentage;
    }

    public CountryLanguage(String countryCode, String language, float percentage) {
        CountryCode = countryCode;
        Language = language;
        IsOfficial = true; // default
        Percentage = percentage;
    }
}

class Country
{
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private double SurfaceArea;
    private int IndepYear;
    private int Population;
    private float LifeExpectancy;
    private float GNP;
    private float GNPOld;
    private String LocalName;
    private String GouvermentForm;
    private String HeadOfState;
    private int Capital;
    private String Code2;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public double getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(int indepYear) {
        IndepYear = indepYear;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }

    public float getGNP() {
        return GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }

    public String getGouvermentForm() {
        return GouvermentForm;
    }

    public void setGouvermentForm(String gouvermentForm) {
        GouvermentForm = gouvermentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    public Country(String code, String name, String continent, String region, double surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String gouvermentForm, String headOfState, int capital, String code2) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        SurfaceArea = surfaceArea;
        IndepYear = indepYear;
        Population = population;
        LifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        LocalName = localName;
        GouvermentForm = gouvermentForm;
        HeadOfState = headOfState;
        Capital = capital;
        Code2 = code2;
    }

    public Country(String code, String name, String continent, String region, int population, int capital) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        SurfaceArea = -1.0;
        IndepYear = -1;
        Population = population;
        LifeExpectancy = -1;
        this.GNP = (float) -1.0;
        this.GNPOld = (float) -1.0;
        LocalName = "";
        GouvermentForm = "";
        HeadOfState = "";
        Capital = capital;
        Code2 = "";
    }

}

class City
{
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private long Population;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public long getPopulation() {
        return Population;
    }

    public void setPopulation(long population) {
        Population = population;
    }

    public City(int ID, String name, String countryCode, String district, long population) {
        this.ID = ID;
        Name = name;
        CountryCode = countryCode;
        District = district;
        Population = population;
    }
}

public class Main
{
    private City cities[];
    private Country countries[];
    private CountryLanguage languages[];

    // show file text for a file in "data_files" folder
    private static void show_file ( String filename )
    {
        Path path = Paths.get("../data_files/" + filename + ".txt"); // compiled file is in "compiled" folder

        // output
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach( line -> System.out.println( line ) );
        } catch (IOException ex) {
            // do something or re-throw...
        }
    }

    public static void get_data ()
    {
        // Runtime r = Runtime.getRuntime();

		System.out.print( "Get db data!" );
		// get db data
    }

    // main
    public static void main( String[] args )
    {
        get_data();

        // show options using text files
        // related to user choice

        show_file( "options_main" );

        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();


        // Largest to smallest
        if ( choice.equals( "1" ) )
        {
            show_file( "options_1" );
            choice = scan.nextLine();

            if ( choice.equals( "1" ) )
            {
                System.out.print( "Country:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "2" ) )
            {
                System.out.print( "City:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "3" ) )
            {
                System.out.print( "Capital City:" );
                choice = scan.nextLine();
            }
        }


        // Population statistics
        if ( choice.equals( "2" ) )
        {
            show_file( "options_2" );
            choice = scan.nextLine();

            if ( choice.equals( "1" ) )
            {
                // For Earth
            }

            if ( choice.equals( "2" ) )
            {
                System.out.print( "Continent:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "3" ) )
            {
                System.out.print( "Region:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "4" ) )
            {
                System.out.print( "Country:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "5" ) )
            {
                System.out.print( "District:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "6" ) )
            {
                System.out.print( "City:" );
                choice = scan.nextLine();
            }
        }


        // Population count ( shows only population )
        if ( choice.equals( "3" ) )
        {
            show_file( "options_3" );
            choice = scan.nextLine();

            if ( choice.equals( "1" ) )
            {
                // For Earth
            }

            if ( choice.equals( "2" ) )
            {
                System.out.print( "Continent:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "3" ) )
            {
                System.out.print( "Region:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "4" ) )
            {
                System.out.print( "Country:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "5" ) )
            {
                System.out.print( "District:" );
                choice = scan.nextLine();
            }

            if ( choice.equals( "6" ) )
            {
                System.out.print( "City:" );
                choice = scan.nextLine();
            }
        }


        // Population by spoken language
        if ( choice.equals( "4" ) )
        {
            show_file( "options_4" );
            choice = scan.nextLine();

            if ( choice.equals( "1" ) )
            {
                System.out.print( "Languages ( Delimitate with ' ' ):" );
                choice = scan.nextLine();
                // Move data to array
            }

            if ( choice.equals( "2" ) )
            {
                // Use predefined languages ( Chinese, English, Hindi, Spanish and Arabic )
            }
        }

    }
}

