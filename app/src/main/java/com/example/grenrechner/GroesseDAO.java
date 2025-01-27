package com.example.grenrechner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GroesseDAO {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Groesse groesse);

    @Query("SELECT * from Groesse")
    List<Groesse> getAll();

    @Delete
    void delete(Groesse groesse);
}
