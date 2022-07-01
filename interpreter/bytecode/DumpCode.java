package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class DumpCode extends ByteCode {
    private String dumpStatus;

    @Override
    public void init(List<String> args) {
        this.dumpStatus = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumping("ON".equals(dumpStatus));
    }
}
