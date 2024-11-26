package br.com.alexjr.listviewecommerce;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button backButton = findViewById(R.id.btn_voltar);
        backButton.setOnClickListener(v -> finish());

        String nome = getIntent().getStringExtra("nome");
        double preco = getIntent().getDoubleExtra("preco", 0.0);
        int imageResId = getIntent().getIntExtra("imageResId", -1);
        String descricao = getIntent().getStringExtra("descricao");

        TextView nomeTextView = findViewById(R.id.produto_nome);
        TextView precoTextView = findViewById(R.id.produto_preco);
        TextView descricaoTextView = findViewById(R.id.produto_descricao);
        ImageView imageView = findViewById(R.id.produto_imagem);

        nomeTextView.setText(nome);
        precoTextView.setText(String.format("R$ %.2f", preco));
        descricaoTextView.setText(descricao);

        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
    }
}
