package com.example.spellkeeper.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "characters")
public class Character {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;          // Имя персонажа
    private String characterClass; // Класс (Wizard, Cleric и т.д.)
    private int level;            // Уровень от 1 до 20

    // Текущее количество оставшихся ячеек (пока сделаем просто)
    private int slot1;
    private int slot2;
    private int slot3;
    private int slot4;
    private int slot5;
    private int slot6;
    private int slot7;
    private int slot8;
    private int slot9;

    // Пустой конструктор (нужен для Room)
    public Character() {
    }

    // Конструктор для удобного создания
    public Character(String name, String characterClass, int level) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
    }

    // ===== Геттеры и сеттеры =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSlot1() { return slot1; }
    public void setSlot1(int slot1) { this.slot1 = slot1; }

    public int getSlot2() { return slot2; }
    public void setSlot2(int slot2) { this.slot2 = slot2; }

    public int getSlot3() { return slot3; }
    public void setSlot3(int slot3) { this.slot3 = slot3; }

    public int getSlot4() { return slot4; }
    public void setSlot4(int slot4) { this.slot4 = slot4; }

    public int getSlot5() { return slot5; }
    public void setSlot5(int slot5) { this.slot5 = slot5; }

    public int getSlot6() { return slot6; }
    public void setSlot6(int slot6) { this.slot6 = slot6; }

    public int getSlot7() { return slot7; }
    public void setSlot7(int slot7) { this.slot7 = slot7; }

    public int getSlot8() { return slot8; }
    public void setSlot8(int slot8) { this.slot8 = slot8; }

    public int getSlot9() { return slot9; }
    public void setSlot9(int slot9) { this.slot9 = slot9; }
}