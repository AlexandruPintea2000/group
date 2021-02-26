package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * World Class
 */
public class World {
    private Connection con = null;
    private int worldPopulation;

    public World(int worldPopulation){
        this.worldPopulation = worldPopulation;
    }

    public World(){

    }

    public int getWorldPopulation(){
        return worldPopulation;
    }

    public void setWorldPopulation(int worldPopulation){
        this.worldPopulation = worldPopulation;
    }

    public long generateWorldPopulation() {
        long worldPop = 0L;

        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select sum(Population) from(select population from world.city union all select population from world.country) as population";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                worldPop = rset.getLong("sum(Population)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return worldPop;
    }
}
