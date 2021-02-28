package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * World Class
 */
public class World {
    private Connection con = null;
    private long worldPopulation;

    public World(){

    }

    public void setCon(Connection con){
        this.con = con;
    }

    // Returns the population of the world
    public long getWorldPopulation(){
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select sum(Population) from(select population from world.city union all select population from world.country) as population";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                worldPopulation = rset.getLong("sum(Population)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return worldPopulation;
    }
}
