package br.com.alexjr.listviewecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Produto> produtosList = new ArrayList<>();
        produtosList.add(new Produto("Cobertor Casal Manta Canelada Super Soft 1,80m X 2,0m", 48.21,  R.drawable.cobertor, "Sem estrelas", "Envolva-se em conforto com o Cobertor Casal Manta Canelada Super Soft da Casa Dona. Medindo 1,80m x 2,0m, é a escolha ideal para proporcionar calor e aconchego em qualquer ocasião."));
        produtosList.add(new Produto("Purificador IBBL Água Gelada, Fria e Natural E-due com Painel Touch Bivolt", 519.00, R.drawable.purificador, "5.0 estrelas", "O Purificador de Água IBBL E-due Touch oferece uma experiência de purificação avançada com máxima conveniência e estilo. Ideal para quem busca água pura, fresca e saudável, o E-due Touch combina tecnologia de ponta com design moderno, sendo perfeito para qualquer ambiente."));
        produtosList.add(new Produto("Liquidificador Oster 1400 Full OLIQ610 Preto", 169.00, R.drawable.liquidificador, "4.5 estrelas", "Se você gosta de fazer receitas deliciosas mas não abre mão de praticidade, você precisa de um liquidificador. E sabendo disso a Oster trouxe o Liquidificado 1400 Full OLIQ610. Ele possui 4 lâminas com material em inox, que além de resistentes tem um alto poder de corte e mistura, isso sem contar que não enferruja."));
        produtosList.add(new Produto("Notebook Dell Inspiron I15-I120K-U30P 15.6 Full HD 12ª Geração Intel Core i5 4", 3199.00, R.drawable.notebook, "5.0 estrelas", "EXPERIÊNCIA IMERSIVA EM TELA FULL HD COM BORDAS MAIS FINAS EM 15.6”Processadores eficientes de 12a Geração: possui uma capacidade de resposta incrível que permite a realização de tarefas simultâneas de forma tranquila e sem problemas.Memória mais rápida, mais armazenamento: O SSD de 512GB proporciona maior tempo de bateria, rápida resposta e performance mais silenciosa."));
        produtosList.add(new Produto("Smartphone Samsung Galaxy A55 128GB Azul Escuro 5G", 1799.00, R.drawable.celular, "4.8 estrelas", "O Smartphone Galaxy A55 5G é o celular ideal para aqueles que gostam de criar e compartilhar conteúdos, inspirando outras pessoas através de suas histórias. Esse modelo da Samsung possui design premium em metal e vidro com resistência a água e a poeira (IP67) traz estilo e proteção para o seu dia a dia."));

        ProdutoAdapter adapter = new ProdutoAdapter(this, produtosList);
        GridView listView = findViewById(R.id.produtoListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Produto produtoSelecionado = produtosList.get(position);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("nome", produtoSelecionado.getNome());
            intent.putExtra("preco", produtoSelecionado.getPreco());
            intent.putExtra("imageResId", produtoSelecionado.getImageResId());
            intent.putExtra("avaliacao", produtoSelecionado.getAvaliacao());
            intent.putExtra("descricao", produtoSelecionado.getDescricao());

            startActivity(intent);
        });
    }
}
