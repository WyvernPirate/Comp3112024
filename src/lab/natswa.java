
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class natswa {
    public static void main(String[] args) {
        // Create the frame
        JFrame j = new JFrame("Our window");

        // Create the components
        JLabel t = new JLabel("Registry");
        JLabel n = new JLabel("Name");
        JLabel p = new JLabel("players");
        JLabel v = new JLabel("Value");

        JTextField nt = new JTextField(20);
        JTextField pt = new JTextField(20);
        JTextField vt = new JTextField(20);

        JButton b = new JButton("Save");

        // Create the panels
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        // set the size
        j.setSize(800, 500);

        // add components to panel
        north.add(t);
        center.add(n);
        center.add(nt);
        center.add(p);
        center.add(pt);
        center.add(v);
        center.add(vt);

        // add panels to the frame
        j.add(north, BorderLayout.NORTH);
        j.add(center, BorderLayout.CENTER);
        j.add(south, BorderLayout.SOUTH);

        // make the button do things
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nt.getText();
                int num = Integer.parseInt(pt.getText())
                double value = Double.parseDouble(vt.getText());
            }
        });    

        // set the frame visible
        j.setVisible(true);
    }

}
