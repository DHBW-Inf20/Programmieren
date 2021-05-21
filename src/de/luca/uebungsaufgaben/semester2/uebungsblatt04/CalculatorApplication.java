package de.luca.uebungsaufgaben.semester2.uebungsblatt04;

import java.util.concurrent.atomic.AtomicBoolean;

public final class CalculatorApplication {

    private final CalculatorModel model = new CalculatorModel();
    private final CalculatorView view = new CalculatorView();
    private final CalculatorPresenter presenter = new CalculatorPresenter(model, view);

    private final AtomicBoolean startedFlag = new AtomicBoolean(false);

    public void start() {
        if (startedFlag.compareAndSet(false, true)) {
            presenter.initializeListeners();
            view.startDisplaying();
        }
    }


    public static void main(String[] args) {
        new CalculatorApplication().start();
    }
}
