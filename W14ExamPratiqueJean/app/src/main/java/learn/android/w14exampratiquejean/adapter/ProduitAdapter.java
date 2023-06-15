package learn.android.w14exampratiquejean.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.List;

import learn.android.w14exampratiquejean.R;
import learn.android.w14exampratiquejean.entity.Produit;

public class ProduitAdapter extends ArrayAdapter<Produit> {
    int idLayout;
    public ProduitAdapter(@NonNull Context context, int resource, @NonNull List<Produit> objects) {
        super(context, resource, objects);
        idLayout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produit produit = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(idLayout, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.img_produit_layout);
        TextView textView = convertView.findViewById(R.id.tv_produit_layout);

        textView.setText(""+produit.getTitre());

        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContext().getAssets().open("img/"+produit.getNomImage()));
            imageView.setImageBitmap(bitmap);
            imageView.setTag(""+produit.getTypeMenu());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return convertView;
    }
}
