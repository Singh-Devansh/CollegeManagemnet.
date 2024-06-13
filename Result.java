import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class Result extends JFrame implements ActionListener {
    String rollno;
    JButton cancel;
    Result(String rollno){
        this.rollno=rollno;
        setSize(500,600);
        setLocation(500,150);

        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading= new JLabel("IKG Punjab Technical University");
        heading.setBounds(100,15,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel subheading= new JLabel("Result of Exmaination");
        subheading.setBounds(150,50,500,30);
        subheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(subheading);

        JLabel lblrollno= new JLabel("Roll Number = "+rollno);
        lblrollno.setBounds(60,100,500,30);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        JLabel lblsemester= new JLabel("");
        lblsemester.setBounds(60,130,500,30);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1= new JLabel("");
        sub1.setBounds(100,200,500,30);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);

        JLabel sub2= new JLabel("");
        sub2.setBounds(100,235,500,30);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3= new JLabel("");
        sub3.setBounds(100,270,500,30);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4= new JLabel("");
        sub4.setBounds(100,305,500,30);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5= new JLabel("");
        sub5.setBounds(100,340,500,30);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);


        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs.next()){
                sub1.setText(rs.getString("subject1"));
                sub2.setText(rs.getString("subject2"));
                sub3.setText(rs.getString("subject3"));
                sub4.setText(rs.getString("subject4"));
                sub5.setText(rs.getString("subject5"));

            }
            ResultSet rs2= c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+"---------"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"---------"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"---------"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"---------"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"---------"+rs2.getString("marks5"));
                lblsemester.setText("semester = "+rs2.getString("semester"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cancel= new JButton("BACK");
        cancel.setBounds(250,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public  static void main(String args[]){
        new Result("");
    }
}
