import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of class MininetWriter here.
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 17, 2013
 */
public class MininetWriter
{
    MininetGui gui;
    FileWriter fw;
    int space;
    /**
     * Constructor for objects of class MininetWriter
     */
    public MininetWriter(MininetGui guiGiven) throws IOException
    {
        space = 0;
        gui = guiGiven;
        String userHomeFolder = System.getProperty("user.home");
        File textFile = new File(userHomeFolder, "MyCustomTopology.py");

        fw = new FileWriter(textFile);
        fw.write("from mininet.topo import Topo\n");
        fw.write("\n");
        fw.write("class MyTopo( Topo ):\n");
        fw.write("\n");
        fw.write("    def __init__( self ):\n");
        fw.write("\n");
        fw.write("       Topo.__init__( self )\n");
        fw.write("\n");
        addHosts();
        //Add hosts here 
        //Add switches here 
        fw.write("\n");
        fw.write("\n");
        fw.write("topos = { 'mytopo': ( lambda: MyTopo() ) }\n");
        fw.flush();
    }

    public void makeSpace() throws IOException
    {
        for (int i = 0; i < space; i++)
        {
            fw.write(" ");
        }
    }
    
    public void addHosts() throws IOException
    {
        ArrayList<Host> hosts = gui.getHosts();
        for (int i = 0; i < hosts.size(); i++)
        {
            fw.write("        " + hosts.get(i).getName() + " =  self.addHost('" + hosts.get(i).getName() + "')\n");
        }
    }
}
