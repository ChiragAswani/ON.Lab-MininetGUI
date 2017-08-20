/**
 * Link makes a connection between a host to a switch, and a switch to a switch
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 18, 2013
 */
public class Link
{
    private Place place1;
    private Place place2;
    
    /**
     * Constructor for the class Link
     * 
     * Creates a Link between a given host and switch
     * 
     */
    public Link(Host hostName, Switch switchName)
    {
        place1 = hostName;
        place2 = switchName;
    }
    
    /**
     * Constructor for the class LInk
     * 
     * Creates a Link between two switches
     */
    public Link(Switch switch1, Switch switch2)
    {
        place1 = switch1;
        place2 = switch2;
    }
    
    /**
     * Gets the name of the private instance variable place1
     * 
     */
    public String place1Name()
    {
        if (place1 instanceof Host)
        {
            return ((Host)place1).getName();
        }
        return ((Switch)place1).getName();
    }
    
    /**
     * Gets the name of the privae instance variable place2
     */
    public String place2Name()
    {
        return ((Switch)place1).getName();
    }
}
