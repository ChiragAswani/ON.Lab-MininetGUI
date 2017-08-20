
/**
 * Place is something that takes in a number and saves it as its place
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 18, 2013
 */
public class Place
{
    private String name;

    /**
     * Constructor for objects of class Place
     */
    public Place(int id)
    {
        name = makeName(id);
    }
    
    /**
     * Gets the private instance variable name
     * 
     */
    public String getName()
    {
         return name;
    }
    
    /**
     * Sets the private instance variable name
     * 
     */
    public void setName(int id)
    {
        name = makeName(id);
    }
    
    /**
     * Creates a name for the instance of this host
     * 
     * @param   id  the id number we are giving to the host
     * @param   String  the name of the host
     */
    public String makeName(int id)
    {
        return String.valueOf(id);
    }
}
