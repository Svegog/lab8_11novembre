package it.unibo.deathnote.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import it.unibo.deathnote.api.DeathNote;

/** 
 * Implementation of {@link it.unibo.deathnote.api.DeathNote}.
 */
public class DeathNoteImpl implements DeathNote {

    private static final long CAUSE_TIME_LIMIT = 40;
    private static final long DETAILS_TIME_LIMIT = 6040;

    private final Map<String, DeathNoteImplElem> deathNoteContent;

    private long timePassed;
    private String currentName;

    /**
     * Constructor with no parameters.
     */
    public DeathNoteImpl() {
        this.deathNoteContent = new HashMap<>();
        this.currentName = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRule(final int ruleNumber) {
        if (ruleNumber <= 0 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException("The rule number " 
                                                + ruleNumber + " does not exit");
        }
        return RULES.get(ruleNumber - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeName(final String name) {
        Objects.requireNonNull(name);
        if ("".equals(name)) {
            throw new IllegalArgumentException("The empty string is not a valid person to kill!");
        }
        deathNoteContent.put(name, new DeathNoteImplElem());
        this.currentName = name;
        this.timerStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean writeDeathCause(final String cause) {
        if (cause == null) {
            throw new IllegalStateException("The death cause passed is null");
        } else if (deathNoteContent.keySet().isEmpty()) {
            throw new IllegalStateException("No name is written on the Death Note");
        }
        if (deathNoteContent.containsKey(this.currentName) && this.getTimePassed() <= CAUSE_TIME_LIMIT) {
            deathNoteContent.get(this.currentName).setCause(cause);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean writeDetails(final String details) {
        if (details == null) {
            throw new IllegalStateException("The datails of the death is null");
        } else if (deathNoteContent.keySet().isEmpty()) {
            throw new IllegalStateException("No name is written on the Death Note");
        }
        if (deathNoteContent.containsKey(this.currentName) && this.getTimePassed() <= DETAILS_TIME_LIMIT) {
            deathNoteContent.get(this.currentName).setDetail(details);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDeathCause(final String name) {
        if (!deathNoteContent.containsKey(name)) {
            throw new IllegalArgumentException("No person with the name " + name + " is written on the DeathNote");
        }
        return deathNoteContent.get(name).getCause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDeathDetails(final String name) {
        if (!deathNoteContent.containsKey(name)) {
            throw new IllegalArgumentException("No person with the name " + name + " is written on the DeathNote");
        }
        final String result = deathNoteContent.get(name).getDetail();
        return result != null ? result : "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNameWritten(final String name) {
        return deathNoteContent.containsKey(name);
    }

    private void timerStart() {
        this.timePassed = System.currentTimeMillis();
    }

    private long getTimePassed() {
        return System.currentTimeMillis() - this.timePassed;
    }

    private final class DeathNoteImplElem {
        private String cause = "heart attack";
        private String detail;

        public void setCause(final String cause) {
            this.cause = cause;
        }

        public void setDetail(final String detail) {
            this.detail = detail;
        }

        public String getCause() {
            return this.cause;
        }

        public String getDetail() {
            return this.detail;
        }
    }
}
