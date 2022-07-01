package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class ArgsCode extends ByteCode implements Dumpable {

    private int numOfArgs;

    @Override
    public void init(List<String> args) {
        numOfArgs = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(numOfArgs);
    }

    @Override
    public String toString() {
        return "ARGS " + numOfArgs;
    }
}
