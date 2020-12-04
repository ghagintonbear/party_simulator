/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partysim;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Jhai
 */
public class Simulator {

    private static ArrayList<Person> persons;
    private static Field field;
    private static SimulatorView view;
    
    
    /**
     * This is an unorthodox constructor method for Simulator class
     * either way it constructs a field 
     * check if parameters given are valid
     * then creates field with valid parameters
     * populates field 
     * set the simulateView so we can see the simulator
     * 
     * @param width width of room
     * @param depth depth of room
     * @return a field of dimensions width*height and populated with persons
     */
    public static Field fieldConstructor(int depth, int width){
        persons = new ArrayList();
        if (width < 0){
            width = ModelConstants.DEFAULT_WIDTH;
        }
        if (depth < 0){
            depth = ModelConstants.DEFAULT_DEPTH;
        }
        field = new Field(width, depth);
        populate(field);
        setSimulateView();
        return field;   
    }
    
    /**
     * This method sets the colours for each person and enables view of 
     * the simulator
     */
    public static void setSimulateView(){
        view = new SimulatorView(field.getDepth(), field.getWidth());
        view.setColor(Artist.class, Color.yellow);
        view.setColor(Host.class, Color.BLUE);
        view.setColor(Engineer.class, Color.GREEN);
        view.setColor(Scientist.class, Color.ORANGE);
        view.showStatus(1, field);
    }
    
    /**
     * this method loops through each position in room 
     * at each position a random number is created between [0,1] (inclusive)
     * depending on random number either a specific type of person is created 
     * or no person is created
     * 
     * @param f field which is being populated with person
     */
    public static void populate(Field f){
        
        int widthLimit = f.getWidth();
        int depthLimit = f.getDepth();
        double[] limits = limitMaker();
        
        RandomGenerator.initialiseWithSeed(ModelConstants.RANDOM_NUMBER_GENERATOR_SEED);
        
        for (int col = 0; col < widthLimit; col++){
            for (int row = 0; row < depthLimit; row++){
                double rand = RandomGenerator.getRandom().nextDouble();
                if (0 <= rand && rand < limits[0]){
                    Host host = new Host(f,row,col);
                    persons.add(host);
                    f.place(host,row,col);
                }else if((limits[0] <= rand) && (rand < limits[1])){
                    Artist artist = new Artist(f,row,col);
                    persons.add(artist);
                    f.place(artist,row,col);
                }else if((limits[1] <= rand) && (rand < limits[2])){
                    Engineer engineer = new Engineer(f,row,col);
                    persons.add(engineer);
                    f.place(engineer,row,col);
                }else if((limits[2] <= rand) && (rand < limits[3])){
                    Scientist scientist = new Scientist(f,row,col);
                    persons.add(scientist);
                    f.place(scientist,row,col);
                }
            }
        }
    }
    
    /**
     * This method defines the limits which then go on to help define what person is created
     * each limit helps define a probability interval
     * 
     * @return array of limits
     */
    public static double[] limitMaker(){
        final double limit0 = ModelConstants.CHANCE_CREATION_HOST;
        final double limit1 = limit0 + ModelConstants.CHANCE_CREATION_ARTIST;
        final double limit2 = limit1 + ModelConstants.CHANCE_CREATION_ENGINEER;
        final double limit3 = limit2 + ModelConstants.CHANCE_CREATION_SCIENTIST;
        // test if cumulative creation probability exceeds 1 
        if (limit3 > 1 ){
            System.out.println("cumulative probability greater than 1");
            double[] fault = {0};
            return fault;
        }
        else{
            double[] limits = {limit0, limit1, limit2, limit3};
            return limits;
        }
    }
    /**
     * This method simulates the simulator by one step
     * it iterates through the list of persons 
     * and makes each one of them act
     * it also shows the field at the incremented step
     */
    public static void simulateOneStep(){
        ModelConstants.STEP++;
        Iterator<Person> iterate = persons.iterator();
        while(iterate.hasNext()){
            Person person = iterate.next();
            person.act(ModelConstants.DEFAULT_WINDOW);
        }
        view.showStatus(ModelConstants.STEP, field);        
    }
    /**
     * simulates a given number of steps
     * loops for that many steps while calling simulateOneStep method
     * @param steps number of steps simulated for
     */
    public static void simulate(int steps){
        for(int i = 1; i < steps; i++){
            simulateOneStep();
        }
    }
}
