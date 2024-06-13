import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    StudentLeave(){
        setSize(500,550);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lbrollno= new JLabel("Search by Roll Number");
        lbrollno.setBounds(60,100,200,20);
        lbrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbrollno);

        crollno= new Choice();
        crollno.setBounds(60,130,200,20);
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

        JLabel lbdate= new JLabel("Date");
        lbdate.setBounds(60,170,200,20);
        lbdate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbdate);

        dcdate= new JDateChooser();
        dcdate.setBounds(60,200,200,25);
        add(dcdate);

        JLabel lbtime= new JLabel("Time Duration");
        lbtime.setBounds(60,250,200,20);
        lbtime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbtime);

        ctime= new Choice();
        ctime.setBounds(60,280,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);


        submit = new JButton("SUBMT");
        submit.setBounds(60,350,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(250,350,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                String rollno= crollno.getSelectedItem();
                String date= ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
                String duration= ctime.getSelectedItem();

                String query= "insert into studentLeave values('"+rollno+"','"+date+"','"+duration+"')";
                try{
                    Conn c= new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Leave Submitted");
                    setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                setVisible(false);
            }
    }

    public static  void  main(String args[]){
        new StudentLeave();
    }
}
