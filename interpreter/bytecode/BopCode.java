package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Bop ByteCode is used to implement binary operations for the Interpreter Project. The
 * Bop ByteCode will need to remove 2 values from the runtime stack and operate on them
 * according to an operation. The result needs to be pushed back to the top of the stack. Be
 * careful, the order of the operands matter. HINT: operands will be pushed in the correct
 * order but the popped in the reverse order.
 *
 * • Bop must pop 2 values from the runtime stack.
 * • Bop must push 1 value, the result, back to the top of the runtime stack.
 * • Bop must implement the following binary operations:
 * Addition: +
 * Subtraction: −
 * Division: /
 * Multiplication: ∗
 * Equality: ==
 * Not-Equal To: ! =
 * Less-Than Equal To: <=
 * Greater Than: >
 * Greater Than Equal To: >=
 * Less Than: <
 * Logical OR: |
 * Logical AND: &
 * • If dump is on, the Bop ByteCode is required to be dumped. Examples are given in
 * this document.
 */
public class BopCode extends ByteCode {

    private String operator;

    @Override
    public void init(List<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand2 = vm.pop();
        int operand1 = vm.pop();
        // since we can only push ints onto the RunTimeStack 1 will represent true and 0 represents false
        switch(operator) { // This Switch statement requires Java 14
            case "+" -> vm.push(operand1 + operand2);
            case "-" -> vm.push(operand1 - operand2);
            case "/" -> vm.push(operand1 / operand2);
            case "*" -> vm.push(operand1 * operand2);
            case "==" -> vm.push((operand1 == operand2) ? 1 : 0);
            case "!=" -> vm.push((operand1 != operand2) ? 1 : 0);
            case "<=" -> vm.push((operand1 <= operand2) ? 1 : 0);
            case ">" -> vm.push((operand1 > operand2) ? 1 : 0);
            case ">=" -> vm.push((operand1 >= operand2) ? 1 : 0);
            case "<" -> vm.push((operand1 < operand2) ? 1 : 0);
            case "|" -> vm.push((operand1 == 1 || operand2 == 1) ? 1 : 0);
            case "&" -> vm.push((operand1 == 1 && operand2 == 1) ? 1 : 0);
        }
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
