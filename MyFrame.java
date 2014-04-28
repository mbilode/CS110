import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    //create fields:
    private JButton button;
    private JLabel pic;
    private ImageIcon frontCard;
    private ImageIcon backCard;
   
    MyFrame(String s) {
        super(s);
        
        setLayout(new FlowLayout());
        button = new JButton("Deal");
        button.addActionListener(new ButtonListener());
        add(button);

        frontCard = new ImageIcon("CHOOSE AN IMAGE");
        backCard = new ImageIcon("CHOOSE AN IMAGE");
        
        pic = new JLabel(frontCard);
        add(pic);
    }

    class ButtonListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            pic.setIcon(backCard);
        }
    }
}