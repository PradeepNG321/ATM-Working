package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JLabel title,accountType,card,cardNumber, description, cardPin, urCardPin, password, services;
    JRadioButton savingAccount, fixDepAcc , currAcc, recurringDEpAcc, atmcard, internetBanking, mobBAnking,email_sms, checkbook ,eStatement ,  declaration;
    ButtonGroup accType, servicess;
    JButton submit, cancel;
    String formno;

    public SignUpThree(String formno) {
        this.formno=formno;
        title= new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raelway", Font.BOLD, 20));
        title.setBounds(300, 30, 250, 30);
        add(title);

        accountType= new JLabel("Account Type");
        accountType.setFont(new Font("Raelway", Font.BOLD, 20));
        accountType.setBounds(100, 100, 200, 30);
        add(accountType);

        savingAccount= new JRadioButton("Saving Account");
        savingAccount.setBounds(110,140, 200,20);
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setForeground(Color.black);
        add(savingAccount);

        fixDepAcc = new JRadioButton("Fixed Deposit Account");
        fixDepAcc.setBounds(400,140, 200,20);
        fixDepAcc.setBackground(Color.WHITE);
        fixDepAcc.setForeground(Color.black);
        add(fixDepAcc);

        currAcc = new JRadioButton("Current Account");
        currAcc.setBounds(110,170, 200,20);
        currAcc.setBackground(Color.WHITE);
        currAcc.setForeground(Color.black);
        add(currAcc);

        recurringDEpAcc = new JRadioButton("Recurring Deposit Account");
        recurringDEpAcc.setBounds(400,170, 200,20);
        recurringDEpAcc.setBackground(Color.WHITE);
        recurringDEpAcc.setForeground(Color.black);
        add(recurringDEpAcc);

        accType= new ButtonGroup();
        accType.add(savingAccount);
        accType.add(fixDepAcc);
        accType.add(currAcc);
        accType.add(recurringDEpAcc);


        card = new JLabel("Card Number");
        card.setFont(new Font("Raelway", Font.BOLD, 20));
        card.setBounds(100, 250, 200, 30);
        add(card);

        cardNumber = new JLabel("XXXX-XXXX-XXXX-5542");
        cardNumber.setFont(new Font("Raelway", Font.BOLD, 20));
        cardNumber.setBounds(370, 250, 300, 30);
        add(cardNumber);

        description = new JLabel("Your 16 digit card number");
        description.setFont(new Font("Raelway", Font.BOLD, 10));
        description.setBounds(105, 270, 200, 20);
        add(description);


        cardPin = new JLabel("PIN");
        cardPin.setFont(new Font("Raelway", Font.BOLD, 20));
        cardPin.setBounds(100, 300, 200, 30);
        add(cardPin);

        urCardPin = new JLabel("XXXX");
        urCardPin.setFont(new Font("Raelway", Font.BOLD, 20));
        urCardPin.setBounds(370, 300, 300, 30);
        add(urCardPin);

        password = new JLabel("Your 4 Digit Password");
        password.setFont(new Font("Raelway", Font.BOLD, 10));
        password.setBounds(105, 320, 300, 20);
        add(password);

        services = new JLabel("Services Required: ");
        services.setFont(new Font("Raelway", Font.BOLD, 20));
        services.setBounds(100, 420, 250, 30);
        add(services);

        atmcard = new JRadioButton("ATM CARD");
        atmcard.setBounds(120,460, 150,20);
        atmcard.setBackground(Color.WHITE);
        atmcard.setForeground(Color.black);
        add(atmcard);

        internetBanking = new JRadioButton("Internet Banking");
        internetBanking.setBounds(420,460, 150,20);
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setForeground(Color.black);
        add(internetBanking);

        mobBAnking = new JRadioButton("Mobile Banking");
        mobBAnking.setBounds(120,490, 150,20);
        mobBAnking.setBackground(Color.WHITE);
        mobBAnking.setForeground(Color.black);
        add(mobBAnking);

        email_sms = new JRadioButton("Email & SMS Alert");
        email_sms.setBounds(420,490, 150,20);
        email_sms.setBackground(Color.WHITE);
        email_sms.setForeground(Color.black);
        add(email_sms);

        checkbook = new JRadioButton("Cheque Book");
        checkbook.setBounds(120,520, 150,20);
        checkbook.setBackground(Color.WHITE);
        checkbook.setForeground(Color.black);
        add(checkbook);

        eStatement = new JRadioButton("E-Statement");
        eStatement.setBounds(420,520, 150,20);
        eStatement.setBackground(Color.WHITE);
        eStatement.setForeground(Color.black);
        add(eStatement);

        servicess= new ButtonGroup();
        servicess.add(atmcard);
        servicess.add(internetBanking);
        servicess.add(mobBAnking);
        servicess.add(email_sms);
        servicess.add(checkbook);
        servicess.add(eStatement);


        declaration = new JRadioButton("I hearby declare that the above entered details are correct to the best of my knowledge");
        declaration.setBounds(110,600, 530,15);
        declaration.setFont(new Font("Raelway", Font.BOLD, 10));
        declaration.setBackground(Color.WHITE);
        declaration.setForeground(Color.black);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBounds(280,620, 90,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(430,620, 90,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setLayout(null);
        setSize(850, 800);
        setLocation(450, 150);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION PAGE: 3");


    }

    public static void main(String[] args) {
        new SignUpThree("");
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit)
        {
            String accounttype=null;
            if (savingAccount.isSelected()){
                accounttype= "Saving Account";
            } else if (fixDepAcc.isSelected()) {
                accounttype= "Fixed Deposit Account";
            }else if (currAcc.isSelected()) {
                accounttype= "Current Account";
            }else if (recurringDEpAcc.isSelected()) {
                accounttype= "Recurring Deposit Account";
            }

            Random random=new Random();
            String cardnumber= ""+Math.abs(random.nextLong()%90000000L+5468570000000000L);
            String pin=""+Math.abs(random.nextInt()%9000+1000);

            String facility= "";
            if (atmcard.isSelected()){
                facility=facility+ " ATM Card";
            } else if (internetBanking.isSelected()) {
                facility=facility+ " Internet Banking";
            } else if (mobBAnking.isSelected()) {
                facility=facility+ " Mobile Banking";
            } else if (email_sms.isSelected()) {
                facility=facility+ " Email and SMS";
            } else if (checkbook.isSelected()) {
                facility=facility+ " Cheqe Book";
            } else if (eStatement.isSelected()) {
                facility=facility+ " E- Statement";
            }

            try {
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Plzz, choose any one account type");
                }
                else {
                    Conn conn= new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pin+"','"+facility+"')";
                    conn.s.executeUpdate(query1);

                    String query2= "insert into login values ('"+formno+"','"+cardnumber+"', '"+pin+"')";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card number is: "+cardnumber+ "\n Pin: "+pin);
                    setVisible(false);


                }
            }
            catch (Exception e3){
                System.out.println(e3);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }

    }
}
