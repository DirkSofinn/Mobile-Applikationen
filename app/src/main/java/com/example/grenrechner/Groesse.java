package com.example.grenrechner;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Groesse {

    @PrimaryKey(autoGenerate = true)
     private int id;
    private int groesseMutter;
    private int groesseVater;
    private int groesseKind;
    private String geschlecht;

    public Groesse(int groesseMutter, int groesseVater, int groesseKind, String geschlecht){
        this.geschlecht=geschlecht;
        this.groesseMutter= groesseMutter;
        this.groesseVater= groesseVater;
        this.groesseKind= groesseKind;
    }

    public int getGroesseMutter() {
        return groesseMutter;
    }

    public void setGroesseMutter(int groesseMutter) {
        this.groesseMutter = groesseMutter;
    }

    public int getGroesseVater() {
        return groesseVater;
    }

    public void setGroesseVater(int groesseVater) {
        this.groesseVater = groesseVater;
    }

    public int getGroesseKind() {
        return groesseKind;
    }

    public void setGroesseKind(int groesseKind) {
        this.groesseKind = groesseKind;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
