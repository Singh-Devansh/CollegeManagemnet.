import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Addstudent extends JFrame  implements ActionListener {
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran= new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);// it will give me random number, upto 4 digit.
    Addstudent(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);
        JLabel heading = new JLabel("New Students Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);

        tfname= new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lbFname = new JLabel(" Father's Name");
        lbFname.setBounds(400,150,150,30);
        lbFname.setFont(new Font("serif",Font.BOLD,20));
        add(lbFname);

        tffname= new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lbrollno = new JLabel("Roll Number");
        lbrollno.setBounds(50,200,200,30);
        lbrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lbrollno);

        labelrollno = new JLabel("1000"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);

        JLabel lbdob = new JLabel("Date of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);

        dcdob= new JDateChooser();
        dcdob.setBounds(600,200,200,30);
        add(dcdob);

        JLabel lbaddress = new JLabel(" Address");
        lbaddress.setBounds(50,250,150,30);
        lbaddress.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddress);

        tfaddress= new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lbphone = new JLabel(" Phone");
        lbphone.setBounds(400,250,150,30);
        lbphone.setFont(new Font("serif",Font.BOLD,20));
        add(lbphone);

        tfphone= new JTextField();
        tfphone.setBounds(600,250,200,30);
        add(tfphone);

        JLabel lbemail = new JLabel(" Email Id");
        lbemail.setBounds(50,300,150,30);
        lbemail.setFont(new Font("serif",Font.BOLD,20));
        add(lbemail);

        tfemail= new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lbX = new JLabel(" Class X (%)");
        lbX.setBounds(400,300,150,30);
        lbX.setFont(new Font("serif",Font.BOLD,20));
        add(lbX);

        tfx= new JTextField();
        tfx.setBounds(600,300,200,30);
        add(tfx);

        JLabel lbXII = new JLabel("Class XII (%)");
        lbXII.setBounds(50,350,150,30);
        lbXII.setFont(new Font("serif",Font.BOLD,20));
        add(lbXII);

        tfxii= new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel lbadhar = new JLabel(" Addhar Number");
        lbadhar.setBounds(400,350,150,30);
        lbadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbadhar);

        tfadhar= new JTextField();
        tfadhar.setBounds(600,350,200,30);
        add(tfadhar);

        JLabel lbcourse= new JLabel("Course ");
        lbcourse.setBounds(50,400,150,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse);

        String course[]= {"B.Tech","BBA","BCA","MCA","MBA","B.ED","B.PHARMA","M.PHARMA","B.COM","BA"};
        cbcourse= new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);

        JLabel lbbranch= new JLabel("Branch ");
        lbbranch.setBounds(400,400,150,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);


        String branch[]= {"CSE","ECE","MECH.","CIVIL","IT","HONS.","MBA","B.ED","B.PHARMA","M.PHARMA","B.COM","BA"};
        cbbranch= new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);


        submit = new JButton("SUBMT");
        submit.setBounds(300,550,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(450,550,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfname.getText();
            String fname= tffname.getText();
            String roll= labelrollno.getText();
            String dob= ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String x= tfx.getText();
            String xii= tfxii.getText();
            String adhar= tfadhar.getText();
            String course= (String) cbcourse.getSelectedItem();
            String branch= (String) cbbranch.getSelectedItem();

            try{
                String query= "insert into student values ('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhar+"','"+course+"','"+branch+"')";
                Conn c= new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Addstudent();
    }
}
