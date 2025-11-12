package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;

class TestDeathNote {

    private DeathNote bookOfDeath; 
    private final String firstVictim = "Piero";
    private final String secondVictim = "Giorgio";
    private final String thirdVictim = "Giovanni";
    private final String fourthVictim = "Michelino";
    private final String fifthVictim = "Manuel";

    @BeforeEach
    void setUp() {
        bookOfDeath = new DeathNoteImpl();
    }

    @Test
    void testWrongRuleInput() {
        int index = 0;
        while (index > -2) {
            var exception = assertThrows(IllegalArgumentException.class, MakeExecutable.makeExecutableForRule(bookOfDeath, index--));
            assertNotNull(exception.getMessage());
            assertFalse(exception.getMessage().isEmpty());
        }
        assertThrows(IllegalArgumentException.class, MakeExecutable.makeExecutableForRule(bookOfDeath, (DeathNote.RULES.size() + 1)));  
    }

    @Test 
    void testRuleContent() {
        for (String rule : DeathNote.RULES) {
            assertNotNull(rule);
            assertFalse(rule.isEmpty());
        }
    }

    @Test
    void testWritingName() {
        assertThrows(NullPointerException.class, MakeExecutable.makeExecutableForName(bookOfDeath,null));
        assertFalse(bookOfDeath.isNameWritten(firstVictim));
        bookOfDeath.writeName(firstVictim);
        assertTrue(bookOfDeath.isNameWritten(firstVictim));
        assertFalse(bookOfDeath.isNameWritten(secondVictim));
        assertFalse(bookOfDeath.isNameWritten(""));
    }

    @Test
    void testWritingCause() {
        assertThrows(IllegalStateException.class, MakeExecutable.makeExecutableForCause(bookOfDeath, secondVictim)); 
        bookOfDeath.writeName(secondVictim);
        assertTrue(bookOfDeath.isNameWritten(secondVictim));
        assertEquals("heart attack", bookOfDeath.getDeathCause(secondVictim));

        bookOfDeath.writeName(thirdVictim);
        assertTrue(bookOfDeath.isNameWritten(thirdVictim));
        assertTrue(bookOfDeath.writeDeathCause("karting accident"));
        assertEquals("karting accident", bookOfDeath.getDeathCause(thirdVictim));

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {}

        assertTrue(bookOfDeath.writeDeathCause("burned to death"));
        assertNotEquals("burned to death", bookOfDeath.getDeathCause(thirdVictim));
    }

    @Test
    void testWritingDetail() {
        assertThrows(IllegalStateException.class, MakeExecutable.makeExecutableForDetails(bookOfDeath, fourthVictim));
        bookOfDeath.writeName(fourthVictim);
        assertTrue(bookOfDeath.isNameWritten(fourthVictim));
        assertEquals(null, bookOfDeath.getDeathDetails(fourthVictim));
        assertTrue(bookOfDeath.writeDetails("ran for too long"));
        assertEquals("ran for too long", bookOfDeath.getDeathCause(fourthVictim));

        bookOfDeath.writeName(fifthVictim);
        assertTrue(bookOfDeath.isNameWritten(fifthVictim));
        
        try {
            Thread.sleep(6100L);
        } catch (InterruptedException e) {}

        assertFalse(bookOfDeath.writeDetails("exploded"));
    }

}