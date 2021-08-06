package semester2.uebungsblatt04;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsInterpreter {

    private static final ScriptEngineManager MANGER = new ScriptEngineManager();


    private final ScriptEngine engine = MANGER.getEngineByName("JavaScript");

    public String evaluateMathExpression(String expression) throws ScriptException {
        final Object result = engine.eval(expression);
        return result == null ? "" : result.toString();
    }
}
