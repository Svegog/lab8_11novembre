package it.unibo.deathnote.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote {

    private Map<String,DeathNoteImplElement> deathNoteContent;
    private Set<String> nameWritten = new HashSet<>();

    @Override
    public String getRule(int ruleNumber) {
        throw new IllegalArgumentException("Unimplemented method 'getRule'");
    }

    @Override
    public void writeName(String name) {
        throw new NullPointerException("Unimplemented method 'writeName'");
    }

    @Override
    public boolean writeDeathCause(String cause) {
        throw new UnsupportedOperationException("Unimplemented method 'writeDeathCause'");
    }

    @Override
    public boolean writeDetails(String details) {
        throw new UnsupportedOperationException("Unimplemented method 'writeDetails'");
    }

    @Override
    public String getDeathCause(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getDeathCause'");
    }

    @Override
    public String getDeathDetails(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    @Override
    public boolean isNameWritten(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'isNameWritten'");
    }

    private class DeathNoteImplElement {
        private final String cause;
        private String detail;

        public DeathNoteImplElement(String cause, String detail) {
            this.cause = cause;
            this.detail = detail;
        }

        public DeathNoteImplElement(String cause) {
            this(cause,null);
        }

        public DeathNoteImplElement() {
            this("Heart Attack", null);
        }

        public String getCause() {
            return this.cause;
        }

        public String getDetai() {
            return this.detail;
        }

    }
    
}
