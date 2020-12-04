/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partysim;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Person class made abstract since we do not require any instances of person to be created 
 * it only has to act as a super class
 * @author Jhai
 */
public abstract class Person {
    
    // the location of the person being created within the field
    private Location location;
    // the field in which the person will be created
    private Field field;
//    private int happy = 0;
    
    /**
     * Person creation, even though a person will never be created 
     * Done to improve efficency and maintenance of code
     * 
     * @param field party room
     * @param xLocation x coordinate in room
     * @param yLocation y coordinate in room
     */
    public Person(Field field, int xLocation, int yLocation){
        Location loc = new Location(xLocation,yLocation);
        this.field = field;
        this.location = loc;
    }
    /**
     * getter for field
     * @return returns this person field
     */
    public Field getField() {
        return this.field;
    }
    /**
     * setter for field
     * @param field sets this persons field
     */
    public void setField(Field field){
        this.field = field;
    }
    /**
     * getter for location
     * @return this persons location
     */
    protected Location getLocation() {
        return this.location;
    }
    /**
     * setter for location
     * @param location sets this persons location
     */
    protected void setLocation(Location location){
        this.location = location;
    }
    /**
     * abstract method for act
     * since it should never be used for a person
     * since a person instance will never be created
     * @param range range of act 
     */
    
    public abstract void act(int range);
}