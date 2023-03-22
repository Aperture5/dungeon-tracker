/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeon.tracker;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bali
 */
public class Place {
    String description;
    Place north;
    Place west;
    Place east;
    Place south;
    boolean dark = true;
    boolean needsKey = false;
    Set<Item> items = new HashSet<>();
    Monster monster;
    
    Place(String b){
        description = b;
    }
}
