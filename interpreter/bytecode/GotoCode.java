package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class GotoCode extends BranchCode implements Dumpable {

    @Override
    public void init(List<String> args) {
        super.setLabel(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(super.getAddress());
    }

    @Override
    public String toString() {
        return "GOTO " + super.getLabel();
    }

}
