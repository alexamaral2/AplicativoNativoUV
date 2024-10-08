package br.com.alexjr.listviewnews;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Desastre Natural em Região Norte",
                "Um grande desastre natural abalou a região norte, com chuvas fortes e alagamentos.",
                R.drawable.ic_launcher_background));
        newsList.add(new News("Economia Brasileira Apresenta Crescimento",
                "O PIB brasileiro cresceu 2,5% no último trimestre, segundo o IBGE.",
                R.drawable.ic_launcher_foreground));
        newsList.add(new News("Nova Vacina Contra Gripe Aprovada",
                "A vacina promete maior eficácia e menos efeitos colaterais.",
                R.drawable.ic_launcher_background));
        newsList.add(new News("Investimentos em Energia Solar Crescem no País",
                "O setor de energia solar atrai mais investimentos e reduz a dependência de energia elétrica.",
                R.drawable.ic_launcher_foreground));
        newsList.add(new News("Cientistas Descobrem Nova Galáxia",
                "A nova galáxia foi descoberta no sistema solar utilizando um telescópio avançado.",
                R.drawable.ic_launcher_background));

        NewsAdapter adapter = new NewsAdapter(this, newsList);
        ListView listView = findViewById(R.id.newsListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News selectedNews = newsList.get(position);
                Toast.makeText(MainActivity.this, "Selecionado: " + selectedNews.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
