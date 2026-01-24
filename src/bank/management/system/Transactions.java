package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw, fastcash, ministatement, pinchange, blnceenquiry, exit;
    String piin;

        Transactions(String pin){

            setLayout(null);
            this.piin= pin;


            ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);

            JLabel text= new JLabel("Please select your Transaction");
            text.setBounds(225,300,700,35);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD, 16));
            image.add(text);

            deposit= new JButton("Deposit");
            deposit.setBounds(170, 415,150, 30);
            deposit.addActionListener(this);
            image.add(deposit);

            withdraw = new JButton("Cash Withdrawl");
            withdraw.setBounds(355, 415,150, 30);
            withdraw.addActionListener(this);
            image.add(withdraw);

            fastcash = new JButton("Deposit");
            fastcash.setBounds(170, 450,150, 30);
            fastcash.addActionListener(this);
            image.add(fastcash);

            ministatement = new JButton("Ministatement");
            ministatement.setBounds(355, 450,150, 30);
            ministatement.addActionListener(this);
            image.add(ministatement);

            pinchange = new JButton("Pin Change");
            pinchange.setBounds(170, 485,150, 30);
            pinchange.addActionListener(this);
            image.add(pinchange);

            blnceenquiry = new JButton("Balance Enquiry");
            blnceenquiry.setBounds(355, 485,150, 30);
            blnceenquiry.addActionListener(this);
            image.add(blnceenquiry);

            exit = new JButton("Exit");
            exit.setBounds(355, 520,150, 30);
            exit.addActionListener(this);
            image.add(exit);






            setSize(900,900);
            setLocation(300,0);
            setUndecorated(true);
            setVisible(true);


        }
    public static void main(String[] args) {

        new Transactions("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            System.exit(0);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(piin).setVisible(true);
        }

    }
}
