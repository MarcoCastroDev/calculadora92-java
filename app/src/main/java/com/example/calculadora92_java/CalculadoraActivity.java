package com.example.calculadora92_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnLimpiar;
    private Button btnRegresar;
    private TextView lblUsuario;
    private TextView lblResultado;
    private EditText txtNum1;
    private EditText txtNum2;

    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        iniciarComponentes();

        // Obtener los datos del MainActivity
        Bundle datos = getIntent().getExtras();
        String user = datos.getString("user");
        lblUsuario.setText(user);

        calculadora = new Calculadora(0.0f, 0.0f);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSumar();
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRestar();
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMultiplicar();
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDividir();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegresar();
            }
        });
    }

    private void iniciarComponentes() {
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);
        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
    }

    private void btnSumar() {
        calculadora.setNum1(Float.parseFloat(txtNum1.getText().toString()));
        calculadora.setNum2(Float.parseFloat(txtNum2.getText().toString()));
        float total = calculadora.suma();
        lblResultado.setText(Float.toString(total));
    }

    private void btnRestar() {
        calculadora.setNum1(Float.parseFloat(txtNum1.getText().toString()));
        calculadora.setNum2(Float.parseFloat(txtNum2.getText().toString()));
        float total = calculadora.resta();
        lblResultado.setText(Float.toString(total));
    }

    private void btnMultiplicar() {
        calculadora.setNum1(Float.parseFloat(txtNum1.getText().toString()));
        calculadora.setNum2(Float.parseFloat(txtNum2.getText().toString()));
        float total = calculadora.multiplicacion();
        lblResultado.setText(Float.toString(total));
    }

    private void btnDividir() {
        calculadora.setNum1(Float.parseFloat(txtNum1.getText().toString()));
        calculadora.setNum2(Float.parseFloat(txtNum2.getText().toString()));
        float total = calculadora.division();
        lblResultado.setText(Float.toString(total));
    }

    private void btnLimpiar() {
        lblResultado.setText("");
        txtNum1.setText("");
        txtNum2.setText("");
    }

    private void btnRegresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("Regresar al MainActivity?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        confirmar.show();
    }
}