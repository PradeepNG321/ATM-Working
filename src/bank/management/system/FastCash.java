package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton hundred,fivehundred, thousand, twothousand, fivethousand, tenthoudand, back;
    String piin;

    FastCash(String pin){

        setLayout(null);
        this.piin= pin;


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Select Withdrawl Amount");
        text.setBounds(225,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        hundred= new JButton("Rs 100");
        hundred.setBounds(170, 415,150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 415,150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 450,150, 30);
        thousand.addActionListener(this);
        image.add(thousand);

        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450,150, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);

        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 485,150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);

        tenthoudand = new JButton("Rs 10000");
        tenthoudand.setBounds(355, 485,150, 30);
        tenthoudand.addActionListener(this);
        image.add(tenthoudand);

        back = new JButton("Back ");
        back.setBounds(355, 520,150, 30);
        back.addActionListener(this);
        image.add(back);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public static void main(String[] args) {

        new FastCash("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
            new Transactions(piin).setVisible(true);
        } else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c= new Conn();
            try {
                ResultSet rs= c.s.executeQuery("Select * from bank where Pin= '"+piin+"'");
                int balance= 0;
                while(rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date= new Date();
                String query = "insert into bank values ('"+piin+"', '"+date+"', 'withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+ " Debited Successfully");
                setVisible(false);
                new Transactions(piin).setVisible(true);
            } catch (Exception ae){
                System.out.println(ae);
            }

        }

    }
}
