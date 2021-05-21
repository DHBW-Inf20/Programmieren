package de.luca.uebungsaufgaben.semester2.uebungsblatt04;

final class CalculatorPresenter {

    private final CalculatorModel model;
    private final CalculatorView view;

    CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    void initializeListeners() {
        view.button0.addActionListener(a -> appendToExpressionAndUpdateView("0"));
        view.button1.addActionListener(a -> appendToExpressionAndUpdateView("1"));
        view.button2.addActionListener(a -> appendToExpressionAndUpdateView("2"));
        view.button3.addActionListener(a -> appendToExpressionAndUpdateView("3"));
        view.button4.addActionListener(a -> appendToExpressionAndUpdateView("4"));
        view.button5.addActionListener(a -> appendToExpressionAndUpdateView("5"));
        view.button6.addActionListener(a -> appendToExpressionAndUpdateView("6"));
        view.button7.addActionListener(a -> appendToExpressionAndUpdateView("7"));
        view.button8.addActionListener(a -> appendToExpressionAndUpdateView("8"));
        view.button9.addActionListener(a -> appendToExpressionAndUpdateView("9"));

        view.multiplyButton.addActionListener(a -> appendToExpressionAndUpdateView("*"));
        view.divideButton.addActionListener(a -> appendToExpressionAndUpdateView("/"));
        view.addButton.addActionListener(a -> appendToExpressionAndUpdateView("+"));
        view.subtractButton.addActionListener(a -> appendToExpressionAndUpdateView("-"));

        view.clearButton.addActionListener(a -> clearExpressionAndUpdateView());

        view.evaluateButton.addActionListener(a -> evaluateExpressionAndUpdateView());
    }

    private void appendToExpressionAndUpdateView(String s) {
        view.expression.setText(model.appendToAndGetExpression(s));
    }

    private void clearExpressionAndUpdateView() {
        view.expression.setText(model.clearAndGetExpression());
    }

    private void evaluateExpressionAndUpdateView() {
        view.expression.setText(model.evaluateExpressionAndGetResult());
    }
}
