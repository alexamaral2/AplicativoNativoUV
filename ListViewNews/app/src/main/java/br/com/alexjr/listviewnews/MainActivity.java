package br.com.alexjr.listviewnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
                "20 Oct 2024", R.drawable.ic_launcher_background,
                "Um grande desastre natural abalou a região norte do país, causando chuvas fortes, alagamentos em diversas cidades, e afetando milhares de pessoas. As autoridades estão trabalhando para fornecer ajuda emergencial e reconstruir as áreas danificadas.",
                "Por Delis Ortiz, TV Globo — Brasília"));

        newsList.add(new News("Economia Brasileira Apresenta Crescimento",
                "O PIB brasileiro cresceu 2,5% no último trimestre, segundo o IBGE.",
                "19 Oct 2024", R.drawable.ic_launcher_foreground,
                "O Produto Interno Bruto (PIB) brasileiro apresentou um crescimento de 2,5% no último trimestre. Este aumento é atribuído a setores como agricultura, tecnologia e serviços, e traz um cenário mais otimista para a economia do país.",
                "Por Pedro Santos, Estadão — São Paulo"));

        newsList.add(new News("Nova Vacina Contra Gripe Aprovada",
                "A vacina promete maior eficácia e menos efeitos colaterais.",
                "18 Oct 2024", R.drawable.ic_launcher_background,
                "A nova vacina contra gripe foi recentemente aprovada pela Anvisa e promete uma maior eficácia na prevenção da doença, além de apresentar menos efeitos colaterais. A vacina estará disponível nas redes públicas e privadas de saúde em breve.",
                "Por Maria Silva, Folha de S.Paulo — Rio de Janeiro"));

        newsList.add(new News("Investimentos em Energia Solar Crescem no País",
                "O setor de energia solar atrai mais investimentos e reduz a dependência de energia elétrica.",
                "17 Oct 2024", R.drawable.ic_launcher_foreground,
                "O setor de energia solar no Brasil está em franco crescimento, atraindo cada vez mais investimentos nacionais e internacionais. Isso ajuda a reduzir a dependência do país em energia elétrica tradicional e promove um futuro mais sustentável.",
                "Por João Oliveira, Agência Brasil — Brasília"));

        newsList.add(new News("Cientistas Descobrem Nova Galáxia",
                "A nova galáxia foi descoberta no sistema solar utilizando um telescópio avançado.",
                "16 Oct 2024", R.drawable.ic_launcher_background,
                "Uma equipe de cientistas anunciou a descoberta de uma nova galáxia localizada nas proximidades do sistema solar. Utilizando um telescópio de alta potência, eles conseguiram identificar características únicas e fascinantes sobre essa galáxia.",
                "Por Ana Pereira, BBC — Londres"));

        NewsAdapter adapter = new NewsAdapter(this, newsList);
        ListView listView = findViewById(R.id.newsListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News selectedNews = newsList.get(position);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", selectedNews.getTitle());
                intent.putExtra("description", selectedNews.getDescription());
                intent.putExtra("newsDate", selectedNews.getNewsDate());
                intent.putExtra("imageResId", selectedNews.getImageResId());
                intent.putExtra("fullText", selectedNews.getFullText());
                intent.putExtra("author", selectedNews.getAuthor());

                startActivity(intent);
            }
        });
    }
}
