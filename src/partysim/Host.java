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
public class Host extends Person {
    
    public Host(Field field, int xLocation, int yLocation){
        super(field, xLocation, yLocation);
    }
    /**
     * 
     * @return what person is i.e. host
     */
    @Override
    public String toString() {
        return "Host"; 
    }
/**
 * This method overrides act method from abstract super class 
 * this method just moves host to free adjacent position and clears old location
 * from field
 * @param range 
 */
    @Override
    public void act(int range) {
        this.getField().clearLocation(this.getLocation());
        this.setLocation(this.getField().freeAdjacentLocation(this.getLocation()));
        this.getField().place(this, this.getLocation());
    }
}
