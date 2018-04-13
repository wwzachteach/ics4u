import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

public class GUICoffee1 {

    // window frame
    private JFrame frame;  
    private JPanel contentPane;
    
    // text fields
    private JTextField depositText; //paying
    private JTextField espressoText; //coffee type
    private JTextField blackText; //coffee type
    private JTextField milkText; //additive type
    private JTextField vanillaText; //additive type
    private JTextField creamText; //additive type
    private JTextField sugarText; //additive type
    
    /**
     * calls the coffee GUI start method
     */
    public static void main (String[] args) 
    { 
        GUICoffee1 gui = new GUICoffee1(); 
        gui.start(); 
    }    
    
    public void start() 
    {
        frame = new JFrame("GUI Coffee"); //The title of the window is called GUI Coffee
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //gives the ability to close program easily using the operating system's layout
       
        //on start, call the following methods
        makeMenus();
        makeContent();
        frame.pack();
        frame.setVisible(true);
    }
   
    /**
     * gives the user the opportunity to navigate the window using the cursor instead of just keyboard shortcuts
     */
    private void makeMenus()
    {
        JMenuBar menuBar;
        
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        menuBar.add(makeFileMenu());
    }
    
    /**
     * access to the options given to a user under the File menu
     * allows the user to make a new order when they click "new order" (shortcut is ctrl + n) or submit the order (ctrl + s+; both options are in one place
     * all options can be done without having to use keyboard shortcuts.
     */
    private JMenu makeFileMenu() 
    {
        JMenu menu;
        JMenuItem menuItem;        // set up the File menu
        menu = new JMenu("File"); // puts menu name
        menu.setMnemonic(KeyEvent.VK_F); 
        
        // add New menu item, which makes a new order
        menuItem = new JMenuItem("New Order");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.addActionListener(new NewListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, //keyboard shortcut
                                       Event.CTRL_MASK));
        menu.add(menuItem);
          
