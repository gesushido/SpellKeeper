package com.example.spellkeeper;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spellkeeper.data.database.AppDatabase;
import com.example.spellkeeper.data.entity.Character;
import com.example.spellkeeper.domain.calculator.SpellSlotCalculator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получаем базу данных
        AppDatabase db = AppDatabase.getInstance(this);

        // Создаём нового персонажа
        Character wizard = new Character("Гэндальф", "Wizard", 5);

        // Считаем ячейки
        SpellSlotCalculator.calculateSlots(wizard);

        // Сохраняем в базу в отдельном потоке
        new Thread(() -> {
            db.characterDao().insert(wizard);

            // Читаем всех персонажей
            List<Character> all = db.characterDao().getAllCharacters();

            // Выводим в Logcat
            for (Character c : all) {
                Log.d("SpellKeeper", "Персонаж: " + c.getName()
                        + ", класс: " + c.getCharacterClass()
                        + ", уровень: " + c.getLevel()
                        + ", ячейки 1 ур: " + c.getSlot1()
                        + ", 2 ур: " + c.getSlot2()
                        + ", 3 ур: " + c.getSlot3());
            }
        }).start();
    }
}