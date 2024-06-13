import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbsemester;

    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfsub6,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5,tfmarks6;
    JButton submit, cancel;

    Marks(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of student ");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lbrollno = new JLabel("Select Roll Number");
        lbrollno.setBounds(50,70,150,25);
        add(lbrollno);

        crollno= new Choice();
        crollno.setBounds(200,70,150,25);
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

        JLabel lbsemester = new JLabel("Select Semester");
        lbsemester.setBounds(50,110,150,25);
        add(lbsemester);
        String semester[]={"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};
        cbsemester= new JComboBox(semester);
        cbsemester.setBounds(200,110,150,25);
        cbsemester.setBackground(Color.white);
        add(cbsemester);

        JLabel lblsubject= new JLabel("Enter Subject");
        lblsubject.setBounds(100,155,100,40);
        add(lblsubject);

        JLabel lbmarks= new JLabel(" Enter Marks");
        lbmarks.setBounds(320,155,100,40);
        add(lbmarks);


        tfsub1= new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);

        tfsub2= new JTextField();
        tfsub2.setBounds(50,225,200,20);
        add(tfsub2);

        tfsub3= new JTextField();
        tfsub3.setBounds(50,250,200,20);
        add(tfsub3);

        tfsub4= new JTextField();
        tfsub4.setBounds(50,275,200,20);
        add(tfsub4);

        tfsub5= new JTextField();
        tfsub5.setBounds(50,300,200,20);
        add(tfsub5);

        tfsub6= new JTextField();
        tfsub6.setBounds(50,325,200,20);
        add(tfsub6);

        tfmarks1= new JTextField();
        tfmarks1.setBounds(255,200,200,20);
        add(tfmarks1);

        tfmarks2= new JTextField();
        tfmarks2.setBounds(255,225,200,20);
        add(tfmarks2);

        tfmarks3= new JTextField();
        tfmarks3.setBounds(255,250,200,20);
        add(tfmarks3);

        tfmarks4= new JTextField();
        tfmarks4.setBounds(255,275,200,20);
        add(tfmarks4);

        tfmarks5= new JTextField();
        tfmarks5.setBounds(255,300,200,20);
        add(tfmarks5);

        tfmarks6= new JTextField();
        tfmarks6.setBounds(255,325,200,20);
        add(tfmarks6);



        submit= new JButton("SUBMIT");
        submit.setBounds(100,385,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("CANCEL");
        cancel.setBounds(285,385,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            if (    (tfsub1.getText().isEmpty() && !tfmarks1.getText().isEmpty()) ||
                    (!tfsub1.getText().isEmpty() && tfmarks1.getText().isEmpty()) ||
                    (tfsub2.getText().isEmpty() && !tfmarks2.getText().isEmpty()) ||
                    (!tfsub2.getText().isEmpty() && tfmarks2.getText().isEmpty()) ||
                    (tfsub3.getText().isEmpty() && !tfmarks3.getText().isEmpty()) ||
                    (!tfsub3.getText().isEmpty() && tfmarks3.getText().isEmpty()) ||
                    (tfsub4.getText().isEmpty() && !tfmarks4.getText().isEmpty()) ||
                    (!tfsub4.getText().isEmpty() && tfmarks4.getText().isEmpty()) ||
                    (tfsub5.getText().isEmpty() && !tfmarks5.getText().isEmpty()) ||
                    (!tfsub5.getText().isEmpty() && tfmarks5.getText().isEmpty()) ||
                    (tfsub6.getText().isEmpty() && !tfmarks6.getText().isEmpty()) ||
                    (!tfsub6.getText().isEmpty() && tfmarks6.getText().isEmpty())
            ) {

                JOptionPane.showMessageDialog(null, "Please enter all subjects and marks.");
            }else {
                try {
                    Conn c = new Conn();
                    String query1 = "insert into subject values('" + crollno.getSelectedItem() + "','" + cbsemester.getSelectedItem() + "','" + tfsub1.getText() + "','" + tfsub2.getText() + "','" + tfsub3.getText() + "','" + tfsub4.getText() + "','" + tfsub5.getText() + "','" + tfsub6.getText() + "')";
                    String query2 = "insert into marks values('" + crollno.getSelectedItem() + "','" + cbsemester.getSelectedItem() + "','" + tfmarks1.getText() + "','" + tfmarks2.getText() + "','" + tfmarks3.getText() + "','" + tfmarks4.getText() + "','" + tfmarks5.getText() + "','" + tfmarks6.getText() + "')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            setVisible(false);
        }
    }

    public  static  void main(String args[]){
         new Marks();

    }
}
