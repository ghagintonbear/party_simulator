       package partysim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
       
   
       /**
        * Party Simulation Graphical User Interface
        * @author Zainab Khan
 
 Class header implements the ActionListener interface allowing the 
 ActionListener objects created when the actionPerformed method is called,
 to listen to the events activated by the user (mouse click)
 
 Class header implements the KeyListener interface allowing the 
 KeyListener objects created when the keyPressed method is called,
 to listen to the events activated by the user (enter key pressed)
        */
public class PartySimulationGUI implements ActionListener,KeyListener{
    
/////////////////////////////////FIELDS/////////////////////////////////////////
    
    private JFrame frame;
    private JLabel TitleR6;
    private JTextField s11;
    private JTextField s12;
    private JTextField s13;
    private JTextField s14;
    private JTextField s21;
    private JTextField s31;
    private JTextField s32;
    private JTextField s41;
    private JTextField s51;
    private JLabel rs11;
    private JLabel rs12;
    private JLabel rs13;
    private JLabel rs14;
    private JLabel rs21;
    private JLabel rs31;
    private JLabel rs32;
    private JLabel rs41;
    private JLabel rs51;    
    private JButton S61;
    private JButton S62;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenu fileMenu;
    private JMenuBar menubar;


    public PartySimulationGUI(){
        makeFrame();
    }
    
