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
public class Engineer extends Guest{
    
    public Engineer(Field field, int xLocation, int yLocation){
        super(field, xLocation, yLocation);
        this.addFriends();
    }
/**
 * 
 * @return what person is i.e. engineer 
 */
    @Override
    public String toString() {
        return "Engineer";
    }
    /**
     * adds the unique group of people that this person likes to socialise with
     * 
     */
    public final void addFriends(){
        this.getFriends().add("Engineer");
        this.getFriends().add("Artist");
        this.getFriends().add("Host");
        this.getFriends().add("Scientist");
    }
    
}
