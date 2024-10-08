package br.com.alexjr.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Contact currentContact = getItem(position);
        TextView nameTextView = convertView.findViewById(R.id.contactName);
        ImageView imageView = convertView.findViewById(R.id.contactImage);

        nameTextView.setText(currentContact.getName());
        imageView.setImageResource(currentContact.getImageResourceId());

        return convertView;
    }
}
