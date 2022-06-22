package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;


/**
 * The HALT ByteCode is used to alert the virtual machine that program execution is to be
 * stopped. Halt is not allowed to kill the interpreter program. Therefore, Halt may not call
 * System.out.exit to stop the execution of the program.
 *
 * • Notify the VirtualMachine that execution needs to be Halted.
 * • Halt takes no arguments.
 * • Halt ByteCodes are not be Dumped.
 * • Halt cannot execute a system.exit function call.
 */
public class HaltCode extends ByteCode implements Dumpable {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltExecution();
    }

    @Override
    public String toString() {
        return "HALT ";
    }
}
