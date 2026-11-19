package com.example.spellkeeper;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.spellkeeper.data.entity.Character;
import com.example.spellkeeper.domain.calculator.SpellSlotCalculator;

public class SpellSlotCalculatorTest {

    @Test
    public void testWizardLevel1() {
        Character wizard = new Character("Новичок", "Wizard", 1);
        SpellSlotCalculator.calculateSlots(wizard);

        assertEquals(2, wizard.getSlot1());
        assertEquals(0, wizard.getSlot2());
        assertEquals(0, wizard.getSlot3());
    }

    @Test
    public void testWizardLevel5() {
        Character wizard = new Character("Гэндальф", "Wizard", 5);
        SpellSlotCalculator.calculateSlots(wizard);

        assertEquals(4, wizard.getSlot1());
        assertEquals(3, wizard.getSlot2());
        assertEquals(2, wizard.getSlot3());
        assertEquals(0, wizard.getSlot4());
    }

    @Test
    public void testWizardLevel20() {
        Character wizard = new Character("Архимаг", "Wizard", 20);
        SpellSlotCalculator.calculateSlots(wizard);

        assertEquals(4, wizard.getSlot1());
        assertEquals(3, wizard.getSlot2());
        assertEquals(3, wizard.getSlot3());
        assertEquals(3, wizard.getSlot4());
        assertEquals(2, wizard.getSlot5());
        assertEquals(2, wizard.getSlot6());
        assertEquals(2, wizard.getSlot7());
        assertEquals(1, wizard.getSlot8());
        assertEquals(1, wizard.getSlot9());
    }

    @Test
    public void testWarlockLevel1() {
        Character warlock = new Character("Новичок", "Warlock", 1);
        SpellSlotCalculator.calculateSlots(warlock);

        assertEquals(1, warlock.getSlot1());
        assertEquals(0, warlock.getSlot2());
    }

    @Test
    public void testWarlockLevel5() {
        Character warlock = new Character("Варлок", "Warlock", 5);
        SpellSlotCalculator.calculateSlots(warlock);

        assertEquals(0, warlock.getSlot1());
        assertEquals(0, warlock.getSlot2());
        assertEquals(2, warlock.getSlot3());
    }

    @Test
    public void testPaladinLevel5() {
        Character paladin = new Character("Паладин", "Paladin", 5);
        SpellSlotCalculator.calculateSlots(paladin);

        assertEquals(4, paladin.getSlot1());
        assertEquals(2, paladin.getSlot2());
        assertEquals(0, paladin.getSlot3());
    }

    @Test
    public void testClericLevel3() {
        Character cleric = new Character("Жрец", "Cleric", 3);
        SpellSlotCalculator.calculateSlots(cleric);

        assertEquals(4, cleric.getSlot1());
        assertEquals(2, cleric.getSlot2());
    }

    @Test
    public void testUnknownClass() {
        Character unknown = new Character("Кто-то", "Barbarian", 5);
        SpellSlotCalculator.calculateSlots(unknown);

        // У неизвестного класса все ячейки должны остаться 0
        assertEquals(0, unknown.getSlot1());
        assertEquals(0, unknown.getSlot2());
        assertEquals(0, unknown.getSlot3());
    }
}