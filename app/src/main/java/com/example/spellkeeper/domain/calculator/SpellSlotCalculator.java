package com.example.spellkeeper.domain.calculator;

import com.example.spellkeeper.data.entity.Character;

public class SpellSlotCalculator {

    /**
     * Заполняет персонажа правильным количеством ячеек
     * в зависимости от его класса и уровня.
     */
    public static void calculateSlots(Character character) {
        String characterClass = character.getCharacterClass();
        int level = character.getLevel();

        // Сначала обнуляем все ячейки
        character.setSlot1(0);
        character.setSlot2(0);
        character.setSlot3(0);
        character.setSlot4(0);
        character.setSlot5(0);
        character.setSlot6(0);
        character.setSlot7(0);
        character.setSlot8(0);
        character.setSlot9(0);

        // Пока сделаем упрощённый расчёт для нескольких классов
        // Позже можно будет улучшить

        if (characterClass.equalsIgnoreCase("Wizard") ||
                characterClass.equalsIgnoreCase("Cleric") ||
                characterClass.equalsIgnoreCase("Druid") ||
                characterClass.equalsIgnoreCase("Волшебник") ||
                characterClass.equalsIgnoreCase("Жрец") ||
                characterClass.equalsIgnoreCase("Друид")) {

            // Полные заклинатели (Wizard, Cleric, Druid)
            setFullCasterSlots(character, level);

        } else if (characterClass.equalsIgnoreCase("Sorcerer") ||
                characterClass.equalsIgnoreCase("Bard") ||
                characterClass.equalsIgnoreCase("Чародей") ||
                characterClass.equalsIgnoreCase("Бард")) {

            // Тоже полные заклинатели
            setFullCasterSlots(character, level);

        } else if (characterClass.equalsIgnoreCase("Paladin") ||
                characterClass.equalsIgnoreCase("Ranger") ||
                characterClass.equalsIgnoreCase("Паладин") ||
                characterClass.equalsIgnoreCase("Следопыт")) {

            // Половинные заклинатели
            setHalfCasterSlots(character, level);

        } else if (characterClass.equalsIgnoreCase("Warlock") ||
                characterClass.equalsIgnoreCase("Колдун")) {

            // Колдун — особый случай
            setWarlockSlots(character, level);

        } else {
            // Если класс неизвестен — ничего не делаем
        }
    }

    // ===== Полные заклинатели (Wizard, Cleric, Druid, Bard, Sorcerer) =====
    private static void setFullCasterSlots(Character character, int level) {
        if (level >= 1) character.setSlot1(2);
        if (level >= 2) character.setSlot1(3);
        if (level >= 3) {
            character.setSlot1(4);
            character.setSlot2(2);
        }
        if (level >= 4) character.setSlot2(3);
        if (level >= 5) {
            character.setSlot1(4);
            character.setSlot2(3);
            character.setSlot3(2);
        }
        if (level >= 6) character.setSlot3(3);
        if (level >= 7) {
            character.setSlot4(1);
        }
        if (level >= 8) character.setSlot4(2);
        if (level >= 9) {
            character.setSlot4(3);
            character.setSlot5(1);
        }
        if (level >= 10) character.setSlot5(2);
        if (level >= 11) character.setSlot6(1);
        if (level >= 13) character.setSlot7(1);
        if (level >= 15) character.setSlot8(1);
        if (level >= 17) character.setSlot9(1);
        if (level >= 19) character.setSlot6(2);
        if (level >= 20) character.setSlot7(2);
    }

    // ===== Половинные заклинатели (Paladin, Ranger) =====
    private static void setHalfCasterSlots(Character character, int level) {
        if (level >= 2) character.setSlot1(2);
        if (level >= 3) character.setSlot1(3);
        if (level >= 5) {
            character.setSlot1(4);
            character.setSlot2(2);
        }
        if (level >= 7) character.setSlot2(3);
        if (level >= 9) {
            character.setSlot3(2);
        }
        if (level >= 11) character.setSlot3(3);
        if (level >= 13) character.setSlot4(1);
        if (level >= 15) character.setSlot4(2);
        if (level >= 17) character.setSlot4(3);
        if (level >= 19) character.setSlot5(1);
    }

    // ===== Колдун (Warlock) — особая система =====
    private static void setWarlockSlots(Character character, int level) {
        if (level >= 1) {
            character.setSlot1(1); // На 1 уровне 1 ячейка 1-го уровня
        }
        if (level >= 2) {
            character.setSlot1(2);
        }
        if (level >= 3) {
            // С 3 уровня ячейки становятся 2-го уровня
            character.setSlot1(0);
            character.setSlot2(2);
        }
        if (level >= 5) {
            character.setSlot2(0);
            character.setSlot3(2);
        }
        if (level >= 7) {
            character.setSlot3(0);
            character.setSlot4(2);
        }
        if (level >= 9) {
            character.setSlot4(0);
            character.setSlot5(2);
        }
        if (level >= 11) {
            character.setSlot5(3); // С 11 уровня 3 ячейки
        }
        if (level >= 17) {
            character.setSlot5(4); // С 17 уровня 4 ячейки
        }
    }
}