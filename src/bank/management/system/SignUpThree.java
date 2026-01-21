package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpThree extends JFrame implements ActionListener {


    public SignUpThree() {

        JLabel title= new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raelway", Font.BOLD, 20));
        title.setBounds(300, 30, 250, 30);
        add(title);

        JLabel accountType= new JLabel("Account Type");
        accountType.setFont(new Font("Raelway", Font.BOLD, 20));
        accountType.setBounds(100, 100, 200, 30);
        add(accountType);

        JRadioButton savingAccount= new JRadioButton("Saving Account");
        savingAccount.setBounds(110,140, 200,20);
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setForeground(Color.black);
        add(savingAccount);

        JRadioButton fixDepAcc = new JRadioButton("Fixed Deposit Account");
        fixDepAcc.setBounds(400,140, 200,20);
        fixDepAcc.setBackground(Color.WHITE);
        fixDepAcc.setForeground(Color.black);
        add(fixDepAcc);

        JRadioButton currAcc = new JRadioButton("Current Account");
        currAcc.setBounds(110,170, 200,20);
        currAcc.setBackground(Color.WHITE);
        currAcc.setForeground(Color.black);
        add(currAcc);

        JRadioButton recurringDEpAcc = new JRadioButton("Recurring Deposit Account");
        recurringDEpAcc.setBounds(400,170, 200,20);
        recurringDEpAcc.setBackground(Color.WHITE);
        recurringDEpAcc.setForeground(Color.black);
        add(recurringDEpAcc);


        setLayout(null);
        setSize(850, 800);
        setLocation(450, 150);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION PAGE: 3");


    }

    public static void main(String[] args) {
        new SignUpThree();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
