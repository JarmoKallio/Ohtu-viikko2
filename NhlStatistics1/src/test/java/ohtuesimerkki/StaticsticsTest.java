/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jambo
 */
public class StaticsticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test 
    public void talletusToimii(){
        Player x = stats.search("Semenko");
        int xGoals = x.getGoals();
        assertEquals(4, xGoals);
        
    }
    
    @Test 
    public void searchToimiiKunEiLoydyPelaajaa(){
        Player x = stats.search("Semenkooo");
        boolean b = false;
        if(x == null){
            b=true;
        }
        assertEquals(true, b);
        
    }
    
    @Test 
    public void teamToimii(){
        ArrayList<Player> team = (ArrayList<Player>) stats.team("PIT");
        Player x = team.get(0);
        int xAssists = x.getAssists();
        assertEquals(54, xAssists);   
    }
    
    @Test 
    public void topScorersToimii(){
        ArrayList<Player> scorers = (ArrayList<Player>) stats.topScorers(3);
        
        Player x = scorers.get(0);
        int xGoals = x.getGoals();
        assertEquals(35, xGoals);
    }
    
    @Test 
    public void koklaus(){
        assertEquals(5, 5);   
    }
    
}