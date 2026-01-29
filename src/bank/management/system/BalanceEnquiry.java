package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    JLabel text;
    String pin;

    public BalanceEnquiry(String piin) {

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back= new JButton("BACK");
        back.setBounds(355,495,150,30);
        back.addActionListener(this);
        image.add(back);


        int balance= 0;
        Conn c= new Conn();
        try {
            ResultSet rs= c.s.executeQuery("Select * from bank where Pin= '"+piin+"'");

            while(rs.next()){
                if (rs.getString("type").equals("deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                } else {
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }} catch (Exception e){
            System.out.println(e);
        }

        text= new JLabel("Your Current Balance is:   "+balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        image.add(text);







        this.pin= piin;
        setSize(900,900);
        setLocation(500,0);
        setVisible(true);
    }

    public static void main(String[] args) {
         new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
}
