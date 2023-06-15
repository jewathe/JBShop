package learn.android.w14exampratiquejean.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import learn.android.w14exampratiquejean.entity.Produit;
import learn.android.w14exampratiquejean.service.ConnectionDB;

public class ProduitManager {

    public static ArrayList<Produit> getAll(Context context) {
        SQLiteDatabase bd = ConnectionDB.getBd(context);
        String query = "SELECT * FROM produit";
        ArrayList<Produit> produits = null;
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.isBeforeFirst()) {
            produits = new ArrayList<>();
            while (cursor.moveToNext()) {
                Produit  produit= new Produit(0);
                produit.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                produit.setTitre(cursor.getString(cursor.getColumnIndexOrThrow("titre")));
                produit.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
                produit.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow("prix")));
                produit.setTypeMenu(cursor.getInt(cursor.getColumnIndexOrThrow("id_type_menu")));
                produit.setNomImage(cursor.getString(cursor.getColumnIndexOrThrow("nom_image")));
                produits.add(produit);
            }
        }
        return produits;
    }

    public static ArrayList<Produit> getByMenu(Context context,int id_menu) {
        SQLiteDatabase bd = ConnectionDB.getBd(context);
        String query = "SELECT * FROM produit where id_type_menu=id_menu";
        ArrayList<Produit> produits = null;
        Cursor cursor = bd.rawQuery(query, new String[]{String.valueOf(id_menu)});
        if (cursor.isBeforeFirst()) {
            produits = new ArrayList<>();
            while (cursor.moveToNext()) {
                Produit  produit= new Produit(0);
                produit.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                produit.setTitre(cursor.getString(cursor.getColumnIndexOrThrow("titre")));
                produit.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
                produit.setPrix(cursor.getFloat(cursor.getColumnIndexOrThrow("prix")));
                produit.setTypeMenu(cursor.getInt(cursor.getColumnIndexOrThrow("id_type_menu")));
                produit.setNomImage(cursor.getString(cursor.getColumnIndexOrThrow("nom_image")));
                produits.add(produit);
            }
        }
        return produits;
    }
}
