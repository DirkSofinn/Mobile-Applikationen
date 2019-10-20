package com.example.grenrechner;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Groesse.class}, version = 1, exportSchema = false)
public abstract class GroesseRoomDatabase extends RoomDatabase {

    public abstract GroesseDAO groesseDAO();

    private static GroesseRoomDatabase INSTANZ;

    static GroesseRoomDatabase getDatabase(Context context){
        if(INSTANZ==null){
            INSTANZ= Room.databaseBuilder(context.getApplicationContext(),GroesseRoomDatabase.class
                    ,"groesse_database").build();
        }
        return INSTANZ;
    }
}
