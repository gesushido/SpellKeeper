package com.example.spellkeeper.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.spellkeeper.data.entity.Character;

import java.util.List;

@Dao
public interface CharacterDao {

    // Сохранить нового персонажа
    @Insert
    void insert(Character character);

    // Обновить существующего персонажа
    @Update
    void update(Character character);

    // Удалить персонажа
    @Delete
    void delete(Character character);

    // Получить всех персонажей
    @Query("SELECT * FROM characters")
    List<Character> getAllCharacters();

    // Получить одного персонажа по id
    @Query("SELECT * FROM characters WHERE id = :id")
    Character getCharacterById(int id);

    // Удалить всех персонажей (пригодится для тестов)
    @Query("DELETE FROM characters")
    void deleteAll();
}