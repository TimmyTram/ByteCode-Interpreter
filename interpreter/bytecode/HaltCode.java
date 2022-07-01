package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class HaltCode extends ByteCode {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltExecution();
    }

}