      private void makeFrame(){
        frame = new JFrame("PartySimulationGUI"); //Creates a new frame
        
////////////////////////////////CONTENT PANE////////////////////////////////////
        
        Container contentPane = frame.getContentPane(); 
        JPanel PanelWEST = new JPanel();
        JPanel PanelEAST0 = new JPanel();
        
        contentPane.setLayout(new FlowLayout()); //arranges components left to 
                                                 //right at their preferred size
        contentPane.add(PanelWEST);
        contentPane.add(PanelEAST0);
       
////////////////////////////PROPERTIES OF WEST PANEL////////////////////////////
        
        /**
         * Defines layout of west panel using GridLayout with 10 rows evenly spaced
         * in 1 column
         * Defines and sets a border to distinguish between the different panels
         */
        Border GreyLine = BorderFactory.createLineBorder(Color.GRAY, 2, true); 
        PanelWEST.setLayout(new GridLayout(10,1)); 
        PanelWEST.setBorder(BorderFactory.createTitledBorder(GreyLine, 
                 "User Input", TitledBorder.LEFT, TitledBorder.CENTER));
        
        //////////////////////////////////////////SECTION 1 OF WEST/////////////
                      
        /**
         * Creates the necessary JPanels, JTextFields and JLabels
         */
        JPanel PanelWEST1 = new JPanel();
        JPanel PanelWEST2 = new JPanel();
        JLabel Title1 = new JLabel("                   Creation Probabilities:");
        JLabel S11 = new JLabel("Host");
        JLabel S12 = new JLabel("   Engineer    ");
        JLabel S13 = new JLabel("Artist");
        JLabel S14 = new JLabel("   Scientist    ");
        s11 = new JTextField();
        s12 = new JTextField();
        s13 = new JTextField();
        s14 = new JTextField();
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, Grid Layout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
        PanelWEST1.setLayout(new BoxLayout(PanelWEST1, BoxLayout.PAGE_AXIS));; 
        PanelWEST2.setLayout(new GridLayout(2,4));
        PanelWEST2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        Title1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
     
        
        /**
         * Adds the necessary JLabels and JTextFields
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelWEST.add(Title1); 
        PanelWEST.add(PanelWEST1);
        PanelWEST1.add(PanelWEST2);
        PanelWEST2.add(S11);
        PanelWEST2.add(s11);
        PanelWEST2.add(S12);
        PanelWEST2.add(s12);
        PanelWEST2.add(S13);
        PanelWEST2.add(s13);
        PanelWEST2.add(S14);
        PanelWEST2.add(s14);
        
       
        //////////////////////////////////////////SECTION 2 OF WEST/////////////
       
        /**
         * Creates the necessary JPanels, JTextFields and JLabels
         */
        JPanel PanelWEST3 = new JPanel();
        JPanel PanelWEST4 = new JPanel(); 
        JLabel Title2 = new JLabel("           Party Member Search Distance:");
                JLabel S21 = new JLabel("Window");
        s21 = new JTextField();
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, Grid Layout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
        PanelWEST3.setLayout(new BoxLayout(PanelWEST3, BoxLayout.PAGE_AXIS));;     
        PanelWEST4.setLayout(new GridLayout(2,2));
        PanelWEST4.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        Title2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
 
        /**
         * Adds the necessary JLabels and JTextFields
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelWEST.add(Title2); 
        PanelWEST.add(PanelWEST3);
        PanelWEST3.add(PanelWEST4);
        PanelWEST4.add(S21);
        PanelWEST4.add(s21);
        
        //////////////////////////////////////////SECTION 3 OF WEST/////////////
       
        /**
         * Creates the necessary JPanels, JTextFields and JLabels
         */
        JPanel PanelWEST5 = new JPanel();
        JPanel PanelWEST6 = new JPanel();  
        JLabel Title3 = new JLabel("               Party Room Dimensions:");
        JLabel S31 = new JLabel("Room Width");
        JLabel S32 = new JLabel("Room Length");
        s31= new JTextField();
        s32 = new JTextField();
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, Grid Layout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
        PanelWEST5.setLayout(new BoxLayout(PanelWEST5, BoxLayout.PAGE_AXIS));;     
        PanelWEST6.setLayout(new GridLayout(2,2));
        PanelWEST6.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        Title3.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
        
        /**
         * Adds the necessary JLabels and JTextFields
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelWEST.add(Title3); 
        PanelWEST.add(PanelWEST5);
        PanelWEST5.add(PanelWEST6);
        PanelWEST6.add(S31);
        PanelWEST6.add(s31);
        PanelWEST6.add(S32);
        PanelWEST6.add(s32);
        
        //////////////////////////////////////////SECTION 4 OF WEST/////////////
       
        /**
         * Creates the necessary JPanels, JTextFields and JLabels
         */
        JPanel PanelWEST7 = new JPanel();
        JPanel PanelWEST8 = new JPanel();
        JLabel Title4 = new JLabel("                     Simulation Length:");
        JLabel S41 = new JLabel("Running Time:");
        s41 = new JTextField();
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, Grid Layout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
        PanelWEST7.setLayout(new BoxLayout(PanelWEST7, BoxLayout.PAGE_AXIS));;     
        PanelWEST8.setLayout(new GridLayout(2,2));
        PanelWEST8.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        Title4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));

        
        /**
         * Adds the necessary JLabels and JTextFields
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelWEST.add(Title4); 
        PanelWEST.add(PanelWEST7);
        PanelWEST7.add(PanelWEST8);
        PanelWEST8.add(S41);
        PanelWEST8.add(s41);
        
        
        //////////////////////////////////////////SECTION 5 OF WEST/////////////
       
        /**
         * Creates the necessary JPanels, JTextFields and JLabels
         */
        JPanel PanelWEST9 = new JPanel();   
        JPanel PanelWEST10 = new JPanel();  
        JLabel Title5 = new JLabel("       Random Number Generator Seed:");
        JLabel S51 = new JLabel("Seed:");
        s51 = new JTextField();
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, Grid Layout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
        PanelWEST9.setLayout(new BoxLayout(PanelWEST9, BoxLayout.PAGE_AXIS));;  
        PanelWEST10.setLayout(new GridLayout(2,2));
        PanelWEST9.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        Title5.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
       
        /**
         * Adds the necessary JLabels and JTextFields
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelWEST.add(Title5); 
        PanelWEST.add(PanelWEST9);
        PanelWEST9.add(PanelWEST10);
        PanelWEST10.add(S51);
        PanelWEST10.add(s51);
        
/////////////////////PROPERTIES OF EAST/////////////////////////////////////////
        
        /**
         * Defines layout of east panel using BorderLayout with 2 additional panels 
         * placed in the west and south section
         * Defines and sets a border to distinguish between the different panels
         */
        
        PanelEAST0.setLayout(new BorderLayout());
        PanelEAST0.setBorder(BorderFactory.createTitledBorder(GreyLine, 
                 "Simulation Variables", TitledBorder.LEFT, TitledBorder.CENTER));
        
        //////////////////////////////////////////SECTION 1 OF EAST/////////////
        
        /**
         * Creates the necessary JPanels and JLabals
         */
        JPanel PanelEAST = new JPanel();
        JPanel PanelEAST1 = new JPanel();
        JPanel PanelEAST2 = new JPanel();  
        JLabel TitleR1 = new JLabel("   >The creation probability of each type"
                  + " of person at the start of the simulation:");
        JLabel RS11 = new JLabel("Host:");
        JLabel RS12 = new JLabel("   Engineer:    ");
        JLabel RS13 = new JLabel("Artist:");
        JLabel RS14 = new JLabel("   Scientist:    ");
        rs11 = new JLabel("---");
        rs12 = new JLabel("---");
        rs13 = new JLabel("---");
        rs14 = new JLabel("---");
        
        /**
         * Creates a nested container with 4 JPanels using the following layout
         * managers: FlowLayout, BorderLayout, GridLayout, BoxLayout and GridLayout
         * Defines and sets an empty border to create enough space between sections 
         */
        PanelEAST.setLayout(new GridLayout(10,1));
        PanelEAST1.setLayout(new BoxLayout(PanelEAST1, BoxLayout.PAGE_AXIS));
        PanelEAST2.setLayout(new GridLayout(2,8));
        PanelEAST1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
      
        /**
         * Adds the necessary JLabels 
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST0.add(PanelEAST,BorderLayout.WEST);
        PanelEAST.add(TitleR1); 
        PanelEAST.add(PanelEAST1);
        PanelEAST1.add(PanelEAST2);
        PanelEAST2.add(RS11);
        PanelEAST2.add(rs11);
        PanelEAST2.add(RS12);
        PanelEAST2.add(rs12);
        PanelEAST2.add(RS13);
        PanelEAST2.add(rs13);
        PanelEAST2.add(RS14);
        PanelEAST2.add(rs14);
        
        //////////////////////////////////////////SECTION 2 OF EAST/////////////
       
        /**
         * Creates the necessary JPanels and JLabals
         */
        JPanel PanelEAST3 = new JPanel();
        JPanel PanelEAST4 = new JPanel();
        JLabel TitleR2 = new JLabel("   >The distance each guest may look around"
                + " him/her:  ");
        JLabel RS21 = new JLabel("Window:");
        rs21 = new JLabel("---");

        /**
         * Creates a nested container with 4 JPanels using the following layout
         * managers: FlowLayout,  BorderLayout, GridLayout, BoxLayout and GridLayout
         * Defines and sets an empty border to create enough space between sections 
         */
        PanelEAST3.setLayout(new BoxLayout(PanelEAST3, BoxLayout.PAGE_AXIS));
        PanelEAST4.setLayout(new GridLayout(1,1));
        PanelEAST3.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        /**
         * Adds the necessary JLabels 
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST.add(TitleR2); 
        PanelEAST.add(PanelEAST3);
        PanelEAST3.add(PanelEAST4);
        PanelEAST4.add(RS21);
        PanelEAST4.add(rs21);
   
        //////////////////////////////////////////SECTION 3 OF EAST/////////////

        /**
         * Creates the necessary JPanels and JLabals
         */
        JPanel PanelEAST5 = new JPanel();
        JPanel PanelEAST6 = new JPanel(); 
        JLabel TitleR3 = new JLabel("   >The dimensions of the party room:  ");
        JLabel RS31 = new JLabel("Width:  ");
        JLabel RS32 = new JLabel("Length: ");
        rs31 = new JLabel("---");
        rs32 = new JLabel("---");
        
        /**
         * Creates a nested container with 4 JPanels using the following layout
         * managers: FlowLayout, BorderLayout, GridLayout, BoxLayout and GridLayout
         * Defines and sets an empty border to create enough space between sections 
         */
        PanelEAST5.setLayout(new BoxLayout(PanelEAST5, BoxLayout.PAGE_AXIS));
        PanelEAST6.setLayout(new GridLayout(1,4));
        PanelEAST5.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
       
        /**
         * Adds the necessary JLabels 
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST.add(TitleR3); 
        PanelEAST.add(PanelEAST5);
        PanelEAST5.add(PanelEAST6);
        PanelEAST6.add(RS31);
        PanelEAST6.add(rs31);
        PanelEAST6.add(RS32);
        PanelEAST6.add(rs32);

        //////////////////////////////////////////SECTION 4 OF EAST/////////////
       
        /**
         * Creates the necessary JPanels and JLabals
         */
        JPanel PanelEAST7 = new JPanel();
        JPanel PanelEAST8 = new JPanel(); 
        JLabel TitleR4 = new JLabel("   >The period of time that the simulation "
                + "should be run for:");
        JLabel RS41 = new JLabel("Running Time:");
        rs41 = new JLabel("---");
        
        /**
         * Creates a nested container with 4 JPanels using the following layout
         * managers: FlowLayout, BorderLayout, GridLayout BoxLayout and GridLayout
         * Defines and sets an empty border to create enough space between sections 
         */
        PanelEAST7.setLayout(new BoxLayout(PanelEAST7, BoxLayout.PAGE_AXIS));
        PanelEAST8.setLayout(new GridLayout(1,1));
        PanelEAST7.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        /**
         * Adds the necessary JLabels 
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST.add(TitleR4); 
        PanelEAST.add(PanelEAST7);
        PanelEAST7.add(PanelEAST8);
        PanelEAST8.add(RS41);
        PanelEAST8.add(rs41);
       
        //////////////////////////////////////////SECTION 5 OF EAST/////////////
        
        /**
         * Creates the necessary JPanels and JLabals
         */
        JPanel PanelEAST9 = new JPanel();
        JPanel PanelEAST10 = new JPanel();
        JLabel TitleR5 = new JLabel("   >The seed for the random number generator:");
        JLabel RS51 = new JLabel("Seed:");
        rs51 = new JLabel("---");

        
        /**
         * Creates a nested container with 4 JPanels using the following layout
         * managers: FlowLayout, BorderLayout, GridLayout, BoxLayout and GridLayout
         * Defines and sets an empty border to create enough space between sections 
         */
        PanelEAST9.setLayout(new BoxLayout(PanelEAST9, BoxLayout.PAGE_AXIS));
        PanelEAST10.setLayout(new GridLayout(1,1));
        PanelEAST9.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
       
        /**
         * Adds the necessary JLabels 
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST.add(TitleR5);  
        PanelEAST.add(PanelEAST9);
        PanelEAST9.add(PanelEAST10);
        PanelEAST10.add(RS51);
        PanelEAST10.add(rs51);
      
        //////////////////////////////////////////SECTION 1 OF SOUTH(EAST)//////

        /**
         * Creates the necessary JPanels, JButtons, Border line and JLabels
         */
        JPanel PanelSOUTH = new JPanel();
        S61 = new JButton("Run Simulation");
        S62 = new JButton("Quit");
        TitleR6 = new JLabel("<html>Input ALL values, then press 'Enter' to set them"
                + "<br>  and click 'Run Simulation' to start the simulation</html>");
        JPanel PanelSOUTH1 = new JPanel();
        Border BlackLine = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        
        
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, BorderLayout, FlowLayout.LFTT and FlowLayout.RIGHT with the 
         * PanelSOUTH contained within the south section of the PanelEAST0 defined
         * by the BorderLayout
         * Sets a border to distinguish between the different panels
         */
        PanelSOUTH.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelSOUTH.setBorder(BorderFactory.createEmptyBorder(27, 0, 0, 0));
        PanelSOUTH1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        PanelSOUTH1.setBorder(BorderFactory.createTitledBorder(BlackLine, 
                 "", TitledBorder.LEFT, TitledBorder.CENTER));
        
        
        /**
         * Adds the necessary JLabel, JPanels and JButton
         * Places each JPanel within the previous to achieve the desired layout
         */
        PanelEAST0.add(PanelSOUTH,BorderLayout.SOUTH);
        PanelSOUTH.add(PanelSOUTH1);
        PanelSOUTH1.add(TitleR6);
        PanelSOUTH1.add(S61); //the user generates an action event by interacting 
                              //with this 'Run Simulation' JButton
        PanelSOUTH1.add(S62); //the user generates an action event by interacting
                              //with this 'Quit' JButton
    
