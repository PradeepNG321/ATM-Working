package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pim;
    MiniStatement(String piin){
        this.pim=piin;
        setLayout(null);
        setTitle("MINISTATEMENT");

//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
//        JLabel image= new JLabel(i3);
//        image.setBounds(0,0,900,900);
//        add(image);

        JLabel mini =  new JLabel();
        add(mini);

        JLabel bank= new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where Pin='"+pim+"'");
            while (rs.next()){
                card.setText("Card Number:  \t "+rs.getString("Card_No").substring(0,4)+ "XXXXXXXX"+ rs.getString("Card_No").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn conn= new Conn();
            int bal=0;
            ResultSet rs= conn.s.executeQuery("select * from bank where Pin= '"+pim+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br> <html>");
                if (rs.getString("type").equals("deposit")){
                    bal+= Integer.parseInt(rs.getString("amount"));
                } else {
                    bal-= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current balance is Rs " +bal);
        }catch (Exception e1){
            System.out.println(e1);
        }

        mini.setBounds(20,140,400,200);




        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
