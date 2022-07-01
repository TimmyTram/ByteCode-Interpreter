package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class WriteCode extends ByteCode implements Dumpable {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunTimeStack());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
