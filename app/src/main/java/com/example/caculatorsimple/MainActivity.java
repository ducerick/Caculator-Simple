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
    private String lastNumber;
    private int flagOperator = 0;
    private int flagEqual = 0;
    private int flagSign = 0;
    private int operatorType = 0;
    private double result;


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
        setPreview("/");
        operatorType = 1;
        if (flagOperator == 0) flagOperator = 1;
        else flagOperator = 0;
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
        lastNumber = "7";
    }

    public void eightOnClick(View view) {
        setWorkings("8");
        lastNumber = "8";
    }

    public void nineOnClick(View view) {
        setWorkings("9");
        lastNumber = "9";
    }

    public void multiplicationOnClick(View view) {
        setPreview("x");
        operatorType = 2;
        if (flagOperator == 0) flagOperator = 1;
        else flagOperator = 0;
    }

    public void fourOnClick(View view) {
        setWorkings("4");
        lastNumber = "4";
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
        lastNumber = "5";
    }

    public void sixOnClick(View view) {
        setWorkings("6");
        lastNumber = "6";
    }

    public void subtractionOnClick(View view) {
        setPreview("-");
        operatorType = 3;
        if (flagOperator == 0) flagOperator = 1;
        else flagOperator = 0;
    }

    public void oneOnClick(View view) {
        setWorkings("1");
        lastNumber = "1";
    }

    public void twoOnClick(View view) {
        setWorkings("2");
        lastNumber = "2";
    }

    public void threeOnClick(View view) {
        setWorkings("3");
        lastNumber = "3";
    }

    public void additionOnClick(View view) {
        setPreview("+");
        if (flagOperator == 0) flagOperator = 1;
        else flagOperator = 0;
        operatorType = 4;
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

    @SuppressLint("SetTextI18n")
    public void equalOnClick(View view) {
        secondNumberString = workingsTV.getText().toString();
        secondNumber = Double.parseDouble(secondNumberString);
        preview += workingsTV.getText().toString();
        flagOperator = 1;
        workings = "";
        if (flagEqual == 0) flagEqual = 1;
        else flagEqual = 0;
        switch (operatorType) {
            case 1: {
                result = firstNumber/secondNumber;
                int integerPart1 = (int)result;
                int decimalPart1 = (int)((result-integerPart1)*10);
                if (decimalPart1 == 0) {
                    previewTV.setText(preview);
                    workingsTV.setText(Integer.toString(integerPart1));
                } else {
                    previewTV.setText(preview);
                    workingsTV.setText(Double.toString(result));
                }
                break;
            }
            case 2: {
                result = firstNumber*secondNumber;
                int integerPart2 = (int)result;
                int decimalPart2 = (int)((result-integerPart2)*10);
                if (decimalPart2 == 0) {
                    previewTV.setText(preview);
                    workingsTV.setText(Integer.toString(integerPart2));
                } else {
                    previewTV.setText(preview);
                    workingsTV.setText(Double.toString(result));
                }
                break;
            }
            case 3: {
                result = firstNumber-secondNumber;
                int integerPart3 = (int)result;
                int decimalPart3 = (int)((result-integerPart3)*10);
                if (decimalPart3 == 0) {
                    previewTV.setText(preview);
                    workingsTV.setText(Integer.toString(integerPart3));
                } else {
                    previewTV.setText(preview);
                    workingsTV.setText(Double.toString(result));
                }
                break;
            }
            case 4: {
                result = firstNumber+secondNumber;
                int integerPart4 = (int)result;
                int decimalPart4 = (int)((result-integerPart4)*10);
                if (decimalPart4 == 0) {
                    previewTV.setText(preview);
                    workingsTV.setText(Integer.toString(integerPart4));
                } else {
                    previewTV.setText(preview);
                    workingsTV.setText(Double.toString(result));
                }
                break;
            }
        }
    }
}