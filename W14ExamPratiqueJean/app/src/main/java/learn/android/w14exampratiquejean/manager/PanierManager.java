package learn.android.w14exampratiquejean.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import learn.android.w14exampratiquejean.entity.Panier;
import learn.android.w14exampratiquejean.service.ConnectionDB;

public class PanierManager {
    public static ArrayList<Panier> getAll(Context context) {
        SQLiteDatabase bd = ConnectionDB.getBd(context);
        String query = "SELECT * FROM panier ";
        ArrayList<Panier> paniers = null;
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.isBeforeFirst()) {
            paniers=new ArrayList<>();
            while (cursor.moveToNext()) {
                Panier  panier= new Panier(0);
                panier.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                panier.setProduit(cursor.getInt(cursor.getColumnIndexOrThrow("id_produit")));
                panier.setQuantite(cursor.getInt(cursor.getColumnIndexOrThrow("quantite")));

                paniers.add(panier);
            }
        }
        return paniers;
    }
}
