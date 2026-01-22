package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener {

    JLabel pageTitle,religion, category,income,eduQua, occupation, panNo, aadhar,senorcitizen, existingacc;
    JComboBox religionDropDown,categorychoice, incomeChoice,educLevel, occupationType;
    JTextField PANtextField, adhartextField;
    JRadioButton above60,below, oldaccount, notold;
    ButtonGroup SeniorOrNot, oldcust;
    String formno;


    JButton next;

    SignUpTwo(String formNo){
        this.formno=formNo;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION: PAGE 2");

        pageTitle = new JLabel("Page 2: Additional Details ");
        pageTitle.setFont(new Font("Raelway", Font.BOLD, 38));
        pageTitle.setBounds(200,30, 600,50);
        add(pageTitle);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raelway", Font.BOLD,20));
        religion.setBounds(100,100,100,30);
        add(religion);

        String[] religionChoice = {"Hindu", "Muslim", "Sikh", "Christrian", "Other"};
        religionDropDown= new JComboBox(religionChoice);
        religionDropDown.setBounds(300, 100,400, 30);
        add(religionDropDown);


        category = new JLabel("Category: ");
        category.setFont(new Font("Raelway", Font.BOLD,20));
        category.setBounds(100,150,100,30);
        add(category);

        String[] jatichoice = {"General", "OBC", "SC/ST", "EWS"};
        categorychoice = new JComboBox(jatichoice);
        categorychoice.setBounds(300, 150,400, 30);
        add(categorychoice);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raelway", Font.BOLD,20));
        income.setBounds(100,200,100,30);
        add(income);

        String aaycategory[]= {"<100000", "100001-300000", "300001-500000", ">500000"};
        incomeChoice = new JComboBox(aaycategory);
        incomeChoice.setBounds(300, 200,400, 30);
        add(incomeChoice);


        eduQua = new JLabel("Educational: ");
        eduQua.setFont(new Font("Raelway", Font.BOLD,20));
        eduQua.setBounds(100,250,200,30);
        add(eduQua);

        String padhailevel[]= {"High School", "Intermediate", "Under Graduate", "Graduated", "Post Graduated"};
        educLevel = new JComboBox(padhailevel);
        educLevel.setBounds(300, 250,400, 30);
        add(educLevel);

        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raelway", Font.BOLD,20));
        occupation.setBounds(100,300,150,30);
        add(occupation);

        String paisaSource[]= {"Salaried", "Business", "Unemployeement", "Kisan", "Chori", "Dakaiti"};
        occupationType = new JComboBox(paisaSource);
        occupationType.setBounds(300, 300,400, 30);
        add(occupationType);

        panNo = new JLabel("PAN Number: ");
        panNo.setFont(new Font("Raelway", Font.BOLD,20));
        panNo.setBounds(100,350,200,30);
        add(panNo);

        PANtextField = new JTextField();
        PANtextField.setFont(new Font("Raelway", Font.BOLD, 14));
        PANtextField.setBounds(300, 350,400, 30);
        add(PANtextField);

        aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raelway", Font.BOLD,20));
        aadhar.setBounds(100,400,200,30);
        add(aadhar);

        adhartextField = new JTextField();
        adhartextField.setFont(new Font("Raelway", Font.BOLD, 14));
        adhartextField.setBounds(300, 400,400, 30);
        add(adhartextField);

        senorcitizen = new JLabel("Senior Citizen: ");
        senorcitizen.setFont(new Font("Raelway", Font.BOLD,20));
        senorcitizen.setBounds(100,450,200,30);
        add(senorcitizen);

         above60= new JRadioButton("Yes");
        above60.setBounds(300,450, 100, 30);
        above60.setBackground(Color.WHITE);
        add(above60);

        below = new JRadioButton("No");
        below.setBounds(450,450, 100, 30);
        below.setBackground(Color.WHITE);
        add(below);

        SeniorOrNot= new ButtonGroup();
        SeniorOrNot.add(above60);
        SeniorOrNot.add(below);

        existingacc = new JLabel("Existing Account: ");
        existingacc.setFont(new Font("Raelway", Font.BOLD,20));
        existingacc.setBounds(100,500,200,30);
        add(existingacc);

        oldaccount = new JRadioButton("Yes");
        oldaccount.setBounds(300,500, 100, 30);
        oldaccount.setBackground(Color.WHITE);
        add(oldaccount);

        notold = new JRadioButton("No");
        notold.setBounds(450,500, 100, 30);
        notold.setBackground(Color.WHITE);
        add(notold);

        oldcust = new ButtonGroup();
        oldcust.add(oldaccount);
        oldcust.add(oldaccount);



        next = new JButton("Next");
        next.setBounds(610,540, 90,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(450, 150);
        setVisible(true);


    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        String sreligion= (String) religionDropDown.getSelectedItem() ;
        String scategory= (String) categorychoice.getSelectedItem() ;
        String sincome= (String) incomeChoice.getSelectedItem() ;
        String seducation= (String) educLevel.getSelectedItem() ;
        String soccupation= (String) occupationType.getSelectedItem() ;


        String seniorcitizen= null;
        if (above60.isSelected()){
            seniorcitizen= "Yes";
        }
        else{
            seniorcitizen="No";
        }
        String existingAccount=null;
        if (oldaccount.isSelected()){
            existingAccount="Yes";
        }
        else {
            existingAccount= "No";
        }

        String span= PANtextField.getText();
        String sAadharNo= adhartextField.getText();

        try {
            Conn c= new Conn();
            String query2= "insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"', '"+span+"', '"+sAadharNo+"','"+seniorcitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query2);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        }
        catch (Exception e2){
            System.out.println(e2);
        }
    }
}
