package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdrew, back;
    JTextField amount;
    String piin;
    Withdrawl(String pinn){
        this.piin= pinn;
        setLayout(null);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);

        JLabel text= new JLabel("Enter the amount want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,20);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount= new JTextField();
        amount.setBounds(170,350,330,25);
        amount.setFont(new Font("Raleway", Font.BOLD, 17));
        image.add(amount);

        withdrew= new JButton("Withdraw");
        withdrew.setBounds(355, 485, 150,30);
        withdrew.addActionListener(this);
        image.add(withdrew);

        back= new JButton("Back");
        back.setBounds(355, 520, 150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(500,0);
        setVisible(true);

    }



    public static void main(String[] args) {
        new Withdrawl("");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==withdrew){
            String number= amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the amount you want to deposit");
            } else {
                Conn conn= new Conn();
                String query= "insert into bank values('"+piin+"','"+date+"', 'withdrew', '"+number+"')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +number+ " withdraw Successfully");
                    setVisible(false);
                    new Transactions(piin).setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);                }
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Transactions(piin).setVisible(true);
        }
    }
}

