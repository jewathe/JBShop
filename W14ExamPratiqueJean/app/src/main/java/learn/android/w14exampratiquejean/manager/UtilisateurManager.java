package learn.android.w14exampratiquejean.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import learn.android.w14exampratiquejean.entity.Utilisateur;
import learn.android.w14exampratiquejean.service.ConnectionDB;

public class UtilisateurManager {
    public static ArrayList<Utilisateur> getAll(Context context) {
        SQLiteDatabase bd = ConnectionDB.getBd(context);
        String query = "SELECT * FROM utilisateur";
        ArrayList<Utilisateur> utilisateurs = null;
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.isBeforeFirst()) {
            utilisateurs = new ArrayList<>();
            while (cursor.moveToNext()) {
                Utilisateur  utilisateur= new Utilisateur(0);
                utilisateur.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                utilisateur.setNom(cursor.getString(cursor.getColumnIndexOrThrow("nom")));
                utilisateur.setPrenom(cursor.getString(cursor.getColumnIndexOrThrow("prenom")));
                utilisateur.setLogin(cursor.getString(cursor.getColumnIndexOrThrow("login")));
                utilisateur.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));

                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }
}
