package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
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
    private String name = "Piero";

    @BeforeEach
    void setUp() {
        bookOfDeath = new DeathNoteImpl();
    }

    @Test
    void testWrongRuleInput() {
        int index = 0;
        while (index > -2) {
            var exception = assertThrows(IllegalArgumentException.class, makeExecutable(bookOfDeath, index--));
            assertNotNull(exception.getMessage());
            assertFalse(exception.getMessage().isEmpty());
        }
        assertThrows(IllegalArgumentException.class, makeExecutable(bookOfDeath, (DeathNote.RULES.size() + 1)));  
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
        assertFalse(bookOfDeath.isNameWritten(name));
        
    }

    private static Executable makeExecutable(final DeathNote book, final int index) {
            return new org.junit.jupiter.api.function.Executable() {

                @Override
                public void execute() throws Throwable {
                    book.getRule(index);
                }
                
            };
        }
}