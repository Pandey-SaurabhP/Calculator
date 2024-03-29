package com.example.saurabhpandey.calculator;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button equalsto;
    private Button add;
    private Button subtract;
    private Button divide;
    private Button multiply;
    private Button cc;

    private TextView ans;
    private TextView click;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = 0;

    private double val1 = Double.NaN;
    private double val2;

    private char ACTION;

    // private MediaPlayer sound = MediaPlayer.create(MainActivity.this, R.raw.boom.mp3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        // Boom.start();

        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "2");
            }
        });

        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "4");
            }
        });

        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "3");
            }
        });

        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                click.setText(click.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = ADDITION;

                ans.setText(String.valueOf(val1) + " + ");
                click.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = SUBTRACTION;

                ans.setText(String.valueOf(val1) + " - ");
                click.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = DIVISION;

                ans.setText(String.valueOf(val1) + " / ");
                click.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = MULTIPLICATION;

                ans.setText(String.valueOf(val1) + " * ");
                click.setText(null);
            }
        });

        equalsto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQUAL;
                ans.setText(ans.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                click.setText(null);
            }
        });

        cc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                val1 = Double.NaN;
                val2 = Double.NaN;
                click.setText(null);
                ans.setText(null);
            }
        });

    }

    private void setupUI(){
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        add = (Button) findViewById(R.id.sum);
        subtract = (Button) findViewById(R.id.sub);
        divide = (Button) findViewById(R.id.div);
        multiply = (Button) findViewById(R.id.mult);
        cc = (Button) findViewById(R.id.clear);
        equalsto = (Button) findViewById(R.id.equal);

        click = (TextView) findViewById(R.id.control);
        ans = (TextView) findViewById(R.id.answer);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(click.getText().toString());

            switch(ACTION){
                case ADDITION: val1 += val2; break;
                case SUBTRACTION: val1 -= val2; break;
                case DIVISION: val1 /= val2; break;
                case MULTIPLICATION: val1 *= val2; break;
                case EQUAL: break;
            }
        }
        else{
            val1 = Double.parseDouble(click.getText().toString());
        }
    }
}
