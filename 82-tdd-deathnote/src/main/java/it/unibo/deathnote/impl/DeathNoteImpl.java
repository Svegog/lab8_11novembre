package it.unibo.deathnote.impl;

import it.unibo.deathnote.api.DeathNote;

/** 
 * Implementation of {@link it.unibo.deathnote.api.DeathNote}.
 */
public class DeathNoteImpl implements DeathNote {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRule(final int ruleNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'getRule'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeName(final String name) {
        throw new UnsupportedOperationException("Unimplemented method 'writeName'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean writeDeathCause(final String cause) {
        throw new UnsupportedOperationException("Unimplemented method 'writeDeathCause'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean writeDetails(final String details) {
        throw new IllegalStateException("Unimplemented method 'writeDetails'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDeathCause(final String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getDeathCause'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDeathDetails(final String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNameWritten(final String name) {
        throw new UnsupportedOperationException("Unimplemented method 'isNameWritten'");
    }
}
