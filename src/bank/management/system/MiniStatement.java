package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MiniStatement extends JFrame implements ActionListener {
    String pim;
    MiniStatement(String piin){
        this.pim=piin;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        setSize(900,900);
        setLocation(500,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
