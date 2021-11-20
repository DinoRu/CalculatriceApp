package ru.dinodev.calculatriceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bout_1, bout_2, bout_3, bout_4, bout_5, bout_6, bout_7, bout_8, bout_9, bout_0, bout_plus;
    Button bout_moins, bout_multi, bout_div, bout_egal, bout_C, bout_point;
    EditText editText;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation des boutons
        initView();

        bout_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("0");
            }
        });

        bout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("1");
            }
        });

        bout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("2");
            }
        });

        bout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("3");
            }
        });

        bout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("4");
            }
        });

        bout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("5");
            }
        });

        bout_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("6");
            }
        });

        bout_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("7");
            }
        });

        bout_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("8");
            }
        });

        bout_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre("9");
            }
        });

        //Click sur l'operateur +
        bout_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClick();
            }
        });

        //Clic sur l'operateur -
        bout_moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moinsClick();
            }
        });
        //Click sur l'operateur *
        bout_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etoileClick();
            }
        });
        //Click sur l'operateur /
        bout_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diviClick();
            }
        });
        //Click sur le bouton egal =
        bout_egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egalClick();
            }
        });
        //Click le bout C pour reinitialiser
        bout_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClick();
            }
        });

        //Click sur le bouton .
        bout_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChiffre(".");
            }
        });
    }

    private void diviClick() {
        if (clicOperateur){
            calcul();
            editText.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(editText.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    private void egalClick() {
        calcul();
        update = true;
        clicOperateur = false;
    }

    private void resetClick() {
        update = true;
        chiffre1 = 0;
        operateur = "";
        editText.setText("0");

    }

    private void etoileClick() {
        if (clicOperateur){
            calcul();
            editText.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(editText.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    private void moinsClick() {
        if (clicOperateur){
            calcul();
            editText.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(editText.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    private void plusClick() {
        if (clicOperateur) {
            calcul();
            editText.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(editText.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    private void calcul() {
        if (operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(editText.getText().toString()).doubleValue();
            editText.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(editText.getText().toString()).doubleValue();
            editText.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(editText.getText().toString()).doubleValue();
            editText.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("/")){
            try {
                chiffre1 = chiffre1 / Double.valueOf(editText.getText().toString()).doubleValue();
                editText.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                editText.setText("0");
            }

        }
    }
    private void clickChiffre(String str) {
        if (update){
            update = false;
        }else{
            if (!editText.getText().equals("0")){
                str = editText.getText() + str;
            }
        }
        editText.setText(str);
    }

    private void initView() {
        bout_0 = findViewById(R.id.button0);
        bout_1 = findViewById(R.id.button1);
        bout_2 = findViewById(R.id.button2);
        bout_3 = findViewById(R.id.button3);
        bout_4 = findViewById(R.id.button4);
        bout_5 = findViewById(R.id.button5);
        bout_6 = findViewById(R.id.button6);
        bout_7 = findViewById(R.id.button7);
        bout_8 = findViewById(R.id.button8);
        bout_9 = findViewById(R.id.button9);
        bout_C = findViewById(R.id.buttonC);
        bout_plus = findViewById(R.id.buttonPlus);
        bout_moins = findViewById(R.id.buttonMoins);
        bout_multi = findViewById(R.id.buttonMulti);
        bout_div = findViewById(R.id.buttonDivi);
        bout_egal = findViewById(R.id.buttonEgal);
        bout_point = findViewById(R.id.buttonPoint);
        editText = findViewById(R.id.edit_text);
    }
}