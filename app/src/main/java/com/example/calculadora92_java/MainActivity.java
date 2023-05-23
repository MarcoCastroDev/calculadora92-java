package com.example.calculadora92_java;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;
    private Button btnSalir;
    private TextInputEditText txtUsuario;
    private TextInputEditText txtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIngresar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSalir();
            }
        });
    }

    private void iniciarComponentes() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
    }

    private void btnIngresar() {
        String strUsuario;
        String strContrasena;

        strUsuario = getString(R.string.user);
        strContrasena = getString(R.string.password);

        if (strUsuario.equals(txtUsuario.getText().toString()) && strContrasena.equals(txtContrasena.getText().toString())) {
            Bundle bundle = new Bundle();
            bundle.putString("user", txtUsuario.getText().toString());

            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "El usuario o contraseña no es válido", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnSalir() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("Cerrar la aplicación?");
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