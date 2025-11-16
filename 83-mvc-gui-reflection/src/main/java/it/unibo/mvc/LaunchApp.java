package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) 
        throws
        ClassNotFoundException, NoSuchMethodException,
        InvocationTargetException, InstantiationException, IllegalAccessException {
        final int repetitionValue = 3;
        final var viewListName = List.of("StandardOutputView", "SwingView");
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);

        for (final String views : viewListName) {
            final var classToLoad = Class.forName("it.unibo.mvc.view.DrawNumber" + views);
            for (int i = 0; i < repetitionValue; i++) {
                final var nextView = classToLoad.getConstructor().newInstance();
                if (DrawNumberView.class.isAssignableFrom(nextView.getClass())) {
                    app.addView((DrawNumberView) nextView);
                } else {
                    throw new IllegalStateException("Something with reflection went wrong");
                }
            }
        }
    }
}
