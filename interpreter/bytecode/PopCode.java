package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

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
        return "POP " + numToRemove;
    }
}
