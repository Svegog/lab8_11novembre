package it.unibo.deathnote;

import org.junit.jupiter.api.function.Executable;

import it.unibo.deathnote.api.DeathNote;

public class MakeExecutable {
    
    public static Executable makeExecutableForRule(final DeathNote book, final int index) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.getRule(index);
            }
            
        };
    }
    public static Executable makeExecutableForName(final DeathNote book, final String name) {
        return new Executable() {   
            @Override
            public void execute() throws Throwable {
                book.writeName(name);
            }
        };
    }
    public static Executable makeExecutableForCause(final DeathNote book, final String name) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.getDeathCause(name);
            }
        
        };
    }
    public static Executable makeExecutableForDetails(final DeathNote book, final String details) {
        return new Executable() {
            @Override
            public void execute() throws Throwable {
                book.writeDetails(details);
            }
        };
    }
}
