package eu.wanielista.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {


    //numbers
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, dot, c, zero, sqrtBTN, buttonCE, btnPlusMinus;

    //actions
    Button plus, minus, divide, mul, eq;

    private static final int OPERATOR_ADD = 1;
    private static final int OPERATOR_SUBSTRACT = 2;
    private static final int OPERATOR_MULTIPLY= 3;
    private static final int OPERATOR_DIVIDE = 4;
    private int operation;

    private static final String log = "LOG:";


   // EditText ed1;
    TextView textView1, textViewHist;

    float valueOne, valueTwo, wynik;
    boolean addBool, divBool, mullBool, subBool;
    String wynikS;
    int tempVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        dot = (Button) findViewById(R.id.btn_dot);
        c = (Button) findViewById(R.id.btn_delete);
        zero = (Button) findViewById(R.id.btn_zero);
        plus = (Button)findViewById(R.id.btn_plus);
        minus = (Button) findViewById(R.id.btn_minus);
        divide = (Button) findViewById(R.id.btn_divide);
        mul = (Button) findViewById(R.id.btn_multiple);
        eq = (Button) findViewById(R.id.btn_equal);
       // ed1 = (EditText) findViewById(R.id.edt1);
        textView1 = (TextView) findViewById(R.id.tv1);
        textViewHist = (TextView) findViewById(R.id.textViewHistory);
        sqrtBTN = (Button) findViewById(R.id.btn_sqrt);
        buttonCE = (Button) findViewById(R.id.btn_ce);
        btnPlusMinus = (Button) findViewById(R.id.buttonPlusMinus);



        //onClickListeners
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "2");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "6");

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "7");

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "8");

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "9");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + "0");

            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText() + ".");


            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {

                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();

                } else {
                    if (textView1 == null) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Enter value", Toast.LENGTH_SHORT);
                        textView1.setText(null);
                    } else {
                        valueOne = Float.parseFloat(textView1.getText() + "");
                        operation = OPERATOR_ADD;
                        textView1.setText(null);

                        tempVariable = (int) round(valueOne);
                        if(tempVariable == valueOne){
                            textViewHist.setText(tempVariable+ " + " + "");
                        } else{
                            textViewHist.setText(valueOne+ " + " + "");
                        }

                    }
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {

                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();

                } else {
                    valueOne = Float.parseFloat(textView1.getText() + "");
                    operation = OPERATOR_DIVIDE;
                    textView1.setText(null);
                    tempVariable = (int) round(valueOne);
                    if(tempVariable == valueOne){
                        textViewHist.setText(tempVariable+ " / " + "");
                    } else{
                        textViewHist.setText(valueOne+ " / " + "");
                    };
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {

                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();

                } else {
                    valueOne = Float.parseFloat(textView1.getText() + "");
                    operation = OPERATOR_SUBSTRACT;
                    textView1.setText(null);
                    tempVariable = (int) round(valueOne);
                    if(tempVariable == valueOne){
                        textViewHist.setText(tempVariable+ " - " + "");
                    } else{
                        textViewHist.setText(valueOne+ " - " + "");
                    }
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {

                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();

                } else {
                    valueOne = Float.parseFloat(textView1.getText() + "");
                    operation = OPERATOR_MULTIPLY;
                    textView1.setText(null);
                    tempVariable = (int) round(valueOne);
                    if(tempVariable == valueOne){
                        textViewHist.setText(tempVariable+ " * " + "");
                    } else{
                        textViewHist.setText(valueOne+ " * " + "");
                    }
                }
            }
        });
        sqrtBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {

                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();

                } else {
                    valueOne = Float.parseFloat(textView1.getText() + "");
                    double squareRoot = Math.sqrt(valueOne);
                    textViewHist.setText(null);
                    textViewHist.setText(Double.toString(squareRoot));
                }
            }
        });
        //end

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(null);
                textViewHist.setText(null);
                valueTwo = 0;
                valueOne = 0;
                zeroAllVar();
            }
        });
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(null);
                valueOne = 0;
            }
        });
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GetEditText = textView1.getText().toString();

                if (TextUtils.isEmpty(GetEditText)) {
                    Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();
                } else {
                    float tempValue;
                    valueOne = Float.parseFloat(textView1.getText() + "");
                    valueOne = valueOne * (-1);
                    textView1.setText(null);
                    textView1.setText(valueOne + "");
                }
            }
        });




        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GetEditText = textView1.getText().toString();
                if (TextUtils.isEmpty(GetEditText)) {
                    setErrorWithValues();
                } else {
                    operations();
                }
            }
        });
    }

    void zeroAllVar() {
       operation = 0;
       valueTwo = 0;
       valueOne = 0;
    }

    void operations(){
        valueTwo = Float.parseFloat(textView1.getText() + "");
        textView1.setText(null);
        switch(operation) {
            case OPERATOR_SUBSTRACT:
                wynik = valueOne - valueTwo;
                textViewHist.setText(valueOne + " - " + valueTwo + " = " + wynik);
                break;
            case OPERATOR_ADD:
                wynik = valueOne + valueTwo;
                textViewHist.setText(valueOne + " + " + valueTwo + " = " + wynik);
                break;
            case OPERATOR_DIVIDE:
                wynik = valueOne / valueTwo;
                textViewHist.setText(valueOne + " / " + valueTwo + " = " + wynik);
                break;
            case OPERATOR_MULTIPLY:
                wynik = valueOne * valueTwo;
                textViewHist.setText(valueOne + " * " + valueTwo + " = " + wynik);
                break;
            default:
                Toast toast = Toast.makeText(getApplicationContext(), "ERROR!", Toast.LENGTH_SHORT);
        }
        zeroAllVar();
    }

    void setErrorWithValues() {
        Toast.makeText(MainActivity.this, "Enter values", Toast.LENGTH_LONG).show();
    }
}
