package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.os.Bundle;



public class AcaoJogador extends AppCompatActivity {

    RadioButton rbAndarFrente;
    RadioButton rbAndarTras;
    RadioButton rbPularVez;

    EditText posPirataFrente;
    EditText cartaPirataFrente;

    EditText posPirataTras;

    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acao_jogador);

        rbAndarFrente = findViewById(R.id.rbAndarFrente);
        rbAndarTras = findViewById(R.id.rbAndarTras);
        rbPularVez = findViewById(R.id.rbPassarVez);

        posPirataFrente = findViewById(R.id.etPosAndarFrente);
        cartaPirataFrente = findViewById(R.id.etCartaAndarFrente);

        posPirataTras = findViewById(R.id.etPosicaoAndarTras);

        btnContinuar = findViewById(R.id.btnContinuar);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbAndarFrente.isChecked()){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("acao","F");
                    returnIntent.putExtra("posicao",posPirataFrente.getText().toString());
                    returnIntent.putExtra("carta",cartaPirataFrente.getText().toString());
                    setResult(RESULT_OK,returnIntent);
                }

                if(rbAndarTras.isChecked()){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("acao","T");
                    returnIntent.putExtra("posicao",posPirataTras.getText().toString());
                    setResult(RESULT_OK,returnIntent);
                }

                if(rbPularVez.isChecked()){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("acao","P");
                    setResult(RESULT_OK,returnIntent);
                }
                finish();
            }
        };

        btnContinuar.setOnClickListener(listener);

    }
}
