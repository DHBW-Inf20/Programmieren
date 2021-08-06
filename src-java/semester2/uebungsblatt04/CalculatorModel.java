package semester2.uebungsblatt04;

import javax.script.ScriptException;
import java.util.concurrent.atomic.AtomicReference;

final class CalculatorModel {

    private final AtomicReference<String> expression = new AtomicReference<>("");
    private final JsInterpreter interpreter = new JsInterpreter();

    String appendToAndGetExpression(final String s) {
        return expression.updateAndGet(current -> current + s);
    }

    String clearAndGetExpression() {
        final String empty = "";
        expression.set(empty);
        return empty;
    }

    String evaluateExpressionAndGetResult() {
        return expression.updateAndGet(current -> {
            try {
                return interpreter.evaluateMathExpression(current);
            } catch (ScriptException e) {
                return "Can not evaluate the following expression: \"" + current + '"';
            }
        });
    }
}
