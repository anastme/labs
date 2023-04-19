import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
public class UserGUI extends JFrame
{
    public UserGUI(RepositoryClass students)
    {
        int studentTypeId = 0;
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("Сессия");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(720, 400);
        mainWindow.setLocationRelativeTo(null);


        JPanel studentsInfoPanel = new JPanel();
        studentsInfoPanel.setSize(300, 500);
        JTextArea studentsInfoLabel = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(studentsInfoLabel);
        scrollPane.setBounds(0,0,20,90);
        studentsInfoPanel.add(studentsInfoLabel);
        studentsInfoPanel.add(scrollPane);


        JPanel inputPanel = new JPanel();
        ButtonGroup studentTypeGroup = new ButtonGroup();
        JRadioButton scholarShipRadioInp = new JRadioButton("Стипендия");
        JRadioButton contractRadioInp = new JRadioButton("Контракт");
        JLabel sessionLbl = new JLabel("Сессия сдана воворемя");
        studentTypeGroup.add(scholarShipRadioInp);
        studentTypeGroup.add(contractRadioInp);
        ButtonGroup sessionGroup = new ButtonGroup();
        JRadioButton sessionTrueInp = new JRadioButton("Да");
        JRadioButton sessionFalseInp = new JRadioButton("Нет");
        JLabel studyCostLbl = new JLabel("Стоимость обучения");
        JTextField studyCostInp = new JTextField(5);
        studyCostLbl.setVisible(false);
        studyCostInp.setVisible(false);
        sessionGroup.add(sessionTrueInp);
        sessionGroup.add(sessionFalseInp);
        JLabel fullNameLbl = new JLabel("ФИО");
        JTextField fullNameInp = new JTextField(5);
        JLabel groupLbl = new JLabel("Группа");
        JTextField groupInp = new JTextField(5);
        JLabel avgMarkLbl = new JLabel("Средний балл");
        JTextField avgMarkInp = new JTextField(5);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Введите номер");
        JTextField studentIdSearch = new JTextField(16);
        JButton editBtn = new JButton("Редактировать");
        JButton delBtn = new JButton("Удалить");
        scholarShipRadioInp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessionLbl.setVisible(true);
                sessionTrueInp.setVisible(true);
                sessionFalseInp.setVisible(true);
                studyCostLbl.setVisible(false);
                studyCostInp.setVisible(false);

            }
        });
        contractRadioInp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessionTrueInp.setEnabled(false);
                sessionFalseInp.setEnabled(false);
                sessionLbl.setVisible(false);
                sessionTrueInp.setVisible(false);
                sessionFalseInp.setVisible(false);
                studyCostLbl.setVisible(true);
                studyCostInp.setVisible(true);
            }
        });
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(studentIdSearch.getText());
                String name = fullNameInp.getText();
                String group = groupInp.getText();
                double avgMark = Double.parseDouble(avgMarkInp.getText());
                if(sessionTrueInp.isSelected() || sessionFalseInp.isSelected() && !contractRadioInp.isSelected()) {
                    students.updateStudentInfo(id,sessionTrueInp.isSelected(), name, group, avgMark, 15);
                } else if(contractRadioInp.isSelected()){
                    double studyCost = Double.parseDouble(studyCostInp.getText());
                    students.updateStudentInfo(id,studyCost, name, group, avgMark,15);
                }
                String studentsInfo = "";
                for (Student student:
                        students.getStudents()) {
                    studentsInfo += student.getStudentInfo() + "\n";
                }
                studentsInfoLabel.setText(studentsInfo);
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(studentIdSearch.getText());
                students.removeStudent(id);
                String studentsInfo = "";
                for (Student student:
                        students.getStudents()) {
                    studentsInfo += student.getStudentInfo() + "\n";
                }
                studentsInfoLabel.setText(studentsInfo);
            }
        });
        JButton addBtn = new JButton("Добавить");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullNameInp.getText();
                String group = groupInp.getText();
                double avgMark = Double.parseDouble(avgMarkInp.getText());
                if(scholarShipRadioInp.isSelected()) {
                    students.addNewStudent(sessionTrueInp.isSelected(), name, group, avgMark, 15);
                } else if(contractRadioInp.isSelected()){
                    double studyCost = Double.parseDouble(studyCostInp.getText());
                    students.addNewStudent(studyCost, name, group, avgMark,15);
                }
                String studentsInfo = "";
                for (Student student:
                        students.getStudents()) {
                    studentsInfo += student.getStudentInfo() + "\n";
                }
                studentsInfoLabel.setText(studentsInfo);
            }
        });

        panel.add(label);
        panel.add(studentIdSearch);
        panel.add(editBtn);
        panel.add(delBtn);
        panel.add(addBtn);
        inputPanel.add(scholarShipRadioInp);
        inputPanel.add(contractRadioInp);
        inputPanel.add(fullNameLbl);
        inputPanel.add(fullNameInp);
        inputPanel.add(groupLbl);
        inputPanel.add(groupInp);
        inputPanel.add(avgMarkLbl);
        inputPanel.add(avgMarkInp);
        inputPanel.add(sessionLbl);
        inputPanel.add(studyCostLbl);
        inputPanel.add(studyCostInp);
        inputPanel.add(sessionTrueInp);
        inputPanel.add(sessionFalseInp);

        mainWindow.add(inputPanel, BorderLayout.NORTH);
        mainWindow.add(studentsInfoPanel, BorderLayout.CENTER);
        mainWindow.add(panel,BorderLayout.SOUTH);
        mainWindow.setVisible(true);
    }
}
