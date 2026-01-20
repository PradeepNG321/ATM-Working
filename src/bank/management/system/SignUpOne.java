package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {


    long random;
    JTextField nametextField, faternametextField, emailtextField, addresstextField, citytextField,  statetextField, dpincodetextField;
    JButton next;
    JRadioButton single,married, female,male;
    JDateChooser dateChooser;


    SignUpOne(){
        Random ran=new Random();
        random= (Math.abs((ran.nextLong()%9000L)+1000));
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

        nametextField = new JTextField();
        nametextField.setFont(new Font("Raelway", Font.BOLD, 14));
        nametextField.setBounds(300, 140,400, 30);
        add(nametextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raelway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        faternametextField = new JTextField();
        faternametextField.setFont(new Font("Raelway", Font.BOLD, 14));
        faternametextField.setBounds(300, 190,400, 30);
        add(faternametextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raelway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser= new JDateChooser();
        dateChooser.setFont(new Font("Raelway",Font.BOLD,14 ));
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raelway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(440,290,90,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("email address");
        email.setFont(new Font("Raelway", Font.BOLD,20));
        email.setBounds(100,340,100,30);
        add(email);

        emailtextField = new JTextField();
        emailtextField.setFont(new Font("Raelway", Font.BOLD, 14));
        emailtextField.setBounds(300, 340,400, 30);
        add(emailtextField);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raelway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(440,390,120,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalbutton= new ButtonGroup();
        maritalbutton.add(married);
        maritalbutton.add(single);


        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raelway", Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);

        addresstextField = new JTextField();
        addresstextField.setFont(new Font("Raelway", Font.BOLD, 14));
        addresstextField.setBounds(300, 440,400, 30);
        add(addresstextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raelway", Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);

        citytextField = new JTextField();
        citytextField.setFont(new Font("Raelway", Font.BOLD, 14));
        citytextField.setBounds(300, 490,400, 30);
        add(citytextField);

        JLabel staste = new JLabel("State: ");
        staste.setFont(new Font("Raelway", Font.BOLD,20));
        staste.setBounds(100,540,100,30);
        add(staste);

        statetextField = new JTextField();
        statetextField.setFont(new Font("Raelway", Font.BOLD, 14));
        statetextField.setBounds(300, 540,400, 30);
        add(statetextField);

        JLabel pincode = new JLabel("Pin code: ");
        pincode.setFont(new Font("Raelway", Font.BOLD,20));
        pincode.setBounds(100,590,100,30);
        add(pincode);

        dpincodetextField = new JTextField();
        dpincodetextField.setFont(new Font("Raelway", Font.BOLD, 14));
        dpincodetextField.setBounds(300, 590,400, 30);
        add(dpincodetextField);

        next = new JButton("Next");
        next.setBounds(610,640, 90,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);





        getContentPane().setBackground(SystemColor.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno= ""+ random;
        String name= nametextField.getText();
        String fname= faternametextField.getText();
        String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if ((male.isSelected())){
            gender="Male";
        }
        else {
            gender="female";
        }
        String email= emailtextField.getText();
        String marital= null;
        if (single.isSelected()){
            marital="Single";
        }else {
            marital="married";
        }
        String address= addresstextField.getText();
        String city= citytextField.getText();
        String state= statetextField.getText();
        String pin= dpincodetextField.getText();

        try {
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else {
                Conn c= new Conn();
                String query= "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"' )";
                c.s.executeUpdate(query);
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }

        setVisible(false); //after clicking next, the page get close.



    }
}
