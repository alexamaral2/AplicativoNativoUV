package br.com.alexjr.listviewecommerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    public ProdutoAdapter(Context context, List<Produto> produtoList) {
        super(context, 0, produtoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.produto_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.produtoImagem);
        TextView nomeView = convertView.findViewById(R.id.produtoNome);
        TextView precoView = convertView.findViewById(R.id.produtoPreco);
        TextView avaliacaoView = convertView.findViewById(R.id.produtoAvaliacao);

        imageView.setImageResource(produto.getImageResId());
        nomeView.setText(produto.getNome());
        precoView.setText(String.format("R$ %.2f", produto.getPreco()));
        avaliacaoView.setText(produto.getAvaliacao());

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SecondActivity.class);
            intent.putExtra("nome", produto.getNome());
            intent.putExtra("preco", produto.getPreco());
            intent.putExtra("imageResId", produto.getImageResId());
            intent.putExtra("avaliacao", produto.getAvaliacao());
            intent.putExtra("descricao", produto.getDescricao());
            getContext().startActivity(intent);
        });

        return convertView;
    }
}
