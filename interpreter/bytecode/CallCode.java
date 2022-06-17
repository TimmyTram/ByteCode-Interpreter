package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Call ByteCode is what the VirtualMachine uses to jump to locations in the program to
 * execute sections of code we call Functions. When encountered the Call ByteCode will jump
 * to the corresponding label in the program. The ByteCde is also responsible of keeping track
 * of where control should return to when a function completes its execution.
 * 9
 *
 * • Call ByteCode takes 1 argument, a label to jump to.
 * • Call Code must go through address resolution to figure out where it needs to jump to
 * in the Program before the program is ran.
 * • Call Code must store a return address onto the Return Address Stack.
 * • Call Code must Jump the address in the program that corresponds to a label code
 * (this address is computed during address resolution).
 * • If dumping is on, the Call ByteCode needs to be dumped according the specifications
 * in the Dumping formats section
 */
public class CallCode extends ByteCode {

    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        // TODO: Implement Virtual Machine RETURN ADDRESS STACK
    }

    @Override
    public String toString() {
        // TODO: Format according to Dump Formats Section
        return "CALL " + label;
    }
}
