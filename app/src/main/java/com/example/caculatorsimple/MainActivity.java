package com.example.caculatorsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView previewTV;
    private TextView workingsTV;
    private String workings = "", preview = "";
    private Double firstNumber, secondNumber;
    private String firstNumberString, secondNumberString;
    private String lastOperator = "";
    private int flagOperator = 0;
    private int flagEqual = 0;
    private int flagSign = 0;
    private int operatorType = 0;
    private double result;
    private String storeLastOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previewTV = (TextView) findViewById(R.id.previewTextView);
        workingsTV = (TextView) findViewById(R.id.workingsTextView);
        previewTV.setText("");
        workingsTV.setText("0");
    }

    public void setWorkings(String givenValue) {
        if (previewTV.getText().toString() != "" && flagOperator == 1) {
            if (flagEqual == 1) {
                previewTV.setText("");
                flagEqual = 0;
            }
            workingsTV.setText("");
            workings = "";
            flagOperator = 0;
        }
        workings += givenValue;
        workingsTV.setText(workings);
    }

    public void setPreview(String givenValue) {
        if (workingsTV.getText().toString() == "0") {
            firstNumber = Double.parseDouble("0");
            firstNumberString = "0";
            preview = firstNumberString + givenValue;
            previewTV.setText(preview);
        } else {
            firstNumberString = workingsTV.getText().toString();
            preview = firstNumberString + givenValue;
            previewTV.setText(preview);
            firstNumber = Double.parseDouble(firstNumberString);
        }
    }

    public void CEonClick(View view) {
        if (previewTV.getText().toString() == "") {
            flagOperator = 0;
            flagEqual = 0;
            flagSign = 0;
            operatorType = 0;
            previewTV.setText("");
            workingsTV.setText("0");
            workings = "";
            preview = "";
        } else if (flagEqual == 0){
            workingsTV.setText("0");
            workings = "";
        } else {
            flagOperator = 0;
            flagEqual = 0;
            flagSign = 0;
            operatorType = 0;
            previewTV.setText("");
            workingsTV.setText("0");
            workings = "";
            preview = "";
        }
    }

    public void ConClick(View view) {
        flagOperator = 0;
        flagEqual = 0;
        flagSign = 0;
        operatorType = 0;
        previewTV.setText("");
        workingsTV.setText("0");
        workings = "";
        preview = "";
        lastOperator = "";
    }

    public void BSonClick(View view) {
        if (flagOperator == 0 ) {
            if (workings.length() == 1) {
                workingsTV.setText("0");
                workings = "";
            } else if (workings.length() > 0){
                workings = workings.substring(0, workings.length() - 1);
                workingsTV.setText(workings);
            }
        }
    }

    public void divisionOnClick(View view) {
        if (flagOperator == 0 && lastOperator != "") {
            getLastOperator(lastOperator);
            lastOperator = "/";
            flagOperator = 1;
        } else if (flagOperator == 0) {
            lastOperator = "/";
            flagOperator = 1;
        } else if (flagOperator == 1) flagOperator = 0;
        setPreview("/");
        flagEqual = 0;
        operatorType = 1;
        storeLastOperator = lastOperator;
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void multiplicationOnClick(View view) {
        if (flagOperator == 0 && lastOperator != "") {
            getLastOperator(lastOperator);
            lastOperator = "x";
            flagOperator = 1;
        } else if (flagOperator == 0) {
            lastOperator = "x";
            flagOperator = 1;
        } else if (flagOperator == 1) flagOperator = 0;
        setPreview("x");
        flagEqual = 0;
        operatorType = 2;
        storeLastOperator = lastOperator;
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void subtractionOnClick(View view) {
        if (flagOperator == 0 && lastOperator != "") {
            getLastOperator(lastOperator);
            lastOperator = "-";
            flagOperator = 1;
        } else if (flagOperator == 0) {
            lastOperator = "-";
            flagOperator = 1;
        } else if (flagOperator == 1) flagOperator = 0;
        setPreview("-");
        flagEqual = 0;
        operatorType = 3;
        storeLastOperator = lastOperator;
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void additionOnClick(View view) {
        if (flagOperator == 0 && lastOperator != "") {
            getLastOperator(lastOperator);
            lastOperator = "+";
            flagOperator = 1;
        } else if (flagOperator == 0) {
            lastOperator = "+";
            flagOperator = 1;
        } else if (flagOperator == 1) flagOperator = 0;
        setPreview("+");
        flagEqual = 0;
        operatorType = 4;
        storeLastOperator = lastOperator;
    }

    public void signOnClick(View view) {
        if (flagSign == 0) {
            flagSign = 1;
            firstNumberString = "-" + workingsTV.getText().toString();
            workingsTV.setText(firstNumberString);
            firstNumber = Double.parseDouble(firstNumberString);
        } else {
            flagSign = 0;
            firstNumberString = workingsTV.getText().toString();
            firstNumber = -Double.parseDouble(firstNumberString);
            firstNumberString = firstNumber.toString();
            workingsTV.setText(firstNumberString);
        }
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void pointOnClick(View view) {
        setWorkings(".");
    }

    public void setResult(double result) {
        int integerPart = (int)result;
        int decimalPart = (int)((result-integerPart)*10);
        if (decimalPart == 0) {
            previewTV.setText(preview+ "=");
            workingsTV.setText(Integer.toString(integerPart));
        } else {
            previewTV.setText(preview + "=");
            workingsTV.setText(Double.toString(result));
        }
    }

    public void getLastOperator(String lastOperator) {
        String s = previewTV.getText().toString();
        firstNumberString = s.substring(0, s.length() - 1);
        firstNumber = Double.parseDouble(firstNumberString);
        secondNumberString = workingsTV.getText().toString();
        secondNumber = Double.parseDouble(secondNumberString);
        switch (lastOperator) {
            case "/": {
                result = firstNumber/secondNumber;
                break;
            }
            case "x": {
                result = firstNumber*secondNumber;
                break;
            }
            case "-": {
                result = firstNumber-secondNumber;
                break;
            }
            case "+": {
                result = firstNumber+secondNumber;
                break;
            }
        }
        int integerPart = (int)result;
        int decimalPart = (int)((result-integerPart)*10);
        if (decimalPart == 0) {
            previewTV.setText(Integer.toString(integerPart) + lastOperator);
            workingsTV.setText(Integer.toString(integerPart));
        } else {
            previewTV.setText(Double.toString(result) + lastOperator);
            workingsTV.setText(Double.toString(result));
        }
    }

    @SuppressLint("SetTextI18n")
    public void equalOnClick(View view) {
        String storeSecondNumber = secondNumberString;
        if (flagEqual == 0) {
            flagEqual = 1;
            secondNumberString = workingsTV.getText().toString();
            secondNumber = Double.parseDouble(secondNumberString);
            preview += workingsTV.getText().toString();
            lastOperator = "";
            workings = "";
        }
        else {
            firstNumberString = workingsTV.getText().toString();
            firstNumber = Double.parseDouble(firstNumberString);
            preview = firstNumberString + storeLastOperator + storeSecondNumber;
            lastOperator = "";
            workings = "";
        }
        switch (operatorType) {
            case 1: {
                result = firstNumber/secondNumber;
                setResult(result);
                break;
            }
            case 2: {
                result = firstNumber*secondNumber;
                setResult(result);
                break;
            }
            case 3: {
                result = firstNumber-secondNumber;
                setResult(result);
                break;
            }
            case 4: {
                result = firstNumber+secondNumber;
                setResult(result);
                break;
            }
        }
    }
}