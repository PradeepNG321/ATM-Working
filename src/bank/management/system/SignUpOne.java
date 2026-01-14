package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SignUpOne extends JFrame {

    SignUpOne(){
        Random ran=new Random();
        long random= (Math.abs((ran.nextLong()%9000L)+1000));
        setLayout(null);


        JLabel formNo= new JLabel("APPLICATION FORM NO. " +random);
        formNo.setFont(new Font("Raelway", Font.BOLD, 38));
        formNo.setBounds(140,20, 600,40);
        add(formNo);




        JLabel personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raelway", Font.BOLD, 22));
        personalDetails.setBounds(290,80, 800,40);
        add(personalDetails);

        JLabel name =new JLabel("Name: ");
        name.setFont(new Font("Raelway", Font.BOLD, 20));
        name.setBounds(100, 140,100,30);
        add(name);

        JTextField nametextField = new JTextField();
        nametextField.setFont(new Font("Raelway", Font.BOLD, 14));
        nametextField.setBounds(300, 140,400, 30);
        add(nametextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raelway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        JTextField faternametextField = new JTextField();
        faternametextField.setFont(new Font("Raelway", Font.BOLD, 14));
        faternametextField.setBounds(300, 190,400, 30);
        add(faternametextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raelway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        JLabel gender = new JLabel("Date of Birth: ");
        gender.setFont(new Font("Raelway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);


        JLabel email = new JLabel("email address");
        email.setFont(new Font("Raelway", Font.BOLD,20));
        email.setBounds(100,340,100,30);
        add(email);

        JTextField emailtextField = new JTextField();
        emailtextField.setFont(new Font("Raelway", Font.BOLD, 14));
        emailtextField.setBounds(300, 340,400, 30);
        add(emailtextField);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raelway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raelway", Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);

        JTextField addresstextField = new JTextField();
        addresstextField.setFont(new Font("Raelway", Font.BOLD, 14));
        addresstextField.setBounds(300, 440,400, 30);
        add(addresstextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raelway", Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);

        JTextField citytextField = new JTextField();
        citytextField.setFont(new Font("Raelway", Font.BOLD, 14));
        citytextField.setBounds(300, 490,400, 30);
        add(citytextField);

        JLabel staste = new JLabel("State: ");
        staste.setFont(new Font("Raelway", Font.BOLD,20));
        staste.setBounds(100,540,100,30);
        add(staste);

        JTextField statetextField = new JTextField();
        statetextField.setFont(new Font("Raelway", Font.BOLD, 14));
        statetextField.setBounds(300, 540,400, 30);
        add(statetextField);

        JLabel pincode = new JLabel("Pin code: ");
        pincode.setFont(new Font("Raelway", Font.BOLD,20));
        pincode.setBounds(100,590,100,30);
        add(pincode);

        JTextField dpincodetextField = new JTextField();
        dpincodetextField.setFont(new Font("Raelway", Font.BOLD, 14));
        dpincodetextField.setBounds(300, 590,400, 30);
        add(dpincodetextField);





        getContentPane().setBackground(SystemColor.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
