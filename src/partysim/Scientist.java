/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partysim;

/**
 * extends person
 * @author Jhai
 */
public class Scientist extends Guest{
    
    public Scientist(Field field, int xLocation, int yLocation){
        super(field, xLocation, yLocation);
        this.addFriends();
    }
    /**
     * 
     * @return what/who the object is
     */
    @Override
    public String toString() {
        return "Scientist"; 
    }
    /**
     * unique friends list of each guest
     */
    public final void addFriends(){
        this.getFriends().add("Artist");
        this.getFriends().add("Host");
        this.getFriends().add("Scientist");
    }


}
