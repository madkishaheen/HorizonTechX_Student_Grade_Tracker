import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

public class StudentGrade extends JFrame {

    private JTextField nameField;
    private JTextField idField;
    private JTextField mathematicsField;
    private JTextField scienceField;
    private JTextField englishField;
    private JTextField javaField;
    private JTextArea resultArea;

    public StudentGrade() {

        this.setTitle("Horizon TechX - Student Grade Tracker");
        this.setSize(850, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.createGUI();
    }

    private void createGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // ================= HEADER =================

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(35, 65, 100));
        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JLabel titleLabel = new JLabel("STUDENT GRADE TRACKER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel(
                "Horizon TechX | Academic Performance Management System"
        );
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        // ================= INPUT FIELDS =================

        JPanel formPanel = new JPanel(
                new GridLayout(6, 2, 12, 12)
        );

        formPanel.setBackground(new Color(245, 247, 250));

        formPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 60, 10, 60)
        );

        // Student Name
        JLabel nameLabel = new JLabel("Student Name:");
        this.nameField = new JTextField();

        // Prevent numbers and special characters in Student Name
        ((AbstractDocument) this.nameField.getDocument())
                .setDocumentFilter(new DocumentFilter() {

                    @Override
                    public void insertString(
                            FilterBypass fb,
                            int offset,
                            String string,
                            AttributeSet attr)
                            throws javax.swing.text.BadLocationException {

                        if (string != null && string.matches("[a-zA-Z ]+")) {
                            fb.insertString(offset, string, attr);
                        }
                    }

                    @Override
                    public void replace(
                            FilterBypass fb,
                            int offset,
                            int length,
                            String text,
                            AttributeSet attrs)
                            throws javax.swing.text.BadLocationException {

                        String currentText =
                                fb.getDocument().getText(
                                        0,
                                        fb.getDocument().getLength()
                                );

                        String newText =
                                currentText.substring(0, offset)
                                + (text == null ? "" : text)
                                + currentText.substring(offset + length);

                        if (newText.matches("[a-zA-Z ]*")) {
                            fb.replace(offset, length, text, attrs);
                        }
                    }
                });

        // Student ID
        JLabel idLabel = new JLabel("Student ID:");
        this.idField = new JTextField();

        // Mathematics
        JLabel mathematicsLabel = new JLabel("Mathematics:");
        this.mathematicsField = new JTextField();

        // Science
        JLabel scienceLabel = new JLabel("Science:");
        this.scienceField = new JTextField();

        // English
        JLabel englishLabel = new JLabel("English:");
        this.englishField = new JTextField();

        // Java
        JLabel javaLabel = new JLabel("Java:");
        this.javaField = new JTextField();

        // Add fields
        formPanel.add(nameLabel);
        formPanel.add(this.nameField);

        formPanel.add(idLabel);
        formPanel.add(this.idField);

        formPanel.add(mathematicsLabel);
        formPanel.add(this.mathematicsField);

        formPanel.add(scienceLabel);
        formPanel.add(this.scienceField);

        formPanel.add(englishLabel);
        formPanel.add(this.englishField);

        formPanel.add(javaLabel);
        formPanel.add(this.javaField);

        // ================= BUTTONS =================

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 247, 250));

        JButton calculateButton = new JButton("Calculate Grade");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        calculateButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        exitButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        calculateButton.setFocusPainted(false);
        clearButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // ================= RESULT AREA =================

        this.resultArea = new JTextArea();

        this.resultArea.setEditable(false);

        this.resultArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        this.resultArea.setLineWrap(true);
        this.resultArea.setWrapStyleWord(true);

        this.resultArea.setText(
                "                  RESULT SUMMARY\n"
                + "====================================================\n"
                + "Enter student details and marks, then click\n"
                + "'Calculate Grade' to generate the report."
        );

        JScrollPane scrollPane =
                new JScrollPane(this.resultArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Detailed Summary Report"
                )
        );

        scrollPane.setPreferredSize(
                new Dimension(700, 260)
        );

        // ================= CENTER PANEL =================

        JPanel centerPanel =
                new JPanel(new BorderLayout());

        centerPanel.setBackground(
                new Color(245, 247, 250)
        );

        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        // ================= BUTTON ACTIONS =================

        calculateButton.addActionListener(
                e -> this.calculateGrade()
        );

        clearButton.addActionListener(
                e -> this.clearFields()
        );

        exitButton.addActionListener(
                e -> this.exitApplication()
        );

        // ================= MAIN PANEL =================

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        this.add(mainPanel);
    }

    // =====================================================
    // CALCULATE GRADE
    // =====================================================

    private void calculateGrade() {

        String name = this.nameField.getText().trim();
        String studentId = this.idField.getText().trim();

        // Check Student Name
        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Student Name.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Extra validation for Student Name
        if (!name.matches("[a-zA-Z ]+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student Name should contain only letters and spaces.",
                    "Invalid Name",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Check Student ID
        if (studentId.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Student ID.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            // Read marks
            double mathematics =
                    Double.parseDouble(
                            this.mathematicsField
                                    .getText()
                                    .trim()
                    );

            double science =
                    Double.parseDouble(
                            this.scienceField
                                    .getText()
                                    .trim()
                    );

            double english =
                    Double.parseDouble(
                            this.englishField
                                    .getText()
                                    .trim()
                    );

            double java =
                    Double.parseDouble(
                            this.javaField
                                    .getText()
                                    .trim()
                    );

            // Validate marks
            if (!this.validMarks(mathematics)
                    || !this.validMarks(science)
                    || !this.validMarks(english)
                    || !this.validMarks(java)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Each mark must be between 0 and 100.",
                        "Invalid Marks",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Subjects
            ArrayList<String> subjects =
                    new ArrayList<>();

            subjects.add("Mathematics");
            subjects.add("Science");
            subjects.add("English");
            subjects.add("Java");

            // Marks
            ArrayList<Double> marks =
                    new ArrayList<>();

            marks.add(mathematics);
            marks.add(science);
            marks.add(english);
            marks.add(java);

            // Create Student object
            Student student =
                    new Student(
                            name,
                            studentId,
                            subjects,
                            marks
                    );

            // Get results
            double totalMarks =
                    student.getTotalMarks();

            double average =
                    student.getAverage();

            double highestScore =
                    student.getHighestScore();

            double lowestScore =
                    student.getLowestScore();

            String grade =
                    student.getGrade();

            String performance =
                    student.getPerformanceMessage();

            // ================= REPORT =================

            StringBuilder report =
                    new StringBuilder();

            report.append(
                    "====================================================\n"
            );

            report.append(
                    "              STUDENT SUMMARY REPORT\n"
            );

            report.append(
                    "====================================================\n\n"
            );

            report.append("Student Name : ");
            report.append(student.getName());
            report.append("\n");

            report.append("Student ID   : ");
            report.append(student.getStudentId());
            report.append("\n\n");

            report.append(
                    "---------------- SUBJECT MARKS ----------------\n"
            );

            for (int i = 0;
                    i < subjects.size();
                    i++) {

                report.append(
                        String.format(
                                "%-15s : %.2f / 100%n",
                                subjects.get(i),
                                marks.get(i)
                        )
                );
            }

            report.append(
                    "\n---------------- PERFORMANCE -----------------\n"
            );

            report.append(
                    String.format(
                            "Total Marks  : %.2f / 400%n",
                            totalMarks
                    )
            );

            report.append(
                    String.format(
                            "Average      : %.2f%%%n",
                            average
                    )
            );

            report.append(
                    String.format(
                            "Highest Score: %.2f%n",
                            highestScore
                    )
            );

            report.append(
                    String.format(
                            "Lowest Score : %.2f%n",
                            lowestScore
                    )
            );

            report.append("Grade        : ");
            report.append(grade);
            report.append("\n");

            report.append("Performance  : ");
            report.append(performance);
            report.append("\n\n");

            report.append(
                    "====================================================\n"
            );

            report.append(
                    "          End of Student Grade Report\n"
            );

            report.append(
                    "===================================================="
            );

            // Display report
            this.resultArea.setText(
                    report.toString()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Grade calculated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric marks for all subjects.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // VALIDATE MARKS
    // =====================================================

    private boolean validMarks(double mark) {

        return mark >= 0 && mark <= 100;
    }

    // =====================================================
    // CLEAR
    // =====================================================

    private void clearFields() {

        this.nameField.setText("");
        this.idField.setText("");
        this.mathematicsField.setText("");
        this.scienceField.setText("");
        this.englishField.setText("");
        this.javaField.setText("");

        this.resultArea.setText(
                "                  RESULT SUMMARY\n"
                + "====================================================\n"
                + "Enter student details and marks, then click\n"
                + "'Calculate Grade' to generate the report."
        );
    }

    // =====================================================
    // EXIT
    // =====================================================

    private void exitApplication() {

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to exit?",
                        "Exit Student Grade Tracker",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentGrade application =
                    new StudentGrade();

            application.setVisible(true);
        });
    }
}