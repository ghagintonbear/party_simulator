/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partysim;

/**
 *
 * @author ghaghadj
 */
public abstract class ModelConstants {
        
    // each person's creation probability is defined here
    // made static so it belongs to whole class not just instance of class
    // made final so it cannot change, 
    // no modifer since its the most relevent restrictive access level i.e. package private
    // as well as no methods required to access 
    static  double CHANCE_CREATION_HOST = 0.0;
    static  double CHANCE_CREATION_ENGINEER = 0.05;
    static  double CHANCE_CREATION_SCIENTIST = 0.05;
    static  double CHANCE_CREATION_ARTIST = 0.05;
    
    static  int DEFAULT_WIDTH = 25;
    static  int DEFAULT_DEPTH = 25;
    
    static  int RANDOM_NUMBER_GENERATOR_SEED = 48;
    
    static int DEFAULT_WINDOW = 1;
    
    static int DEFAULT_TIME = 1;
    
    static int STEP = 1;

}