/////////////////////////////////MENU BAR///////////////////////////////////////

        /**
         * Creates a JMenuBar, JMenuItems and adds the JMenuBar to the frame
         */
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        frame.setJMenuBar(menubar);
      
        /**
         * Creates a nested container with 3 JPanels using the following layout
         * managers: FlowLayout, BoxLayout and GridLayout
         * Sets a border to distinguish between the different panels
         * Changes and sets the font of the title 
         */
         
        menubar.setBorder(BorderFactory.createLineBorder(Color.black));
        openItem.setBorder(BorderFactory.createLineBorder(Color.black));
        saveItem.setBorder(BorderFactory.createLineBorder(Color.black));
        
        menubar.add(fileMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        
////////////////////////////////CENTRALISED EVENT HANDLING//////////////////////////////////

        /**
         * JButtons/JMenuItems call the addActionListener method which is implemented
         * in the class header as a ActionListener interface creating action 
         * listener objects 
         */
        
         S61.addActionListener(this); 
         S62.addActionListener(this);
         openItem.addActionListener(this);
         saveItem.addActionListener(this);
         
         /**
          * JTextFields call the addKeyListener method which is implemented
          * in the class header as a KeyListener interface creating key 
          * listener objects 
          */
         
         s11.addKeyListener(this);
         s12.addKeyListener(this);
         s13.addKeyListener(this);
         s14.addKeyListener(this);
         s21.addKeyListener(this);
         s31.addKeyListener(this);
         s32.addKeyListener(this);
         s41.addKeyListener(this);
         s51.addKeyListener(this);
 
///////////////////////////////FRAME PROPERTIES/////////////////////////////////
        
        frame.setPreferredSize(new Dimension(840,590));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true); }
      
     /**
      * The 'keyPressed' method is invoked to respond when the enter key in pressed
      * into the JTextField after user input, which creates the KeyListener object 
      * associated with the event. This is then registered with the corresponding
      * JTextField(GUI Component).
      * @param event 
      */ 
     @Override
    public void keyPressed(KeyEvent event) {
    if(event.getKeyCode() == KeyEvent.VK_ENTER) {

        String Error = "Invalid Entry";
        
        /**
         * The 'Double.parseDouble()' method allows for the conversion of a string
         * into a double. Therefore when a value is entered into any of the JTextFields
         * and the enter key is pressed, these values if they pass the validation rules
         * will appear accordingly on the opposite panel. If they do not pass the 
         * validation rules, the string "Invalid Entry" defined as 'Error' will 
         * appear instead.
         */
        
        double host = Double.parseDouble(s11.getText());
        if (host<0 || host>1){rs11.setText(Error);} 
        else { rs11.setText(String.valueOf(host));}  

        double engineer = Double.parseDouble(s12.getText());
        if (engineer<0 || engineer>1){rs12.setText(Error);} 
        else { rs12.setText(String.valueOf(engineer));}  
        
        double artist = Double.parseDouble(s13.getText());
        if (artist<0 || artist>1){rs13.setText(Error);} 
        else { rs13.setText(String.valueOf(artist));}  
        
        double scientist = Double.parseDouble(s14.getText());
        if (scientist<0 || scientist>1){rs14.setText(Error);} 
        else { rs14.setText(String.valueOf(scientist));}  
        
        double window = Double.parseDouble(s21.getText());
        if (window<0){rs21.setText(Error);} 
        else { rs21.setText(String.valueOf(window));}  
        
        double width = Double.parseDouble(s31.getText());
        if (width<0){rs31.setText(Error);} 
        else { rs31.setText(String.valueOf(width));}  
        
        double height = Double.parseDouble(s32.getText());
        if (height<0){rs32.setText(Error);} 
        else { rs32.setText(String.valueOf(height));}  
        
        double time = Double.parseDouble(s41.getText());
        if (time<0){rs41.setText(Error);} 
        else { rs41.setText(String.valueOf(time));}  
        
        double seed = Double.parseDouble(s51.getText());
        if (seed<0){rs51.setText(Error);}
        else { rs51.setText(String.valueOf(seed));}
        
        if ((host+engineer+artist+scientist)>1){
            rs11.setText(Error);
            rs12.setText(Error);
            rs13.setText(Error);
            rs14.setText(Error);}
        
        /**
         * If these values do not pass the validation rules, an error dialog box
         * will appear as well as another error message on the south panel clarifying
         * to the user what the error may be.
         */
        if ((host+engineer+artist+scientist)>1 || host<0 ||host>1 || engineer<0
                || engineer>1 || artist<0 || artist>1 || scientist<0 || scientist>1
                || window<0 || width<0 || height<0 || time<0 || seed<0){
            TitleR6.setText("<html>All creation probabilities must be between 0 "
                    + "and<br> 1 inclusive and their sum must not exceed 1!</html");
            JOptionPane.showMessageDialog(null,"<html>Simulation cannot run on "
                    + "the current input values!<br> Refer to variables "
                    + "corresponding to 'Invalid Entry'.<br> Note: Negative values"
                    + " are not valid for input.</html>", "Error", JOptionPane.ERROR_MESSAGE);}
        else{TitleR6.setText("<html>These entries are ALL valid and now set, click"
                + "<br>'Run Simulation' in order to start the simulation</html>");}                   
        }
    }
    /**
     * The 'actionPerformed' method is invoked to respond when the JButton or JMenuItem
     * is clicked, which creates the ActionListener object associated with the 
     * event.This is then registered with the corresponding JButton and JMenuItem 
     * (GUI Component).
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event) {
    if(event.getSource() == S62) { //When 'Quit' JButton is clicked, window will autmatically close
       frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));}
    if(event.getSource() == openItem) { //When 'Open' JMenuItem is clicked, open dialog box will appear
    JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);}
    if(event.getSource() == saveItem) { //When 'Save' JMenuItem is clicked, save dialog box will appear
    JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);}
    
    /**
     * The 'Double.parseDouble()' method allows for the conversion of a string
     * into a double. Therefore when the 'Run Simulation' JButton is clicked,
     * the values entered if they pass the validation rules will be stored in 
     * the variables defined and called in the Model Constants class and will be
     * the parameter values for the simulation.
     */
    if(event.getSource() == S61) {
        double h = Double.parseDouble(s11.getText());
        double e = Double.parseDouble(s12.getText());
        double a = Double.parseDouble(s13.getText());
        double s = Double.parseDouble(s14.getText());
        int window = Integer.parseInt(s21.getText());
        int width = Integer.parseInt(s31.getText());
        int height = Integer.parseInt(s32.getText());
        int time = Integer.parseInt(s41.getText());
        int seed = Integer.parseInt(s51.getText());
   
        /**
         * If these values do not pass the validation rules, an error dialog box
         * will appear as well as another error message on the south panel clarifying
         * to the user what the error may be.
         */
        if ((h+a+e+s)>1 || h<0 ||h>1 || e<0 || e>1 || a<0 || a>1 || s<0 || s>1 
                || window<0 || width<0 || height<0 || time<0 || seed<0) {
            TitleR6.setText("<html>All creation probabilities must be between 0 "
                    + "and<br> 1 inclusive and their sum must not exceed 1!</html");
            JOptionPane.showMessageDialog(null,"<html>Simulation cannot run on "
                    + "the current input values!<br> Refer to variables corresponding"
                    + " to 'Invalid Entry'.<br>Note: Negative values are not valid"
                    + " for input.</html>", "Error", JOptionPane.ERROR_MESSAGE);} 
        /**
         * If there is no error, the parameter values of the simulation will be
         * set accordingly
         */
        else{ ModelConstants.CHANCE_CREATION_HOST = h;
              ModelConstants.CHANCE_CREATION_ENGINEER = e;
              ModelConstants.CHANCE_CREATION_ARTIST = a;
              ModelConstants.CHANCE_CREATION_SCIENTIST = s;
              ModelConstants.DEFAULT_WINDOW = window;
              ModelConstants.DEFAULT_WIDTH = width;
              ModelConstants.DEFAULT_DEPTH = height;
              ModelConstants.DEFAULT_TIME = time;
              ModelConstants.RANDOM_NUMBER_GENERATOR_SEED = seed;
              ModelConstants.STEP = 1;
              Simulator.fieldConstructor(width,height);
              Simulator.simulate(time);
        }
      }
    }
    
    
    
  @Override
    public void keyTyped(KeyEvent event) {}
  @Override
    public void keyReleased(KeyEvent event) {}  
       
    public static void main(String[] args){
        PartySimulationGUI GUI = new PartySimulationGUI();
    }
   
}
      
