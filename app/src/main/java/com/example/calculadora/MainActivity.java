package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpressionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZerro, numeroUm,numeroDois,
    numeroTres,numeroQuarta, numeroCinco,numeroSeis,numeroSete,
    numeroOito,numeroNove,ponto,soma,divisao,subtracao,multiplicacao,igual,butto_limpar,
            raizqu,raizcub, quadr,cubica,coseno,seno,tg,ctg;
    private TextView txtexpressao,txtresultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarcomponente();

        getSupportActionBar().hide();


        numeroZerro.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuarta.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        raizqu.setOnClickListener(this);
        raizcub.setOnClickListener(this);
        quadr.setOnClickListener(this);
        cubica.setOnClickListener(this);
        seno.setOnClickListener(this);
        coseno.setOnClickListener(this);
        ctg.setOnClickListener(this);
        tg.setOnClickListener(this);
        butto_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtexpressao.setText("");
                txtresultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expresao = findViewById(R.id.txt_expressao);
                String campo= expresao.getText().toString();
                if (!campo.isEmpty()){
                    byte var = 0;
                    int var1 = campo.length()-1;
                    String varexpressao = campo.substring(var,var1);
                    expresao.setText(varexpressao);
                }
                txtresultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression exp = new ExpressionBuilder(txtexpressao.getText().toString()).build();
                    double resultado = exp.evaluate();
                    long  longresultado = (long) resultado;
                    if (resultado == (double) longresultado){
                        txtresultado.setText((CharSequence) String.valueOf(longresultado));
                    }
                    else {
                        txtresultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e){

                }

            }


        });

    }
    private void iniciarcomponente(){
    numeroZerro = findViewById(R.id.number_zero);
    numeroUm =findViewById(R.id.number_um);
        numeroDois =findViewById(R.id.number_dois);
        numeroTres =findViewById(R.id.number_tres);
        numeroQuarta =findViewById(R.id.number_quatro);
        numeroCinco =findViewById(R.id.number_cinco);
        numeroSeis =findViewById(R.id.number_seis);
        numeroSete =findViewById(R.id.number_sete);
        numeroOito=findViewById(R.id.number_oito);
        numeroNove =findViewById(R.id.number_nove);
        ponto =findViewById(R.id.number_ponto);
        soma =findViewById(R.id.soma);
        subtracao=findViewById(R.id.subtracao);
        multiplicacao =findViewById(R.id.multicador);
        divisao =findViewById(R.id.divisor);
        igual =findViewById(R.id.igual);
        butto_limpar = findViewById(R.id.bt_limpar);
        txtexpressao =findViewById(R.id.txt_expressao);
        txtresultado =findViewById(R.id.txt_resultado);
        backspace =findViewById(R.id.backspace);
        raizcub = findViewById(R.id.bt_raiz);
        raizqu = findViewById(R.id.bt_raizquadrada);
        cubica = findViewById(R.id.bt_quadr);
        quadr = findViewById(R.id.bt_cubica);
        seno = findViewById(R.id.seno);
        coseno = findViewById(R.id.coseno);
        tg = findViewById(R.id.tang);
        ctg = findViewById(R.id.cotg);
    }

    public void acreresultado(String campo,boolean limpar_dados){

        if (txtresultado.getText().equals("")){
            txtexpressao.setText(" ");
        }
        if (limpar_dados){
        txtresultado.setText(" ");
        txtexpressao.append(campo);
        }else{
            txtexpressao.append(txtresultado.getText());
            txtexpressao.append(campo);
            txtresultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.number_zero:
                acreresultado("0",true);
                break;
            case R.id.number_um:
                acreresultado("1",true);
                break;
            case R.id.number_dois:
                acreresultado("2",true);
                break;
            case R.id.number_tres:
                acreresultado("3",true);
                break;
            case R.id.number_quatro:
                acreresultado("4",true);
                break;
            case R.id.number_cinco:
                acreresultado("5",true);
                break;
            case R.id.number_seis:
                acreresultado("6",true);
                break;
            case R.id.number_sete:
                acreresultado("7",true);
                break;
            case R.id.number_oito:
                acreresultado("8",true);
                break;
            case R.id.number_nove:
                acreresultado("9",true);
                break;
            case R.id.number_ponto:
                acreresultado(".",true);
                break;
            case R.id.divisor:
                acreresultado("/",false);
                break;
            case R.id.soma:
                acreresultado("+",false);
                break;
            case R.id.multicador:
                acreresultado("*",false);
                break;
            case R.id.subtracao:
                acreresultado("-",false);
                break;
            case R.id.bt_raiz:
                acreresultado("^3",false);
                break;
            case R.id.bt_raizquadrada:
                acreresultado("^2",false);
                break;
            case R.id.bt_quadr:
            acreresultado("sqrt ",false);
            break;
            case R.id.bt_cubica:
            acreresultado("cbrt ",false);
            break;
            case R.id.seno:
                acreresultado("sin ",false);
                break;
            case R.id.coseno:
                acreresultado("cos ",false);
                break;
            case R.id.tang:
                acreresultado("tan ",false);
                break;
            case R.id.cotg:
                acreresultado("log ",false);
                break;
        }
    }
}