        // add Save menu item, which prints the reciept.
        menuItem = new JMenuItem("Save Order");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.addActionListener(new SaveListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, //keyboard shortcut
                                       Event.CTRL_MASK));
        menu.add(menuItem);        // add Exit menu item, which allows easier access to close GUI
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_X);
        menuItem.addActionListener(new ExitListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Q, //keyboard shortcut
                                       Event.CTRL_MASK));
        menu.add(menuItem);
          
        return menu;
    }    
    
    /**
     * makes the GUI, and actually loads it with different regions. The methods don't have a way to run without it, and they need to run as a group to be understandable.
     */
    private void makeContent() 
    { 
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));
        makeNorthRegion();
        makeWestRegion();
        makeCenterRegion();
        makeEastRegion();
    }
    
    /**
     * image on the GUI to show what the product is.
     * directs BlueJ to the correct location using the full filepath
     * inserts the image in the North Region
     */
    private void makeNorthRegion() 
    { 
        JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\jblei\\OneDrive\\Documents\\ICS4U\\Unit 2\\Assignment 4 - 4\\Coffee Image3.jpg"), JLabel.CENTER);
        contentPane.add(imgLabel, BorderLayout.NORTH);
    }
    
    /**
     * region of the GUI where payments are made. Separated so that people know where it is without much effort
     * adds the text fields to the West region
     */
    private void makeWestRegion() 
    { 

        // pay money in this area
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Manage Account(Enter Quantity)"));
        panel.setPreferredSize (new Dimension(300, 170)); //west region size (x, y)
        
        // the text field that allows users to put an amount of money of their choice in.
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        depositText = new JTextField("",2);
        depositText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(depositText);
        smallPanel.add(new JLabel(" Deposit Money")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        contentPane.add(panel, BorderLayout.WEST);
    }
    
    /**
     * place to select what type of coffee you want. Separation makes sure that people know where each type of product is, as well as making it
     * easier to see which grouping must have one filled in rather than the optional fields.
     * location where the options are filled in is in the center region
     */
    private void makeCenterRegion() 
    { 
        // area for selecting coffee type
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Select Coffee (Enter Quantity)"));
        panel.setPreferredSize(new Dimension(250,170)); //center region size (x, y)
        
        //option to buy an espresso
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        espressoText = new JTextField("",2);
        espressoText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(espressoText);
        smallPanel.add(new JLabel(" Espresso")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        //option to buy a black coffee
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        blackText = new JTextField("",2);
        blackText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(blackText);
        smallPanel.add(new JLabel(" Black")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        contentPane.add(panel, BorderLayout.CENTER);
    }
   
    /**
     * options for additives to your coffee, they are non-mandatory fields, and so are separated from the rest.
     * location where the information is inserted is in the east region
     */
    private void makeEastRegion() 
    { 
        //options for additives
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Additions (Enter Quantity)"));
        panel.setPreferredSize(new Dimension(170,170)); //east region size (x, y)
                
        //adds milk additive option
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        milkText = new JTextField("",2);
        milkText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(milkText);
        smallPanel.add(new JLabel(" Milk")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        //adds vanilla additive option
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        vanillaText = new JTextField("", 2);
        vanillaText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(vanillaText);
        smallPanel.add(new JLabel(" Vanilla")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        //adds sugar additive option
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        sugarText = new JTextField("", 2);
        sugarText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(sugarText);
        smallPanel.add(new JLabel(" Sugar")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
        
        //adds cream additive option
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        creamText = new JTextField("", 2);
        creamText.setMaximumSize(new Dimension(20,24)); //button size
        smallPanel.add(creamText);
        smallPanel.add(new JLabel(" Cream")); //button name
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel); //adds button to region
 
        contentPane.add(panel, BorderLayout.EAST);
    }
   
    /**
     * imported Java class that allows the user to perform and action and have that action recorded by the program and react accordingly
     */
    private class ExitListener implements ActionListener 
    { 
         //method to close program fully with the press of the exit button located in the upper right-hand corner using the window style relevant to the OS
         //uses the exit method that connects to system
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
    /**
     * imported Java class that allows the user to perform and action and have that action recorded by the program and react accordingly
     */
    private class NewListener implements ActionListener 
    { 
        //resets all of the order fields at once to allow the user to easily make a new order after the previous one.
        public void actionPerformed(ActionEvent e)
        {
            depositText.setText("");
            espressoText.setText("");
            blackText.setText("");
            milkText.setText("");
            vanillaText.setText("");
            sugarText.setText("");
            creamText.setText("");
        }
    }
    
    private class SaveListener implements ActionListener 
    //prints the reciept, and saves the order in it. it allows the user to know what their order was and how much is costs, as well as completing the order itself.
    {
        public void actionPerformed(ActionEvent ae)
        {
            String order = "Coffee Order\r\r\n" + "===========\r\n" + "Coffee:\r\n"; //opens order with this message
            double currentBal = 0; //overall balance variable, which allows all of the different factors that effect cost to add together more easily.
            double dep = 0; //variable for money paid
            int esp = 0; //variable for amount of espresso's
            int bl = 0; //variable for amount of black coffee
            int mi = 0; //variable for amount of milk
            int va = 0; //variable for amount of vanilla
            int su = 0; //variable for amount of sugar
            int cr = 0; //variable for amount of cream
            try //checks if a field is not empty, is there is something in it, it takes the value as an integer and factors that into money remaining.
            //this is neccessary because it is how the program uses the order that the user gives, and it allows the program to do its job.
            {
               if (!espressoText.getText().isEmpty())
                  esp = Integer.parseInt(espressoText.getText());
                  currentBal = currentBal - (esp*2); //$2.00 per espresso
               if (!blackText.getText().isEmpty())
                  bl = Integer.parseInt(blackText.getText());
                  currentBal = currentBal - (bl*2); //$2.00 per black
               if (!milkText.getText().isEmpty())
                  mi = Integer.parseInt(milkText.getText());
                  currentBal = currentBal - (mi*0.1); //$0.10 per milk
               if (!vanillaText.getText().isEmpty())
                  va = Integer.parseInt(vanillaText.getText());
                  currentBal = currentBal - (va*0.1); //$0.10 per vanilla
               if (!sugarText.getText().isEmpty())
                  su = Integer.parseInt(sugarText.getText());
                  currentBal = currentBal - (su*0.1); //$0.10 per sugar
               if (!creamText.getText().isEmpty())
                  cr = Integer.parseInt(creamText.getText());
                  currentBal = currentBal - (cr*0.1); //$0.10 per cream
               if (!depositText.getText().isEmpty())
                  dep = Integer.parseInt(depositText.getText());
                  currentBal = currentBal + dep; //adds the money the user paid to total
            }
            
            catch (NumberFormatException nfe) //checks if the user is putting something the system doesnt recognize.
            //if the user is doing something wrong, the program will tell them what to do.
            //allows the program to run smoothly and work properly regardless of what the user does.
            // Makes sure that the user isn't an idiot!!!
            {
               JOptionPane.showMessageDialog(frame, 
                  "Order numbers must be numeric,\r\n" +
                   "and must be whole numbers", 
                  "Order Error", 
                  JOptionPane.ERROR_MESSAGE);
            }
            String.format("%.2g%n", currentBal); //rounds number in payment variable to 2 decimals, so that it works in cents, not in random numbers.
            //allows the program to use cents in its payments at all, because without it, it would no longer be a value that can be showed as money.
            if (esp > 0 || bl > 0) //checks if either coffee field is greater than 0, to see if someone ordered one.
            {
               order += "Coffee Type:\r\n"; //coffee type section of order
               if (esp > 0)
                  order += "     " + esp + " Espresso\r\n"; //if there is an order of espresso's, adds that to reciept
               if (bl > 0)
                  order += "     " + bl + " Black\r\n"; //if there is an order of black, adds that to reciept
            } else { //makes sure that the user is actually buying a coffee, and didnt just buy additives or just deposit money.
                //makes sure that the program works as it is meant too.
                JOptionPane.showMessageDialog(frame, 
                "You must select a coffee type!",
                "Coffee Type Error", 
                JOptionPane.ERROR_MESSAGE);
            }
            if (esp < 0 || bl < 0 || mi < 0 || va < 0 || su < 0 || cr < 0) //makes sure people don't order in negatives
            {
                JOptionPane.showMessageDialog(frame,
                "You cannot order a negative amount!",
                "Order Amount Error",
                JOptionPane.ERROR_MESSAGE);
            }
            if (mi > 0 || va > 0 || su > 0 || cr > 0) //checks if the user put additives in the coffee
            {
               order += "Additives:\r\n"; //states that the reciept is moving to the additives
               if (mi > 0)
                  order += "     " + mi + " Milk\r\n"; //if there is an order of milk, adds that to reciept
               if (va > 0)
                  order += "     " + va + " Vanilla\r\n"; //if there is an order of vanilla, adds that to reciept
               if (su > 0)
                  order += "     " + su + " Sugar\r\n"; //if there is an order of sugar, adds that to reciept
               if (cr > 0)
                  order += "     " + cr + " Cream\r\n"; //if there is an order of cream, adds that to reciept
            }  
               order += "Your balance remaining is\r\n" + "$" + currentBal + "\r\n"; //prints final balance after order, so the user knows
               //either what they will get as change or what they still have to pay
               if (currentBal < 0) {
                   order+= "Please pay $" + (currentBal * -1) + " more"; //lets the user know how much more they have to pay, if they didnt put enough originally.
                   //stops the program from being scammed.
               }
               order += "\r\n***END OF ORDER ***\r\n";
               
            try
            {
               PrintStream oFile = new PrintStream("C:\\Users\\jblei\\OneDrive\\Documents\\ICS4U\\Unit 2\\CoffeeOrder.txt"); //prints reciept to file
               oFile.print(order);
               oFile.close();
            }
            catch(IOException ioe)
            {
               System.out.println("\r\n*** I/O Error ***\r\n" + ioe); //makes sure the order prints to the right file path, if nothing happens, an effor message comes up.
            }
        }
    }    
}