import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{

    Project(){
        setSize(1540,850);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/admin (2).jpg"));
        Image i2=i1.getImage().getScaledInstance(1500,750, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb= new JMenuBar();// to add menus in our layout.

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Apply Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Apply Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //leave details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.red);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //exam
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.blue);
        mb.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.white);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //update information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //fees
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);

        //utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem call = new JMenuItem("Calculator");
        call.setBackground(Color.white);
        call.addActionListener(this);
        utility.add(call);

        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.blue);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand(); // Ensure the correct method name is used

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe"); // Adjust the command to open Calculator
            } catch (Exception e) {

            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("New Faculty Information")) {
            new Addteacher();
        } else if (msg.equals("New Student Information")) {
            new Addstudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Apply Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Apply Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
         new StudentLeaveDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new Marks();
        } else if (msg.equals("Examination Result")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
    }

    public static void main(String args[]){
        new Project();
    }
}
