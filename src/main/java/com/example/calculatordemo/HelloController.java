package com.example.calculatordemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private String value = "";
    @FXML
    private String number1 = "";
    @FXML
    private String number2 = "";
    @FXML
    private String operator = "";
    @FXML
    private String operatorEquals = "";
    @FXML
    private String operatorClean = "";
    @FXML
    private int operatorCounter = 0;
    @FXML
    private int operatorEqualsCounter = 0;
    @FXML
    private int operatorCleanCounter = 0;


    @FXML
    public void onNumbersClick(ActionEvent event) {

        String text = (((Button) event.getSource()).getText());

        this.operator = Operator(text);
        this.operatorEquals = OperatorEquals(text);
        this.operatorClean = OperatorClean(text);

        if (operatorCleanCounter ==2 || operatorCounter ==2 || operatorEqualsCounter ==2) {
            this.operatorEquals = "=";
        }if (operatorCleanCounter ==3 || operatorCounter ==3 || operatorEqualsCounter ==3) {
           cleanAll();
        }

        if (this.operator.isEmpty()) {
            this.number1 = String.valueOf(getNumber1(text));
        } else if (this.operator.length() == 1) {
            this.number2 = String.valueOf(getNumber2(text));
        }


        if (this.operatorEquals.equals("=")) {
            welcomeText.setText(operation(number1, number2, this.operator));

        }
        if (this.operatorClean.equals("C")) {
            cleanAll();
        }


    }
    @FXML
    public String operation(String number11, String number22, String operator) {
        Float number1 = Float.valueOf(number11);
        Float number2 = Float.valueOf(number22);

        if (operator.equals("/")) {
            if (number2 == 0) {
                this.value = "0";
                return this.value;
                // welcomeText.setText("0");
            }
            this.value = String.valueOf(number1 / number2);
        } else if (operator.equals("*")) {

            this.value = String.valueOf(number1 * number2);
        } else if (operator.equals("-")) {

            this.value = String.valueOf(number1 - number2);
        } else if (operator.equals("+")) {

            this.value = String.valueOf(number1 + number2);
        }
        return this.value;
    }
    @FXML
    public String Operator(String text) {
        if (text.equals("/") || text.equals("*") || text.equals("-") || text.equals("+")) {
            this.operator = text;
            this.operatorCounter++;
            return this.operator;
        } else return this.operator;
    }
    @FXML
    public String OperatorEquals(String text) {

        if (text.equals("=")) {
            this.operatorEquals = text;
            this.operatorEqualsCounter++;
            return this.operatorEquals;
        } else return this.operatorEquals;
    }
    @FXML
    public String OperatorClean(String text) {

        if (text.equals("C")) {
            this.operatorClean = text;
            this.operatorCleanCounter++;
            return this.operatorClean;
        } else return this.operatorClean;
    }
    @FXML
    public String getNumber1(String text) {
        String number = "";

        if (!text.equals("/") && !text.equals("*") && !text.equals("-") && !text.equals("+") && !text.equals("=") && !text.equals("C")) {
            this.number1 = this.number1 + text;
            welcomeText.setText(this.number1);

        }
        number = this.number1;
        return number;
    }
    @FXML
    public String getNumber2(String text) {
        String number = "";

        if (!text.equals("/") && !text.equals("*") && !text.equals("-") && !text.equals("+") && !text.equals("=") && !text.equals("C")) {
            this.number2 = this.number2 + text;
            welcomeText.setText(this.number2);

        }
        number = this.number2;
        return number;
    }
    @FXML
    public void cleanAll() {
        this.value = "";
        this.operator = "";
        this.number1 = "";
        this.number2 = "";
        this.operatorEquals = "";
        this.operatorClean = "";
        this.operatorEqualsCounter=0;
        this.operatorCounter=0;
        this.operatorCleanCounter=0;
        welcomeText.setText(this.value);
    }
}

