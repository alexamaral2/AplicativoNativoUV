package br.com.alexjr.desafio2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText dateInput;
    private EditText valorAplicacao;
    private EditText percentualCdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button button = findViewById(R.id.btn_secondscreen);
        dateInput = findViewById(R.id.data_vencimento_investimento);
        valorAplicacao = findViewById(R.id.valor_aplicado);
        percentualCdi = findViewById(R.id.percentual_cdi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("dateInput", dateInput.getText().toString());
                intent.putExtra("valorAplicacao", valorAplicacao.getText().toString());
                intent.putExtra("percentualCdi", percentualCdi.getText().toString());

                startActivity(intent);
            }
        });

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                selectedMonth += 1;
                                dateInput.setText(selectedDay + "/" + selectedMonth + "/" + selectedYear);
                            }
                        },
                        year, month, day);

                datePickerDialog.show();
            }
        });
    }
}
