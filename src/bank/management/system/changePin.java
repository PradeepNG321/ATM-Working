package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Struct;

public class changePin extends JFrame implements ActionListener {

    JTextField pinArea,rpinArea;
    JButton change,back;
    String piin;
    changePin(String pinchange){
        this.piin=pinchange;


        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("CHANGE THE PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(240,280,200,18);
        image.add(text);

        JLabel pintext= new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setBounds(165,320,120,18);
        image.add(pintext);

        pinArea= new JTextField();
        pinArea.setFont(new Font("System", Font.BOLD,14));
        pinArea.setBounds(370,320,100,20);
        pinArea.setBackground(Color.WHITE);
        image.add(pinArea);

        JLabel rEpintext = new JLabel("ENTER PIN AGAIN");
        rEpintext.setForeground(Color.WHITE);
        rEpintext.setFont(new Font("System", Font.BOLD, 14));
        rEpintext.setBounds(165,360,200,18);
        image.add(rEpintext);

        rpinArea = new JTextField();
        rpinArea.setFont(new Font("System", Font.BOLD,14));
        rpinArea.setBounds(370,360,100,20);
        rpinArea.setBackground(Color.WHITE);
        image.add(rpinArea);

        change= new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new changePin("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==change){
        try {
            String npin= pinArea.getText();
            String repin= rpinArea.getText();

            if (!npin.equals(repin)){
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
            if (npin.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                return;
            }
            if (repin.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please re-Enter new PIN");
                return;
            }

            Conn conn = new Conn();
            String query1= "update bank set Pin= '"+repin+"' where Pin='"+piin+"'";
            String query2= "update login set Pin= '"+repin+"' where Pin='"+piin+"'";
            String query3= "update signupthree set Pin= '"+repin+"' where Pin='"+piin+"'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN change Successfully");

            setVisible(false);
            new Transactions(repin).setVisible(true);


        }

        catch (Exception ae){
            System.out.println(ae);
        }

     }
        else {
            setVisible(false);
            new Transactions(piin).setVisible(true);

        }
    }
}
