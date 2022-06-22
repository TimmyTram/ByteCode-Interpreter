package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;


/**
 * The Pop ByteCode will be used to remove values from the run time stack. The Pop ByteCode
 * is not allowed to remove values across frame boundaries. It is the implementers responsibility
 * to ensure that Pop is only allowed to pop the appropriate number of values. Pop has one
 * argument, N , which is the number of values to be popped. You cannot make any assumptions
 * about the value of N other than it is a strictly positive number.
 *
 * • Pop takes one argument which is the number of values to remove from the run time
 * stack.
 * • Pop is not allowed operate across frame boundaries.
 * • If dump is on, Pop is required to be dumped. Examples are given in this document.
 */
public class PopCode extends ByteCode implements Dumpable {

    private int numToRemove;
    @Override
    public void init(List<String> args) {
        numToRemove = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        // Math.min to make sure that if we pick an int larger than number of values in current frame
        // we just get rid of all values in current frame and avoid operating across frame boundaries
        int validNumToRemove = Math.min(numToRemove, vm.getNumOfValuesInCurrFrame());
        for(int i = 0; i < validNumToRemove; i++) {
            vm.popRunTimeStack();
        }
    }

    @Override
    public String toString() {
        return "POP " + numToRemove + "\n";
    }
}
