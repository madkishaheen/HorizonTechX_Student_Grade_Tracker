import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentGrade extends JFrame {

    private JTextField nameField;
    private JTextField idField;

    private JTextField mathematicsField;
    private JTextField scienceField;
    private JTextField englishField;
    private JTextField javaField;

    private JTextArea resultArea;

    public StudentGrade() {

        setTitle("Horizon TechX - Student Grade Tracker");

        setSize(850, 700);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();
    }

    // =====================================================
    // CREATE GUI
    // =====================================================

    private void createGUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // =================================================
        // HEADER
        // =================================================

        JPanel header =
                new JPanel();

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        header.setBackground(
                new Color(35, 65, 100)
        );

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );

        JLabel title =
                new JLabel(
                        "STUDENT GRADE TRACKER"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(Color.WHITE);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle =
                new JLabel(
                        "Horizon TechX | Academic Performance Management System"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setForeground(Color.WHITE);

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(5)
        );

        header.add(subtitle);

        // =================================================
        // INPUT PANEL
        // =================================================

        JPanel inputPanel =
                new JPanel(
                        new GridLayout(
                                6,
                                2,
                                12,
                                12
                        )
                );

        inputPanel.setBackground(
                new Color(245, 247, 250)
        );

        inputPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 60, 10, 60
                )
        );

        // Name
        JLabel nameLabel =
                new JLabel("Name:");

        nameField =
                new JTextField();

        // Student ID
        JLabel idLabel =
                new JLabel("Student ID:");

        idField =
                new JTextField();

        // Mathematics
        JLabel mathematicsLabel =
                new JLabel("Mathematics (0-100):");

        mathematicsField =
                new JTextField();

        // Science
        JLabel scienceLabel =
                new JLabel("Science (0-100):");

        scienceField =
                new JTextField();

        // English
        JLabel englishLabel =
                new JLabel("English (0-100):");

        englishField =
                new JTextField();

        // Java
        JLabel javaLabel =
                new JLabel("Java (0-100):");

        javaField =
                new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        inputPanel.add(idLabel);
        inputPanel.add(idField);

        inputPanel.add(mathematicsLabel);
        inputPanel.add(mathematicsField);

        inputPanel.add(scienceLabel);
        inputPanel.add(scienceField);

        inputPanel.add(englishLabel);
        inputPanel.add(englishField);

        inputPanel.add(javaLabel);
        inputPanel.add(javaField);

        // =================================================
        // BUTTON PANEL
        // =================================================

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        JButton calculateButton =
                new JButton(
                        "Calculate Grade"
                );

        JButton clearButton =
                new JButton("Clear");

        JButton exitButton =
                new JButton("Exit");

        calculateButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        clearButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        exitButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        calculateButton.setFocusPainted(false);
        clearButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // =================================================
        // RESULT AREA
        // =================================================

        resultArea =
                new JTextArea();

        resultArea.setEditable(false);

        resultArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        resultArea.setLineWrap(true);

        resultArea.setWrapStyleWord(true);

        resultArea.setText(
                "                  RESULT SUMMARY\n"
                + "====================================================\n"
                + "Enter student details and marks, then click\n"
                + "'Calculate Grade' to generate the report."
        );

        JScrollPane resultScrollPane =
                new JScrollPane(resultArea);

        resultScrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Detailed Summary Report"
                )
        );

        resultScrollPane.setPreferredSize(
                new Dimension(700, 260)
        );

        // =================================================
        // CENTER PANEL
        // =================================================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout()
                );

        centerPanel.setBackground(
                new Color(245, 247, 250)
        );

        centerPanel.add(
                inputPanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                resultScrollPane,
                BorderLayout.SOUTH
        );

        // =================================================
        // BUTTON ACTIONS
        // =================================================

        calculateButton.addActionListener(
                e -> calculateGrade()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        exitButton.addActionListener(
                e -> exitApplication()
        );

        // =================================================
        // ADD PANELS
        // =================================================

        mainPanel.add(
                header,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);
    }

    // =====================================================
    // CALCULATE GRADE
    // =====================================================

    private void calculateGrade() {

        String name =
                nameField.getText().trim();

        String id =
                idField.getText().trim();

        // =================================================
        // NAME VALIDATION
        // =================================================

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name.",
                    "Missing Name",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Name can contain letters and spaces only
        if (!name.matches("[a-zA-Z ]+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name should contain only letters and spaces.",
                    "Invalid Name",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // =================================================
        // STUDENT ID VALIDATION
        // =================================================

        if (id.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Student ID.",
                    "Missing Student ID",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Exactly 10 digits
        if (!id.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID must contain exactly 10 digits.",
                    "Invalid Student ID",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            // =================================================
            // READ MARKS
            // =================================================

            double mathematics =
                    Double.parseDouble(
                            mathematicsField
                                    .getText()
                                    .trim()
                    );

            double science =
                    Double.parseDouble(
                            scienceField
                                    .getText()
                                    .trim()
                    );

            double english =
                    Double.parseDouble(
                            englishField
                                    .getText()
                                    .trim()
                    );

            double java =
                    Double.parseDouble(
                            javaField
                                    .getText()
                                    .trim()
                    );

            // =================================================
            // MARKS VALIDATION
            // =================================================

            if (!validMarks(mathematics) ||
                    !validMarks(science) ||
                    !validMarks(english) ||
                    !validMarks(java)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Each mark must be between 0 and 100.",
                        "Invalid Marks",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // =================================================
            // SUBJECT ARRAYLIST
            // =================================================

            ArrayList<String> subjects =
                    new ArrayList<>();

            subjects.add("Mathematics");
            subjects.add("Science");
            subjects.add("English");
            subjects.add("Java");

            // =================================================
            // MARKS ARRAYLIST
            // =================================================

            ArrayList<Double> marks =
                    new ArrayList<>();

            marks.add(mathematics);
            marks.add(science);
            marks.add(english);
            marks.add(java);

            // =================================================
            // CREATE STUDENT OBJECT
            // =================================================

            Student student =
                    new Student(
                            name,
                            id,
                            subjects,
                            marks
                    );

            // =================================================
            // CALCULATE RESULTS
            // =================================================

            double total =
                    student.getTotalMarks();

            double average =
                    student.getAverage();

            double highest =
                    student.getHighestScore();

            double lowest =
                    student.getLowestScore();

            String grade =
                    student.getGrade();

            String performance =
                    student.getPerformanceMessage();

            // =================================================
            // BUILD REPORT
            // =================================================

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

            report.append(
                    "Name         : "
            );

            report.append(
                    student.getName()
            );

            report.append("\n");

            report.append(
                    "Student ID   : "
            );

            report.append(
                    student.getStudentId()
            );

            report.append("\n\n");

            report.append(
                    "---------------- SUBJECT MARKS ----------------\n"
            );

            // Display subject marks
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
                            total
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
                            highest
                    )
            );

            report.append(
                    String.format(
                            "Lowest Score : %.2f%n",
                            lowest
                    )
            );

            report.append(
                    "Grade        : "
            );

            report.append(
                    grade
            );

            report.append("\n");

            report.append(
                    "Performance  : "
            );

            report.append(
                    performance
            );

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

            // =================================================
            // SHOW REPORT
            // =================================================

            resultArea.setText(
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
    // MARK VALIDATION
    // =====================================================

    private boolean validMarks(double marks) {

        return marks >= 0 && marks <= 100;
    }

    // =====================================================
    // CLEAR BUTTON
    // =====================================================

    private void clearFields() {

        nameField.setText("");
        idField.setText("");

        mathematicsField.setText("");
        scienceField.setText("");
        englishField.setText("");
        javaField.setText("");

        resultArea.setText(
                "                  RESULT SUMMARY\n"
                + "====================================================\n"
                + "Enter student details and marks, then click\n"
                + "'Calculate Grade' to generate the report."
        );
    }

    // =====================================================
    // EXIT BUTTON
    // =====================================================

    private void exitApplication() {

        int answer =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to exit?",
                        "Exit Student Grade Tracker",
                        JOptionPane.YES_NO_OPTION
                );

        if (answer ==
                JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    StudentGrade app =
                            new StudentGrade();

                    app.setVisible(true);
                }
        );
    }
}