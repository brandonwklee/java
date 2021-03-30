package calculator_app;
import javax.swing.*;
import java.awt.*;

public class myapp extends JFrame {
    public static String calculatorValue = "0";
    public static JTextField text = new JTextField(14);
    private Font font = new Font("Courier", Font.BOLD, 30);
    static JButton[] operationButtons = new JButton[11];
    static JButton[] numberButtons = new JButton[11];
    public static String[] buttonValues = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0"};
    public static String[] operationSymbols = {"(", ")", "C", "BACK", "+", "-", "*", ".", "%", "/", "="};
    private GridLayout layout = new GridLayout(6, 4, 3, 3);
    public static boolean multipleDigits = false;

    public myapp() {
        JPanel mainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        text.setPreferredSize(new Dimension(30, 50));
        text.setText(calculatorValue);
        text.setFont(font);
        text.setEditable(false);

        topPanel.add(text);
        bottomPanel.setLayout(layout);

        for (int i = 0; i < 4; i++) {
            operationButtons[i] = new JButton(operationSymbols[i]);
            operationButtons[i].addActionListener(new operationsListener(operationSymbols[i]));
            bottomPanel.add((operationButtons[i]));
        }

        for (int i = 0; i < 3; i++) {
            numberButtons[i] = new JButton(buttonValues[i]);
            numberButtons[i].setPreferredSize(new Dimension(80, 50));
            numberButtons[i].addActionListener(new numberButton(buttonValues[i]));
            bottomPanel.add((numberButtons[i]));
        }

        operationButtons[4] = new JButton(operationSymbols[4]);
        operationButtons[4].addActionListener(new operationsListener(operationSymbols[4]));
        bottomPanel.add((operationButtons[4]));

        for (int i = 3; i < 6; i++) {
            numberButtons[i] = new JButton(buttonValues[i]);
            numberButtons[i].setPreferredSize(new Dimension(80, 50));
            numberButtons[i].addActionListener(new numberButton(buttonValues[i]));
            bottomPanel.add((numberButtons[i]));
        }

        operationButtons[5] = new JButton(operationSymbols[5]);
        operationButtons[5].addActionListener(new operationsListener(operationSymbols[5]));
        bottomPanel.add((operationButtons[5]));

        for (int i = 6; i < 9; i++) {
            numberButtons[i] = new JButton(buttonValues[i]);
            numberButtons[i].setPreferredSize(new Dimension(80, 50));
            numberButtons[i].addActionListener(new numberButton(buttonValues[i]));
            bottomPanel.add((numberButtons[i]));
        }

        operationButtons[6] = new JButton(operationSymbols[6]);
        operationButtons[6].addActionListener(new operationsListener(operationSymbols[6]));
        bottomPanel.add((operationButtons[6]));

        numberButtons[9] = new JButton(buttonValues[9]);
        numberButtons[9].addActionListener(new numberButton(buttonValues[9]));
        bottomPanel.add((numberButtons[9]));

        for (int i = 7; i < 11; i++) {
            operationButtons[i] = new JButton(operationSymbols[i]);
            operationButtons[i].addActionListener(new operationsListener(operationSymbols[i]));
            bottomPanel.add((operationButtons[i]));
        }

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
        setTitle("Calculator");
        setSize(450, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        myapp myapp = new myapp();
    }
}