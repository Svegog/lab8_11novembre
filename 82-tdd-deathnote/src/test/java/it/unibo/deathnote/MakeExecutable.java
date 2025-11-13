package it.unibo.deathnote;

import org.junit.jupiter.api.function.Executable;

import it.unibo.deathnote.api.DeathNote;

/**
 * Create a class whose only purpose is to have static method to return executable, used for 
 * testing {@link it.unibo.deathnote.impl.DeathNoteImpl}.
 */
final class MakeExecutable {

    /**
     * Utility class.
     */
    private MakeExecutable() { }

    /**
     * Return an Executable that test the Rule condition.
     * 
     * @param book the DeathNote implementation to work on
     * @param index the rule index to get in the method
     * @return the Executable that is used in the Assertions
     */
    static Executable makeExecutableForRule(final DeathNote book, final int index) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.getRule(index);
            }
        };
    }

    /**
     * Return an Executable that test the insert Name methods.
     * 
     * @param book the DeathNote implementation to work on
     * @param name the name of the person written on the book
     * @return the Executable that is used in the Assertions
     */
    static Executable makeExecutableForName(final DeathNote book, final String name) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.writeName(name);
            }
        };
    }

    /**
     * Return an Executable that test the Cause methods.
     * 
     * @param book the DeathNote implementation to work on
     * @param cause the cause of the death of the person
     * @return the Executable that is used in the Assertions
     */
    public static Executable makeExecutableForCause(final DeathNote book, final String cause) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.writeDeathCause(cause);
            }
        };
    }

    /**
     * Return an Executable that test the Details methods.
     * 
     * @param book the DeathNote implementation to work on
     * @param details the details of the death for a person named {@link name}
     * @return the Executable that is used in the Assertions
     */
    public static Executable makeExecutableForDetails(final DeathNote book, final String details) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.writeDetails(details);
            }
        };
    }

}
