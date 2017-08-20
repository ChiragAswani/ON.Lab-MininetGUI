import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.IOException;
import java.util.ArrayList;
/**
 * MininetGui will show the user their custom topology on Mininet
 * 
 * @author Chirag Aswani and Ryan Pachauri
 * @version June 17, 2013
 */
public class MininetGui
{
    ArrayList<Host> hosts;
    ArrayList<Switch> switches;
    ArrayList<Link> links;
    JFrame frame;
    JPanel buttons;
    MininetPicture picture;

    /**
     * Constructor for objects of class MininetGui
     */
    public MininetGui()
    {
        hosts = new ArrayList<Host>();
        switches = new ArrayList<Switch>();
        links = new ArrayList<Link>();
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndShowGUI();
                }
            });
        // wait until the display has been drawn
        try
        {
            while(frame == null || !frame.isVisible())
                Thread.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Create the GUI and show it.
     * For thread safety, this method should be invoked
     * from the event-dispatching thread
     * 
     */
    public void createAndShowGUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1279,720);
        frame.setLocation(0, 0);

        picture = new MininetPicture(this);
        frame.add(picture, BorderLayout.CENTER);

        createButtons();
        frame.add(buttons, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    /**
     * Creates a JPanel of all the buttons that we need
     * 
     * @return  JPanel of buttons that will be placed on the right
     */
    public void createButtons()
    {
        buttons = new JPanel();

        JButton addHost = createAddHost();
        buttons.add(addHost);
        JButton removeHost = createRemoveHost();
        buttons.add(removeHost);
        JButton addSwitch = createAddSwitch();
        buttons.add(addSwitch);
        JButton removeSwitch = createRemoveSwitch();
        buttons.add(removeSwitch);
    }

    /**
     * Creates a JButton so that the user can add a host
     * 
     */
    public JButton createAddHost()
    {
        JButton addHost = new JButton("Add host");

        addHost.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    addHost();
                    picture.repaint();
                }
            });
        return addHost;
    }

    /**
     * Creates a JButton so that the user can remove a host
     * 
     */
    public JButton createRemoveHost()
    {
        final JTextField removeHostNumber = new JTextField("Type Host to Remove");
        removeHostNumber.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    if (removeHostNumber.getText().equals("Type Host to Remove"))
                    {
                        removeHostNumber.setText("");
                        removeHostNumber.repaint();
                        removeHostNumber.revalidate();
                    }
                }
            });
        buttons.add(removeHostNumber);

        JButton removeHost = new JButton("Remove host");
        removeHost.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    removeHost(removeHostNumber.getText());
                    picture.repaint();
                }
            });
        return removeHost;
    }
    
    public JButton createAddSwitch()
    {
        JButton addSwitch = new JButton("Add switch");

        addSwitch.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    addSwitch();
                    picture.repaint();
                }
            });
        return addSwitch;
    }
    
    /**
     * Creates a JButton so that the user can remove a host
     * 
     */
    public JButton createRemoveSwitch()
    {
        final JTextField removeSwitchNumber = new JTextField("Type Switch to Remove");
        removeSwitchNumber.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    if (removeSwitchNumber.getText().equals("Type Switch to Remove"))
                    {
                        removeSwitchNumber.setText("");
                        removeSwitchNumber.repaint();
                        removeSwitchNumber.revalidate();
                    }
                }
            });
        buttons.add(removeSwitchNumber);

        JButton removeSwitch = new JButton("Remove switch");
        removeSwitch.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    removeSwitch(removeSwitchNumber.getText());
                    picture.repaint();
                }
            });
        return removeSwitch;
    }

    public JButton createExport()
    {
        JButton export = new JButton("Export");

        export.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                }
            });
        return export;
    }

    /**
     * Gets the private instance variable hosts
     * 
     */
    public ArrayList<Host> getHosts()
    {
        return hosts;
    }

    /**
     * Gets the private instance variable switches
     * 
     */
    public ArrayList<Switch> getSwitches()
    {
        return switches;
    }

    /**
     * Gets the private instance variable links
     * 
     */
    public ArrayList<Link> getLinks()
    {
        return links;
    }

    /**
     * Adds a host to the ArrayList of class Host, the private instance variable hosts
     * 
     */
    public void addHost()
    {
        hosts.add(new Host(hosts.size() + 1));
    }

    public void removeHost(String id)
    {
        try
        {
            int idNo = Integer.parseInt(id);
            boolean removed = false;
            for (int i = 0; i < hosts.size(); i++)
            {
                if (i == idNo && !removed)
                {
                    hosts.remove(i);
                    removed = true;
                }
            }
            renameHosts(idNo);
        }
        catch (NumberFormatException e)
        {

        }
    }

    public void renameHosts(int id)
    {
        for (int i = id; i < hosts.size(); i++)
        {
            hosts.set(i, new Host(i + 1));
        }
    }
    
    public void addSwitch()
    {
        switches.add(new Switch(switches.size() + 1));
    }
    
    public void removeSwitch(String id)
    {
        try
        {
            int idNo = Integer.parseInt(id);
            boolean removed = false;
            for (int i = 0; i < switches.size(); i++)
            {
                if (i == idNo && !removed)
                {
                    switches.remove(i);
                    removed = true;
                }
            }
            renameSwitches(idNo);
        }
        catch (NumberFormatException e)
        {

        }
    }
    
    public void renameSwitches(int id)
    {
        for (int i = id; i < switches.size(); i++)
        {
            switches.set(i, new Switch(i + 1));
        }
    }
    
    public static void main(String [] args)
    {
        MininetGui mininet = new MininetGui();
    }
    
    


}
