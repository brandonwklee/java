package calculator_app;
import java.awt.event.*;
import java.util.regex.*;
import static calculator_app.myapp.*;

class numberButton implements ActionListener {
    private String value;

    public numberButton(String buttonValue) { this.value = buttonValue; }

    public void actionPerformed(ActionEvent e) {

        if (calculatorValue.length() == 1 && calculatorValue.equals("0")) {
            multipleDigits = false;
            numberButtons[9].setEnabled(false);
        }
        if (multipleDigits == true) {
            calculatorValue += value;
            text.setText(calculatorValue);
        }

        if (multipleDigits == false) {
            numberButtons[9].setEnabled(true);
            multipleDigits = true;
            calculatorValue = value;
            text.setText(calculatorValue);
        }
    }
}

class operationsListener implements ActionListener {
    private String operator;

    public operationsListener(String buttonValue) {
        this.operator = buttonValue;
    }

    public void actionPerformed(ActionEvent e) {
        if (operator == "BACK") {
            calculatorValue = calculatorValue.substring(0, calculatorValue.length() - 1);
            text.setText(calculatorValue);
            if (!calculatorValue.contains(".")) {
                operationButtons[7].setEnabled(true);
            }
            if (calculatorValue.length() == 0) {
                calculatorValue = "0";
                text.setText(calculatorValue);
            }
        }

        if (operator == "+" | operator == "-" | operator == "*" | operator == "/") {
            calculatorValue += operator;
            text.setText(calculatorValue);
        }

        if (operator == "(") {
            if (calculatorValue.equals("0")) {
                calculatorValue = operator;
                text.setText(calculatorValue);
            } else {
                calculatorValue += operator;
                text.setText(calculatorValue);
            }
        }

        if (operator == ")") {
            Pattern pattern = Pattern.compile("[(]");
            Matcher matcher = pattern.matcher(calculatorValue);
            int count = 0;
            int clicks = 0;
            while (matcher.find()) {
                count++;
            }
            if (calculatorValue.contains("(")) {
                if (clicks == count) {
                    operationButtons[1].setEnabled(false);
                }
                calculatorValue += operator;
                text.setText(calculatorValue);
                clicks++;
            }
        }

        if (operator == ".") {
            calculatorValue += operator;
            text.setText(calculatorValue);
            if (calculatorValue.contains(".")) {
                operationButtons[7].setEnabled(false);
            }
        }

        if (operator == "C") {
            calculatorValue = "0";
            text.setText(calculatorValue);
            operationButtons[7].setEnabled(true);
        }

        if (operator == "=") {
            String subString = "";
            int total = 0;
            if (calculatorValue.length() > 1) {
                if (calculatorValue.startsWith("(")) {
                    int endsWithBracket = calculatorValue.lastIndexOf(")") + 1;
                    subString += calculatorValue.substring(0, endsWithBracket);
                }
                System.out.println(subString);
            }
        }
    }
}