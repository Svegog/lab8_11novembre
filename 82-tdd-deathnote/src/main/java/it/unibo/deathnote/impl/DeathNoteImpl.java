package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote {

    Map<String,DeathNoteDetail> deathNoteContent = new HashMap<>();

    @Override
    public String getRule(int ruleNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'getRule'");
    }

    @Override
    public void writeName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'writeName'");
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
    
    private class DeathNoteDetail {
        private String cause = null;
        private String detail = null;

        public void setDeathCause(String cause) {
            this.cause = cause;
        }

        public String getDeathCause() {
            return this.cause;
        }

        public void setDeathDetail(String detail) {
            this.detail = detail;
        }

        public String getDeathDetail() {
            return this.detail;
        }
    }
}
