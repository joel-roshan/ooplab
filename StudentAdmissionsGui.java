import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentAdmissionsGui extends JFrame {
    private JTextField admissionNumberField, nameField, ageField, gradeField, departmentField;
    private JTextArea displayArea;
    private Connection connection;

    public StudentAdmissionsGui() {
        // Create components and set up the frame
        setTitle("Student Admission Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        admissionNumberField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        gradeField = new JTextField();
        departmentField = new JTextField();

        JButton admitButton = new JButton("Admit Student");
        JButton searchButton = new JButton("Search");
        JButton removeButton = new JButton("Remove Student");
        JButton updateButton = new JButton("Update Student");
        JButton generateButton = new JButton("Generate Report");

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(new JLabel("Admission Number:"));
        add(admissionNumberField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Grade:"));
        add(gradeField);
        add(new JLabel("Department:"));
        add(departmentField);
        add(admitButton);
        add(searchButton);
        add(removeButton);
        add(updateButton);
        add(generateButton);
        add(scrollPane);

        // Database connection configuration
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Functionality for buttons
        admitButton.addActionListener(e -> admitStudent());
        searchButton.addActionListener(e -> searchStudent());
        removeButton.addActionListener(e -> removeStudent());
        updateButton.addActionListener(e -> updateStudent());
        generateButton.addActionListener(e -> generateReport());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Define methods for button functionalities
    private void admitStudent() {
        String admissionNumber = admissionNumberField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();
        String department = departmentField.getText();

        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO students VALUES ('%s', '%s', %d, '%s', '%s')",
                    admissionNumber, name, age, grade, department);
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Student admitted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchStudent() {
        String searchQuery = JOptionPane.showInputDialog(this, "Enter admission number to search:");
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM students WHERE admission_number = '%s'", searchQuery);
            ResultSet resultSet = statement.executeQuery(query);
            displayArea.setText(""); // Clear previous content
            while (resultSet.next()) {
                // Display student details in the text area
                displayArea.append("Admission Number: " + resultSet.getString("admission_number") + "\n");
                displayArea.append("Name: " + resultSet.getString("name") + "\n");
                displayArea.append("Age: " + resultSet.getInt("age") + "\n");
                displayArea.append("Grade: " + resultSet.getString("grade") + "\n");
                displayArea.append("Department: " + resultSet.getString("department") + "\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void removeStudent() {
        String admissionNumber = admissionNumberField.getText();
        try {
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM students WHERE admission_number = '%s'", admissionNumber);
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student removed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Student with admission number " + admissionNumber + " not found!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateStudent() {
        String admissionNumber = admissionNumberField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();
        String department = departmentField.getText();

        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE students SET name='%s', age=%d, grade='%s', department='%s' WHERE admission_number='%s'",
                    name, age, grade, department, admissionNumber);
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student details updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Student with admission number " + admissionNumber + " not found!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void generateReport() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder report = new StringBuilder("Admission Number,Name,Age,Grade,Department\n");
            while (resultSet.next()) {
                report.append(resultSet.getString("admission_number")).append(",");
                report.append(resultSet.getString("name")).append(",");
                report.append(resultSet.getInt("age")).append(",");
                report.append(resultSet.getString("grade")).append(",");
                report.append(resultSet.getString("department")).append("\n");
            }

            // Saving the report to a CSV file (you can modify this part to save the report)
            JOptionPane.showMessageDialog(this, "CSV report generated:\n" + report.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentAdmissionsGui::new);
    }
}
