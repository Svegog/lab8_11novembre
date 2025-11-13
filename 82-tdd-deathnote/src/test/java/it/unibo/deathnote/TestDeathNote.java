package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;

class TestDeathNote {
 
    private static final String FIRST_VICTIM = "Piero";
    private static final String SECOND_VICTIM = "Giorgio";
    private static final String THIRD_VICTIM = "Giovanni";
    private static final String FOURTH_VICTIM = "Michelino";
    private static final String FIFTH_VICTIM = "Manuel";
    private static final long SHORT_SLEEP_TIME = 100L;
    private static final long SLEEP_TIME = 6100L;
    private DeathNote bookOfDeath;

    @BeforeEach
    void setUp() {
        bookOfDeath = new DeathNoteImpl();
    }

    @Test
    void testWrongRuleInput() {
        final int[] illegal = {-1, 0, DeathNote.RULES.size() + 1};
        for (final int i : illegal) {

            assertThrows(IllegalArgumentException.class, MakeExecutable.makeExecutableForRule(bookOfDeath, i));

        }
    }

    @Test 
    void testRuleContent() {
        String rule;
        for (int i = 1; i <= DeathNote.RULES.size(); i++) {

            rule = bookOfDeath.getRule(i);
            assertNotNull(rule);
            assertFalse(rule.isEmpty());

        }
    }

    @Test
    void testWritingName() {
        assertThrows(NullPointerException.class, MakeExecutable.makeExecutableForName(bookOfDeath, null));
        assertFalse(bookOfDeath.isNameWritten(FIRST_VICTIM));
        bookOfDeath.writeName(FIRST_VICTIM);
        assertTrue(bookOfDeath.isNameWritten(FIRST_VICTIM));
        assertFalse(bookOfDeath.isNameWritten(SECOND_VICTIM));
        assertFalse(bookOfDeath.isNameWritten(""));
    }

    @Test
    void testWritingCause() throws InterruptedException {
        assertThrows(IllegalStateException.class, MakeExecutable.makeExecutableForCause(bookOfDeath, SECOND_VICTIM)); 
        bookOfDeath.writeName(SECOND_VICTIM);
        assertTrue(bookOfDeath.isNameWritten(SECOND_VICTIM));
        assertEquals("heart attack", bookOfDeath.getDeathCause(SECOND_VICTIM));

        bookOfDeath.writeName(THIRD_VICTIM);
        assertTrue(bookOfDeath.isNameWritten(THIRD_VICTIM));
        assertTrue(bookOfDeath.writeDeathCause("karting accident"));
        assertEquals("karting accident", bookOfDeath.getDeathCause(THIRD_VICTIM));
        Thread.sleep(SHORT_SLEEP_TIME);
        assertTrue(bookOfDeath.writeDeathCause("burned to death"));
        assertNotEquals("burned to death", bookOfDeath.getDeathCause(THIRD_VICTIM));
    }

    @Test
    void testWritingDetail() throws InterruptedException {
        assertThrows(IllegalStateException.class, MakeExecutable.makeExecutableForDetails(bookOfDeath, FOURTH_VICTIM));
        bookOfDeath.writeName(FOURTH_VICTIM);
        assertTrue(bookOfDeath.isNameWritten(FOURTH_VICTIM));
        assertEquals(null, bookOfDeath.getDeathDetails(FOURTH_VICTIM));
        assertTrue(bookOfDeath.writeDetails("ran for too long"));
        assertEquals("ran for too long", bookOfDeath.getDeathCause(FOURTH_VICTIM));
        bookOfDeath.writeName(FIFTH_VICTIM);
        assertTrue(bookOfDeath.isNameWritten(FIFTH_VICTIM));
        Thread.sleep(SLEEP_TIME);
        assertFalse(bookOfDeath.writeDetails("exploded"));
    }

}
