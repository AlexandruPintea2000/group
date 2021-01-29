
class CountryLanguage
{
	private String CountryCode;
	private String Language;
	private boolean IsOfficial;
	private float Percentage;	
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
}

class City
{
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private long Population;
}

public class Main
{
    private City cities[];
    private Country countries[];
    private CountryLanguage languages[];

    public static void main( String[] args )
    {
        System.out.print( "java" );
		System.out.print( "comples" );
    }
}

