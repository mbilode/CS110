import javax.swing.*;

public class WarDriver
{

    public static void main(String[] args) 
    {
        
        JFrame frame = new WarGUI("Card Game of War!");
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000,500);
        frame.validate();
        frame.setVisible(true);
    }
}