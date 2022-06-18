package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The FalseBranch ByteCode will be used to execute conditional jumps( think of executing
 * control structures like if-statements and loops). FalseBranch will have one argument. This
 * argument is a Label that will mark a place in the program to jump to. FalseBranch will
 * remove the top value of the run time stack and check to see if the value is 0. If the value is 0,
 * 6
 * jump the corresponding label. If the value is something else, move to the next ByteCode in
 * the program. FalseBranch will need to have its label address calculated before the program
 * begins executing. This requires finding where the destination of the jump is going to be
 * numerically(address in the program) in the program.

 * • FalseBranch takes one argument, a label to jump to.
 * • FalseBranch’s label address will need to be resolved. This requires computing where
 * FalseBranch will jump to if the value popped from the stack is 0. Address resolution
 * needs to be done before you began executing the program. This will be discussed later
 * in this document.
 * • Remove the top value of the stack.
 * – if value is 0, jump to label.
 * – if value is not 0, move to next ByteCode.
 * • If dump is on, FalseBranch ByteCode is required to be dumped. Examples are given
 * later in this document.
 */
public class FalseBranchCode extends ByteCode {

    private String label;
    private int location;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.pop() == 0) {
            vm.setProgramCounter(this.location);
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
        return this.location;
    }

}
