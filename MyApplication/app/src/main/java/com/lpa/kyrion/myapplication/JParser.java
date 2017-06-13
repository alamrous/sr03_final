package com.lpa.kyrion.myapplication;

import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Client;
import beans.Country;
import beans.Editeur;
import beans.Jeu;
import beans.Jeu_Plateforme;
import beans.Panier;
import beans.Pegi;
import beans.Plateforme;

/**
 * Created by Kyrion on 11/06/2017.
 */

public class JParser {


    private JsonReader reader;

    public JParser(String json) throws UnsupportedEncodingException {
        reader = new JsonReader(new StringReader(json));
    }

    public List<Jeu> readJeuArray() throws IOException {
        List<Jeu> jeux = new ArrayList<Jeu>();

        reader.beginArray();
        while (reader.hasNext()) {
            jeux.add(readJeu());
        }
        reader.endArray();
        return jeux;
    }

    public Jeu readJeu() throws IOException {
        long id = -1;
        Jeu jeu = new Jeu();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                jeu.setId(reader.nextInt());
            } else if (name.equals("title")) {
                jeu.setTitle(reader.nextString());
            } else if (name.equals("note") && reader.peek() != JsonToken.NULL) {
                jeu.setNote(reader.nextDouble());
            } else if (name.equals("summary")) {
                jeu.setSummary(reader.nextString());
            } else if (name.equals("date_sortie")) {
            jeu.setDate_sortie(readDate());
            }else if (name.equals("fk_editeur")) {
                jeu.setFk_editeur(readEditeur());
            }else if (name.equals("fk_pegi")) {
                jeu.setFk_pegi(readPegi());
            }else if (name.equals("plateforme")) {
                jeu.setPlateforme(readPlateforme());
            }else if (name.equals("jeu_fk")) {
                jeu.setPlateforme_jeu_fk(reader.nextInt());
            }
            else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return jeu;
    }

    public Date readDate() throws IOException {
        Date date = new Date();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("time")) {
                date.setTime(reader.nextLong());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return  date;
    }

    public Editeur readEditeur() throws IOException {
       Editeur editeur = new Editeur();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("description")) {
                editeur.setDescription(reader.nextString());
            } else if (name.equals("id")) {
                editeur.setId(reader.nextInt());
            } else if (name.equals("country_fk")) {
                editeur.setCountry_fk(readCountry());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return editeur;
    }

    public Country readCountry() throws IOException {
        Country country = new Country();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("nom")) {
                country.setNom(reader.nextString());
            } else if (name.equals("id")) {
                country.setId(reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return country;
    }

    public Pegi readPegi() throws IOException {
        Pegi pegi = new Pegi();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("description")) {
                pegi.setDescription(reader.nextString());
            } else if (name.equals("id")) {
                pegi.setId(reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return pegi;
    }

    public Plateforme readPlateforme() throws IOException {
        Plateforme plateforme = new Plateforme();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                plateforme.setName(reader.nextString());
            } else if (name.equals("id")) {
                plateforme.setId(reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return plateforme;
    }

    public Jeu_Plateforme readJeu_Plateforme() throws IOException{
        Jeu_Plateforme jp = new Jeu_Plateforme();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("jeu")) {
                jp.setJeu(readJeu());
            } else if (name.equals("plateforme")) {
                jp.setPlateforme(readPlateforme());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return jp;
    }

    public Client readClient(JsonReader reader) throws IOException{
        Client client = new Client();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                client.setName(reader.nextString());
            } else if (name.equals("id")) {
                client.setId(reader.nextInt());
            } else if (name.equals("address")) {
               client.setAddress(reader.nextString());
            } else if (name.equals("birthDate")) {
                client.setBirthdate(readDate());
            } else if (name.equals("dateCreation")) {
                client.setDate_creation(readDate());
            } else if (name.equals("email")) {
                client.setEmail(reader.nextString());
            } else if (name.equals("firstName")) {
                client.setFirstname(reader.nextString());
            } else if (name.equals("gender")) {
                client.setGender(reader.nextString());
            } else if (name.equals("pseudo")) {
                client.setPseudo(reader.nextString());
            } else if (name.equals("pwd")) {
                client.setPwd(reader.nextString());
            } else if (name.equals("state")) {
                client.setState(reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return client;
    }

    public Panier readPanier() throws IOException{
        Panier panier = new Panier();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("jeu")) {
                panier.setJeu(readJeu());
            } else if (name.equals("id")) {
                panier.setId(reader.nextInt());
            } else if (name.equals("client_fk")) {
                panier.setClient_fk(reader.nextInt());
            } else if (name.equals("date_creation")) {
                panier.setDate_creation(readDate());
            } else if (name.equals("date_achat")) {
                panier.setDate_achat(readDate());
            }   else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return panier;
    }
}
