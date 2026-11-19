package com.example.spellkeeper.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.spellkeeper.data.dao.CharacterDao;
import com.example.spellkeeper.data.entity.Character;

@Database(entities = {Character.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // Единственный экземпляр базы (чтобы не создавать много раз)
    private static AppDatabase INSTANCE;

    // Получаем доступ к командам DAO
    public abstract CharacterDao characterDao();

    // Метод, который создаёт базу (или возвращает уже созданную)
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "spellkeeper_database"   // имя файла базы на телефоне
                    )
                    .fallbackToDestructiveMigration()  // пока просто: при изменении структуры база пересоздаётся
                    .build();
        }
        return INSTANCE;
    }
}