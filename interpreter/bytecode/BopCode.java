package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class BopCode extends ByteCode implements Dumpable {

    private String operator;

    @Override
    public void init(List<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand2 = vm.popRunTimeStack();
        int operand1 = vm.popRunTimeStack();
        switch(operator) {
            case "+" -> vm.pushRunTimeStack(operand1 + operand2);
            case "-" -> vm.pushRunTimeStack(operand1 - operand2);
            case "/" -> vm.pushRunTimeStack(operand1 / operand2);
            case "*" -> vm.pushRunTimeStack(operand1 * operand2);
            case "==" -> vm.pushRunTimeStack((operand1 == operand2) ? 1 : 0);
            case "!=" -> vm.pushRunTimeStack((operand1 != operand2) ? 1 : 0);
            case "<=" -> vm.pushRunTimeStack((operand1 <= operand2) ? 1 : 0);
            case ">" -> vm.pushRunTimeStack((operand1 > operand2) ? 1 : 0);
            case ">=" -> vm.pushRunTimeStack((operand1 >= operand2) ? 1 : 0);
            case "<" -> vm.pushRunTimeStack((operand1 < operand2) ? 1 : 0);
            case "|" -> vm.pushRunTimeStack((operand1 == 1 || operand2 == 1) ? 1 : 0);
            case "&" -> vm.pushRunTimeStack((operand1 == 1 && operand2 == 1) ? 1 : 0);
        }
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
