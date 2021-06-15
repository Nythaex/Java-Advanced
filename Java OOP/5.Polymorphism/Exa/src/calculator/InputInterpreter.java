package calculator;

import calculator.Interfaces.Operation;
import calculator.Operations.DivideOperation;
import calculator.Operations.MultiplicationOperation;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> memory;

    public ArrayDeque<Integer> getMemory() {
        return memory;
    }

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        memory=new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            if (input.equals("ms")){
               memory.push(engine.getCurrentResult());
            }else if (input.equals("mr")){
                engine.pushNumber(memory.pop());
            }
            else {
                engine.pushOperation(this.getOperation(input));
            }
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }else if (operation.equals("/")) {
            return new DivideOperation();
        }
        return null;
    }
}
