/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partysim;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jhai
 */

// No instance of guest should be created therefore abstract
public abstract class Guest extends Person{
    // happiness index for guests
    private int happy=0;
    // Each persons friends list are stored here (who they want to socialise with)
    private ArrayList<String> friends = new ArrayList();
    
    // Guest constructor
    public Guest(Field field, int xLocation, int yLocation){
        super(field,xLocation,yLocation);
    }
    
    /**
     *  getter for friends list
     * @return friends list for that person
     */
    public ArrayList<String> getFriends(){
        return this.friends;
    }
    
    /**
     * This method checks the immediate adjacent locations and checks who they 
     * are against their unique friends list 
     * if friend is found then happiness is incremented 
     * 
     * @return happy - each guests happiness index 
     */
    public int howHappyNow(){
        while(this.getField().adjacentLocations(this.getLocation()).hasNext()){
            Person person = this.getField().getObjectAt(this.getField().adjacentLocations(this.getLocation()).next());
                if (this.pursueFriend(person)){
                    this.happy++;
                }
        }
        return this.happy;
    }
    
    /**
     * checks if given person is on each guests unique friend list
     * @param person person being checked 
     * @return true if they are a friend
     */
    public boolean pursueFriend(Person person){
        if(person != null){
            for(String p : this.getFriends()){
                if (person.toString().equals(p)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * This method uses other methods to gather information about local area
     * information being were are most 'friends' located
     * after which the method chooses which direction to go in based on information
     * 
     * i.e. the pursuit of happiness
     * 
     * @param range amount of spaces being scanned in each direction
     */
    @Override
    public void act(int range){
        ArrayList<Location> locations = bestLocations(scoutQuadX("N", range), scoutQuadX("E", range),
                scoutQuadX("S", range), scoutQuadX("W", range));
        for(Location loc : locations){
            if(this.getField().getObjectAt(loc)==null){
                this.getField().clearLocation(this.getLocation());
                this.setLocation(loc);
                this.getField().place(this, this.getLocation());
                return;
            }
        }
    }
    
    /**
     * given the amount of number of friends in each quadrant, this method then
     * sorts those numbers from lowest to biggest
     * based on that sort it chooses which directions it should try first and 
     * adds them onto the list 
     * 
     * @param numFriendsN number of friends in north quadrant 
     * @param numFriendsE number of friends in east quadrant 
     * @param numFriendsS number of friends in south quadrant 
     * @param numFriendsW number of friends in west quadrant 
     * @return arraylist with ideal locations 
     */
    public ArrayList<Location> bestLocations(int numFriendsN,final int numFriendsE, int numFriendsS, int numFriendsW){
        int[] friendX = {numFriendsN, numFriendsE, numFriendsS, numFriendsW};
        Arrays.sort(friendX);
        ArrayList<Location> bestDirection = new ArrayList();
        for(int x = 3; x > 0; x--){
            if(friendX[x] == numFriendsN){
                Location locN1 = new Location (outOfGridRow("minus"),outOfGridCol(this.getLocation().getCol(),0,"plus"));
                Location locN2 = new Location (outOfGridRow("minus"),outOfGridCol("plus"));
                bestDirection.add(locN1);
                bestDirection.add(locN2);
            }else if(friendX[3] == numFriendsE){
                Location locE1 = new Location (outOfGridRow(this.getLocation().getRow(),0,"minus"),outOfGridCol("plus"));
                Location locE2 = new Location (outOfGridRow("plus"),outOfGridCol("plus"));
                bestDirection.add(locE1);
                bestDirection.add(locE2); 
            }else if(friendX[3] == numFriendsS){
                Location locS1 = new Location (outOfGridRow("plus"),outOfGridCol(this.getLocation().getCol(),0,"plus"));
                Location locS2 = new Location (outOfGridRow("plus"),outOfGridCol("minus"));
                bestDirection.add(locS1);
                bestDirection.add(locS2); 
            }else if(friendX[3] == numFriendsW){
                Location locW1 = new Location (outOfGridRow(this.getLocation().getRow(),0,"plus"),outOfGridCol("minus"));
                Location locW2 = new Location (outOfGridRow("minus"),outOfGridCol("minus"));
                bestDirection.add(locW1);
                bestDirection.add(locW2); 
            }
        }
        return bestDirection;
    }
    
    /**
     * checks if the next position being checked is out of grid (left to right),
     * if the next position is out of grid, then we'll continue the torus effect
     * plus means incrementing to the right, 
     * minus means incrementing to the left
     * 
     * @param rowPosition row position now
     * @param dummyVar increment value
     * @param plusMinus direction
     * @return 
     */
    public int outOfGridRow(int rowPosition, int dummyVar, String plusMinus){
        switch (plusMinus){
        case("plus"): 
            if(rowPosition + dummyVar > this.getField().getDepth()-1){
                return 0;
            }else{
                return rowPosition + dummyVar;
            }
        case("minus"):
            if(rowPosition - dummyVar < 0){
                return this.getField().getDepth()-1;
            }else{
                return rowPosition - dummyVar;
            }
        }
        return -1;
    }
    
    /**
     *Specific type of method, made for effeicency 
     * @param plusMinus direction , + or -
     * @return method above implemented 
     */
    public int outOfGridRow(String plusMinus){
        return outOfGridRow(this.getLocation().getRow(),1,plusMinus);
    }
    
    /**
     * checks if the next position being checked is out of grid (top to bottom), 
     * and if it will we have then continue the torus effect
     * plus incrementing down, since down is defined as positive
     * minus incrementing up.
     * 
     * @param colPosition column position right now
     * @param dummyVar increment value
     * @param plusMinus direction
     * @return 
     */
    public int outOfGridCol(int colPosition, int dummyVar, String plusMinus){
        switch (plusMinus){
            case("plus"):
                if(colPosition + dummyVar > this.getField().getWidth()-1){
                    return 0;
                }else{
                    return colPosition + dummyVar;
                }
            case("minus"):
                if(colPosition - dummyVar < 0){
                    return this.getField().getWidth()-1;
                }else{
                    return colPosition - dummyVar;
                }
        }
        return -1;
    }
    
    public int outOfGridCol(String plusMinus){
        return outOfGridCol(this.getLocation().getCol(),1,plusMinus);
    }
    
    /**
     * This method just loops through each position in the defined scout grid(range) and then checks if 
     * whoever is found is a friend of the given person, if a friend is found then potential happiness that 
     * can be found in this grid thats being looped through goes up.
     * 
     * 
     * @param quadMagnitude total number of spaces in the scout range (minus the one space occupied by the person scouting)
     * @param rowPosition starting row position for that quadrant
     * @param colPosition starting column position for that quadrant
     * @param quadRowLimit limit of how many spaces to go across in this quadrant 
     * @param quadColLimit limit of how many spaces to go up in this quadrant
     * @param rowIncrementDirection direction being searched i.e. left or right
     * @param colIncrementDirection
     * @return 
     */
    public int scoutQuad(int quadMagnitude, int rowPosition, int colPosition, int quadRowLimit, int quadColLimit, 
            String rowIncrementDirection, String colIncrementDirection){
        int potentialHappiness=0;
        for(int row = 0; row < quadRowLimit; row++){
            int scoutPositionRow = outOfGridRow(rowPosition, row, rowIncrementDirection);
            for(int col = 0; col < quadColLimit; col++){
                int scoutPositionCol = outOfGridCol(colPosition, col, colIncrementDirection);
                Person person = this.getField().getObjectAt(scoutPositionRow, scoutPositionCol);
                if (this.pursueFriend(person)){
                    potentialHappiness++;
                }
            }
        }
        return potentialHappiness;
    }
    
    /**
     * scoutQuadX stands for scout quadrant x where x represents north (n) south (s) east(e) and west(w)
     * This method essentially is used to clean up the code. First variables are defined which are valid for all 
     * four quadrants. Then in each case a few more variables are defined which are specific to each quadrant. 
     * after all necessary variables are defined, the method calls the scoutQuad method to scout the quadrant defined
     * in that case.
     * 
     * @param compassDirection which quadrant is being scouted; "N"orth, "S"outh, "E"ast, "W"est
     * @param scoutRange range of the 'scouting' (how many spaces in each direction
     * @return how many people that the given person likes in that quadrant.
     */
    public int scoutQuadX(String compassDirection, int scoutRange){
        int gridLength = (scoutRange*2)+1;
        int quadMagnitude = ((gridLength*gridLength)-1)/4;
        int quadLength = scoutRange;
        int quadWidth = quadMagnitude/quadLength;
        int rowPosition, colPosition, quadRowLimit, quadColLimit;
        String rowIncrementDirection, colIncrementDirection;
        switch (compassDirection){
            case "N":
                rowPosition = this.getLocation().getRow()-1;
                colPosition = this.getLocation().getCol();
                rowIncrementDirection = "minus";
                colIncrementDirection = "plus";
                quadRowLimit = quadLength;
                quadColLimit = quadWidth;
                return scoutQuad(quadMagnitude, rowPosition, colPosition, quadRowLimit, quadColLimit, 
                        rowIncrementDirection, colIncrementDirection);
            case "E":
                rowPosition = this.getLocation().getRow();
                colPosition = this.getLocation().getCol()+1;
                rowIncrementDirection = "plus";
                colIncrementDirection = "plus";
                quadRowLimit = quadWidth;
                quadColLimit = quadLength;
                return scoutQuad(quadMagnitude, rowPosition, colPosition, quadRowLimit, quadColLimit, 
                        rowIncrementDirection, colIncrementDirection);
            case "S":
                rowPosition = this.getLocation().getRow()+1;
                colPosition = this.getLocation().getCol();
                rowIncrementDirection = "plus";
                colIncrementDirection = "minus";
                quadRowLimit = quadLength;
                quadColLimit = quadWidth;
                return scoutQuad(quadMagnitude, rowPosition, colPosition, quadRowLimit, quadColLimit, 
                        rowIncrementDirection, colIncrementDirection);
            case "W":
                rowPosition = this.getLocation().getRow();
                colPosition = this.getLocation().getCol()-1;
                rowIncrementDirection = "minus";
                colIncrementDirection = "minus";
                quadRowLimit = quadWidth;
                quadColLimit = quadLength;
                return scoutQuad(quadMagnitude, rowPosition, colPosition, quadRowLimit, quadColLimit, 
                        rowIncrementDirection, colIncrementDirection);
        }
        return -1;
    }
    
}
