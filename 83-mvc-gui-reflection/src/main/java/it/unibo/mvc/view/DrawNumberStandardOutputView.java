package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import static java.lang.System.out;

/**
 * View for output only in STD out.
 */
public class DrawNumberStandardOutputView implements DrawNumberView {

    /**
     * {@inheritDoc}
     */
    @Override
    public void setController(final DrawNumberController observer) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        out.println("============ STDOUT VIEW STARTING ============");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void result(final DrawResult res) {
        out.println(res.getDescription());
    }
}
