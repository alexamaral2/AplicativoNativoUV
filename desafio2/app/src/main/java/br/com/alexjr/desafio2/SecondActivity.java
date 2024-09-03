package br.com.alexjr.desafio2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        TextView textResultadoSimulacao = findViewById(R.id.resultado_simulacao);
        TextView textRendimentoTotal = findViewById(R.id.rendimento_total);
        TextView textValorAplicacao = findViewById(R.id.valor_aplicado_inicialmente);
        TextView textValorBrutoInvestimento = findViewById(R.id.valor_bruto_investimento);
        TextView textValorRendimento = findViewById(R.id.valor_rendimento);
        TextView textIrRendimento = findViewById(R.id.ir_rendimento);
        TextView textValorLiquidoInvestimento = findViewById(R.id.valor_liquido_investimento);
        TextView textDataResgate = findViewById(R.id.data_resgate);
        TextView textDiasCorridos = findViewById(R.id.dias_corridos);
        TextView textRendimentoMensal = findViewById(R.id.rendimento_mensal);
        TextView textPercentualCdi = findViewById(R.id.percentual_cdi);
        TextView textRentabilidadeAnual = findViewById(R.id.rentabilidade_anual);
        TextView textRentabilidadePeriodo = findViewById(R.id.rentabilidade_periodo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String dataVencimento = extras.getString("dateInput");
            double valorAplicacao = Double.parseDouble(extras.getString("valorAplicacao"));
            double percentualCdi = Double.parseDouble(extras.getString("percentualCdi"));

            double rendimentoTotal = (valorAplicacao * percentualCdi) / 100;

            double valorBrutoInvestimento = valorAplicacao + rendimentoTotal;

            double irRendimento = rendimentoTotal * 0.15;

            double valorLiquidoInvestimento = valorBrutoInvestimento - irRendimento;

            long diasCorridos = calcularDiasCorridos(dataVencimento);

            double rendimentoMensal = rendimentoTotal / (diasCorridos / 30.0);

            double rentabilidadeAnual = percentualCdi;


            double rentabilidadePeriodo = (rendimentoTotal / valorAplicacao) * 100;

            // Setar os valores nos TextViews
            textValorAplicacao.setText("R$ " + String.format("%.2f", valorAplicacao));
            textPercentualCdi.setText(percentualCdi + "%");
            textDataResgate.setText(dataVencimento);

            textResultadoSimulacao.setText("R$ " + String.format("%.2f", valorLiquidoInvestimento));
            textRendimentoTotal.setText("R$ " + String.format("%.2f", rendimentoTotal));
            textValorBrutoInvestimento.setText("R$ " + String.format("%.2f", valorBrutoInvestimento));
            textValorRendimento.setText("R$ " + String.format("%.2f", rendimentoTotal));
            textIrRendimento.setText("R$ " + String.format("%.2f", irRendimento));
            textValorLiquidoInvestimento.setText("R$ " + String.format("%.2f", valorLiquidoInvestimento));
            textDiasCorridos.setText(String.valueOf(diasCorridos));
            textRendimentoMensal.setText(String.format("%.2f", rendimentoMensal) + "% ao mês");
            textRentabilidadeAnual.setText(String.format("%.2f", rentabilidadeAnual) + "% ao ano");
            textRentabilidadePeriodo.setText(String.format("%.2f", rentabilidadePeriodo) + "% no período");
        }

        Button button = findViewById(R.id.btn_firstscreen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private long calcularDiasCorridos(String dataVencimento) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataAtual = Calendar.getInstance().getTime();
            Date dataResgate = dateFormat.parse(dataVencimento);
            long diferencaMillis = dataResgate.getTime() - dataAtual.getTime();
            return TimeUnit.DAYS.convert(diferencaMillis, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
