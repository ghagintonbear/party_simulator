/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partysim;

/**
 *
 * @author Jhai
 */
public class Artist extends Guest {
    
    public Artist(Field field, int xLocation, int yLocation){
        super(field, xLocation, yLocation);
        this.addFriends();
    }
    /**
     * 
     * @return string containing who person is i.e. artist
     */
    @Override
    public String toString() {
        return "Artist"; 
    }
    /**
     * unique friends list of each guest
     */
    public final void addFriends(){
        this.getFriends().add("Artist");
        this.getFriends().add("Host");
    }
    
}
