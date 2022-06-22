package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Write ByteCode is used to display information to the console. The only thing Write is
 * allowed to display is the top value of the runtime stack. No other information is allowed to
 * be shown.
 *
 * • Prints the top of the runtime stack to the console.
 * • NO OTHER information can be printed by the Write ByteCode when printing the
 * value.
 * • If dumping is on, Simply print ”WRITE” to the console.
 */
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
