package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Lit ByteCode is used to push literal values to the runtime stack. In some cases, Lit
 * ByteCodes will be accompanied with an id ( a variable name ), this id represents the variable
 * name the value belongs to. This id is optional.
 *
 * • The Lit ByteCode takes 1 or 2 arguments.
 * • The Lit ByteCode should only push 1 value to the top of the runtime stack.
 * • Is it not required that the identifier argument exists.
 * • If dumping is on, Lit ByteCode needs to be dumped according the specifications in the
 * Dumping formats section.
 */
public class LitCode extends ByteCode {

    private int value;
    private String id;

    @Override
    public void init(List<String> args) {
        value = Integer.parseInt(args.get(0));
        if(args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(value);
    }

    @Override
    public String toString() {
        return "LIT " + value + " " + id + "\t\tint " + value;
    }
}
