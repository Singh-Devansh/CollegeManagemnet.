import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice cempid;
    JTable table;// table banane ke lea use hota h
    JButton search, print, update,add,cancel;

    TeacherLeaveDetails(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search by Emp_Id");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid= new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");// database se sare value lega
            while(rs.next()){// agr rs me value aya to ...
                cempid.add(rs.getString("emp_id"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        table= new JTable();

        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherLeave");// database se sare value lega
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            System.out.println(e);
        }

        JScrollPane jsp= new JScrollPane(table);// scroll lane ke ea isko use karte h
        jsp.setBounds(0,100,900,600);
        add(jsp);


        search= new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print= new JButton("Print");
        print.setBounds(130,70,80,20);
        print.addActionListener(this);
        add(print);


        cancel= new JButton("Cancel");
        cancel.setBounds(250,70,80,20);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== search){

            String query= "select * from teacherLeave where empid = '"+cempid.getSelectedItem()+"'";
            try{
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new TeacherLeaveDetails();
    }
}
