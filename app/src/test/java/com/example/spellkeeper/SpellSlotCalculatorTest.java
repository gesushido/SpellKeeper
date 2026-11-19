package com.example.spellkeeper;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.spellkeeper.data.entity.Character;
import com.example.spellkeeper.domain.calculator.SpellSlotCalculator;

public class SpellSlotCalculatorTest {

    @Test
    public void testWizardLevel5() {
        // Создаём волшебника 5 уровня
        Character wizard = new Character("Гэндальф", "Wizard", 5);

        // Считаем ячейки
        SpellSlotCalculator.calculateSlots(wizard);

        // Проверяем результат
        assertEquals(4, wizard.getSlot1());  // должно быть 4 ячейки 1 уровня
        assertEquals(3, wizard.getSlot2());  // 3 ячейки 2 уровня
        assertEquals(2, wizard.getSlot3());  // 2 ячейки 3 уровня
        assertEquals(0, wizard.getSlot4());  // 4 уровня ещё нет
    }

    @Test
    public void testWarlockLevel3() {
        Character warlock = new Character("Варлок", "Warlock", 3);

        SpellSlotCalculator.calculateSlots(warlock);

        // У колдуна 3 уровня должно быть 2 ячейки 2-го уровня
        assertEquals(0, warlock.getSlot1());
        assertEquals(2, warlock.getSlot2());
    }

    @Test
    public void testPaladinLevel5() {
        Character paladin = new Character("Паладин", "Paladin", 5);

        SpellSlotCalculator.calculateSlots(paladin);

        // Половинный заклинатель 5 уровня
        assertEquals(4, paladin.getSlot1());
        assertEquals(2, paladin.getSlot2());
        assertEquals(0, paladin.getSlot3());
    }
}