package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String piin;
    Deposit(String pinn){
        this.piin= pinn;
        setLayout(null);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);

        JLabel text= new JLabel("Enter the amount want to deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,20);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount= new JTextField();
        amount.setBounds(170,350,330,25);
        amount.setFont(new Font("Raleway", Font.BOLD, 17));
        image.add(amount);

        deposit= new JButton("Deposit");
        deposit.setBounds(355, 485, 150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back= new JButton("Back");
        back.setBounds(355, 520, 150,30);
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(500,0);
        setVisible(true);





    }



    public static void main(String[] args) {
        new Deposit("");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deposit){
            String number= amount.getText();
            Date date = new Date();
        } else if (e.getSource()==back) {
            setVisible(false);
            new Transactions(piin).setVisible(true);
        }
    }
}
