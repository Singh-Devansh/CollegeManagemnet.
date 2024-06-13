import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
     Choice crollno;
     JTextField tfcourse,tfbranch;
     JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton submit,pay,back;
    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/fee.jpeg"));
        Image i2=i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lbrollno = new JLabel("Select Roll Number");
        lbrollno.setBounds(50,50,150,20);
        lbrollno.setFont(new Font("Serif",Font.BOLD,16));
        add(lbrollno);

        crollno= new Choice();
        crollno.setBounds(200,50,150,20);
        crollno.setBackground(Color.white);
        add(crollno);

        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");// database se sare value lega
            while(rs.next()){// agr rs me value aya to ...
                crollno.add(rs.getString("rollno"));//crollno me rollno show karega
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50,100,100,20);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);

        JLabel labelname= new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);

        JLabel lbFname = new JLabel("Father's Name");
        lbFname.setBounds(50,130,150,20);
        lbFname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbFname);

        JLabel labelfname= new JLabel();
        labelfname.setBounds(200,130,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);

        JLabel lbcourse= new JLabel("Course ");
        lbcourse.setBounds(50,160,150,20);
        lbcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbcourse);

        String course[]= {"BTech","BBA","BCA","MCA","MBA","B.ED","B.Pharma","M.Pharma","B.Com","BA"};
        cbcourse= new JComboBox(course);
        cbcourse.setBounds(200,160,150,20);
        cbcourse.setBackground(Color.white);
        add(cbcourse);

        JLabel lbbranch= new JLabel("Branch ");
        lbbranch.setBounds(50,190,150,20);
        lbbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbbranch);


        String branch[]= {"CSE","ECE","MECH.","CIVIL","IT","HONS.","MBA","B.ED","B.PHARMA","M.PHARMA","B.COM","BA"};
        cbbranch= new JComboBox(branch);
        cbbranch.setBounds(200,190,150,20);
        cbbranch.setBackground(Color.white);
        add(cbbranch);

        JLabel lbsemester = new JLabel("Select Semester");
        lbsemester.setBounds(50,220,150,20);
        lbsemester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbsemester);

        String semester[]={"semester1 ","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsemester= new JComboBox(semester);
        cbsemester.setBounds(200,220,150,20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);

        JLabel lbltotal= new JLabel("Total Payable");
        lbltotal.setBounds(50,250,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200,250,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labeltotal);

        submit = new JButton("SUBMT");
        submit.setBounds(50,400,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);

        pay = new JButton("PAY");
        pay.setBounds(200,400,100,30);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        pay.setFont(new Font("serif",Font.BOLD,16));
        add(pay);

        back = new JButton("BACK");
        back.setBounds(350,400,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(new Font("serif",Font.BOLD,16));
        add(back);


        try{
            Conn c= new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c= new Conn();
                    String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs= c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));


                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String course= (String)cbcourse.getSelectedItem();
            String Semester= (String)cbsemester.getSelectedItem();
            try{
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(Semester));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollno= crollno.getSelectedItem();
            String course= (String)cbcourse.getSelectedItem();
            String semester= (String)cbsemester.getSelectedItem();
            String branch= (String) cbbranch.getSelectedItem();
            String total= labeltotal.getText();

            try{
                Conn c= new Conn();
                String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }


    public static void main(String args[]){
        new StudentFeeForm();
    }
}
