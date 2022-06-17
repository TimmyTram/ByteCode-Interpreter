package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Dump ByteCode is used to turn dumping ON and OFF. Dumping in the interpreter
 * project is only done when dumping is ON.
 *
 * • The Dump ByteCode has 1 argument. Either ”ON” or ”OFF”
 * • The Dump ByteCode must request the VirtualMachine to turn dumping either ”ON” or ”OFF”.
 * • The Dump ByteCode is NOT TO BE DUMPED.
 */
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
