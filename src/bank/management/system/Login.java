package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, sign_up, clear;
    JTextField  cardTExtField;
    JPasswordField pinTextPin;
    Login(){
        setTitle("Automatic Teller Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel level= new JLabel(i3);
        level.setBounds(30,20,100,100);
        add(level);

        getContentPane().setBackground(Color.WHITE);

        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 16));
        cardno.setBounds(100,160, 100, 40);
        add(cardno);

        cardTExtField= new JTextField();
        cardTExtField.setBounds(220, 165 ,260, 30);
        cardTExtField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTExtField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100,200, 100, 40);
        add(pin);

        pinTextPin= new JPasswordField();
        pinTextPin.setBounds(220, 205, 260, 30);
        pinTextPin.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextPin);


        login= new JButton("SIGN IN");
        login.setBounds(300, 300, 80,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear= new JButton("Clear");
        clear.setBounds(400, 300, 80,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(300, 350, 180,30);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.addActionListener(this);
        add(sign_up);
        //380                      480
        //340                      440
        //350                      430
        setSize(800,480);
        setVisible(true);
        setLocation(600,300);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            pinTextPin.setText("");
            cardTExtField.setText("");
        } else if (ae.getSource()==login) {
            Conn conn= new Conn();
            String cardnumber= cardTExtField.getText();
            String pin= pinTextPin.getText();
            String query= "select * from login where Card_No= '"+cardnumber+"' and Pin= '"+pin+"'";
            try {
                ResultSet rs= conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the correct card number and pin");
                }
            } catch (Exception e){
                System.out.println(e);
            }


        }
        else{
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();

    }


}
