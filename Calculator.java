import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, modButton, equalsButton, clrButton;
    private JPanel panel;

    private StringBuilder input;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        this.setTitle("Simple Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 20, 240, 40);
        textField.setEditable(false);

        input = new StringBuilder();

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[7];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        equalsButton = new JButton("=");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = clrButton;

        for (int i = 0; i < 7; i++) {
            functionButtons[i].addActionListener(this);
        }

        panel = new JPanel();
        panel.setBounds(30, 80, 240, 250);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);
        panel.add(modButton);

        this.add(panel);
        this.add(textField);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                input.append(i);
                textField.setText(input.toString());
            }
        }

        if (e.getSource() == addButton || e.getSource() == subButton ||
                e.getSource() == mulButton || e.getSource() == divButton || e.getSource() == modButton) {
            char op = ' ';
            if (e.getSource() == addButton) {
                op = '+';
            } else if (e.getSource() == subButton) {
                op = '-';
            } else if (e.getSource() == mulButton) {
                op = '*';
            } else if (e.getSource() == divButton) {
                op = '/';
            } else if (e.getSource() == modButton) {
                op = '%';
            }

            input.append(" ").append(op).append(" ");
            textField.setText(input.toString());
        }

        if (e.getSource() == equalsButton) {
            String expression = input.toString();
            if (expression.trim().isEmpty()) {
                textField.setText("Error: No input");
                return;
            }

            try {
                String[] tokens = expression.split(" ");
                num1 = Double.parseDouble(tokens[0]);
                operator = tokens[1].charAt(0);
                num2 = Double.parseDouble(tokens[2]);

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) {
                            throw new ArithmeticException("Modulus by zero is undefined");
                        }
                        result = num1 % num2;
                        break;
                }

                textField.setText(String.valueOf(result));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                textField.setText("Error: Invalid input");
            } catch (ArithmeticException ex) {
                textField.setText("Error: " + ex.getMessage());
            }
            input.setLength(0);
        }

        if (e.getSource() == clrButton) {
            input.setLength(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
