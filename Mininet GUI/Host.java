/**
 * Host is something for Mininet that we will use to add/remove hosts
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 17, 2013
 */
public class Host extends Place
{

    /**
     * Constructor for objects of class Host
     * 
     * @param   id  the id number we are giving to the host
     */
    public Host(int id)
    {
        super(id);
    }

    /**
     * Creates a name for the instance of this host
     * 
     * @param   id  the id number we are giving to the host
     * @param   String  the name of the host
     */
    public String makeName(int id)
    {
        return "h" + String.valueOf(id);
    }
}
