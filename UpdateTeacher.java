
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame  implements ActionListener {
    JTextField tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelEmpid;
    Choice cEmpid;
    JButton update,cancel;
    UpdateTeacher(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lbrollno = new JLabel("Select Employee Id");
        lbrollno.setBounds(50,100,200,20);
        lbrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lbrollno);

        cEmpid= new Choice();
        cEmpid.setBounds(250,100,200,20);
        add(cEmpid);

        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");// database se sare value lega
            while(rs.next()){// agr rs me value aya to ...
                cEmpid.add(rs.getString("emp_id"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);

        JLabel labelname= new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        JLabel lbFname = new JLabel(" Father's Name");
        lbFname.setBounds(400,150,150,30);
        lbFname.setFont(new Font("serif",Font.BOLD,20));
        add(lbFname);

        JLabel labelfname= new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Employee Id");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelEmpid = new JLabel();
        labelEmpid.setBounds(200,200,200,30);
        labelEmpid.setFont(new Font("serif",Font.BOLD,20));
        add(labelEmpid);

        JLabel lbdob = new JLabel("Date of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);

        JLabel labeldob= new JLabel();
        labeldob.setBounds(600,200,200,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);

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

        JLabel labelX= new JLabel();
        labelX.setBounds(600,300,200,30);
        labelX.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelX);

        JLabel lbXII = new JLabel("Class XII (%)");
        lbXII.setBounds(50,350,150,30);
        lbXII.setFont(new Font("serif",Font.BOLD,20));
        add(lbXII);

        JLabel labelXII= new JLabel();
        labelXII.setBounds(200,350,150,30);
        labelXII.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelXII);

        JLabel lbadhar = new JLabel(" Addhar Number");
        lbadhar.setBounds(400,350,150,30);
        lbadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbadhar);

        JLabel labeladhar= new JLabel();
        labeladhar.setBounds(600,350,200,30);
        labeladhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeladhar);

        JLabel lbcourse= new JLabel("Qualification");
        lbcourse.setBounds(50,400,150,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse);


        tfcourse= new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);

        JLabel lbbranch= new JLabel("Department ");
        lbbranch.setBounds(400,400,150,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);


        tfbranch= new JTextField();
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);
        try{
            Conn c= new Conn();
            String query="select * from teacher where emp_id='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelX.setText(rs.getString("class_x"));
                labelXII.setText(rs.getString("class_xii"));
                labeladhar.setText(rs.getString("adhar"));
                tfcourse.setText(rs.getString("qualification"));
                tfbranch.setText(rs.getString("department"));
                labelEmpid.setText(rs.getString("emp_id"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c= new Conn();
                    String query="select * from teacher where emp_id='"+cEmpid.getSelectedItem()+"'";
                    ResultSet rs= c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelX.setText(rs.getString("class_x"));
                        labelXII.setText(rs.getString("class_xii"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                        labelEmpid.setText(rs.getString("emp_id"));

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        update = new JButton("UPDATE");
        update.setBounds(300,550,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setFont(new Font("serif",Font.BOLD,16));
        add(update);

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
        if(ae.getSource()==update){
            String empid= labelEmpid.getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String course= tfcourse.getText();
            String branch= tfbranch.getText();

            try{
                String query= "update teacher set address='"+address+"', phone='"+phone+"', email='"+email+"',qualification='"+course+"',department='"+branch+"' where emp_id='"+empid+"'";
                Conn c= new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Updated Successfully");
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new UpdateTeacher();
    }
}


