package learn.android.w14exampratiquejean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import java.util.List;

import learn.android.w14exampratiquejean.adapter.ProduitAdapter;
import learn.android.w14exampratiquejean.entity.Produit;
import learn.android.w14exampratiquejean.manager.ProduitManager;
import learn.android.w14exampratiquejean.service.ConnectionDB;

public class MainActivity extends AppCompatActivity {
    Context context;
    GridView listView;
    TextView tvSoir,tvBrunch,tvDesserts,tvPanier;
    ProduitAdapter produitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        tvSoir=findViewById(R.id.tv_midi_soir);
        tvBrunch=findViewById(R.id.tv_brunch);
        tvDesserts=findViewById(R.id.tv_desserts);
        tvPanier=findViewById(R.id.tv_panier);
        ConnectionDB.cpyDataBaseFromAsset(context);
        List<Produit> produits= ProduitManager.getAll(context);
        listView = findViewById(R.id.lv_main);
        produitAdapter = new ProduitAdapter(context, R.layout.produit_layout, produits);
        listView.setAdapter(produitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produit produit=(Produit)adapterView.getItemAtPosition(i);
               view.setTag("id");
            }
        });
        tvSoir.setOnClickListener((view) -> {
            ProduitManager.getByMenu(context,0);
        });
        tvBrunch.setOnClickListener((view) -> {
            ProduitManager.getByMenu(context,0);
        });
        tvDesserts.setOnClickListener((view) -> {
            ProduitManager.getByMenu(context,0);
        });
        tvDesserts.setOnClickListener((view) -> {
            finish();
        });
        tvPanier.setOnClickListener((view) -> {
            Intent intent=new Intent(context,PanierActivity.class);
            startActivity(intent);
        });
    }
}