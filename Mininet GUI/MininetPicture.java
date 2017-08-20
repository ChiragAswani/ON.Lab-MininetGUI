import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Write a description of class MininetPicture here.
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 17, 2013
 */
public class MininetPicture extends JPanel
{
    MininetGui gui;
    /**
     * Constructor for objects of class MininetPicture
     */
    public MininetPicture(MininetGui guiGiven)
    {
        gui = guiGiven;
    }

    /**
     * Draws the hosts and the switches
     * 
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        super.paintComponent(g2);
        super.paintComponent(g3);
        setBackground(Color.white);
        g2.setColor(Color.blue);
        g3.setColor(Color.blue);

        Font f = new Font("Serif", Font.BOLD, 12);
        g2.setFont(f);
        g3.setFont(f);
        ArrayList<Host> hosts = gui.getHosts();
        int index = 0;
        for (int i = 0; i < hosts.size(); i++)
        {
            if (i >= 40 && i%40 == 0)
            {
                index = 0;
                g2.setColor(Color.green);
            }
            g2.drawString(hosts.get(i).getName() ,(index+1)*30, 50 + 50*(i/40));
            index++;
        }
        ArrayList<Switch> switches = gui.getSwitches();
        index = 0;
        for (int a = 0; a < switches.size(); a++)
        {
            if (a >= 40 && a % 40 == 0)
            {
                index = 0;
                g3.setColor(Color.green);
            }
            g3.drawString(switches.get(a).getName(), (index+1)*30, 500 - 50*(a/40));
            index++;
        }
    }
}
