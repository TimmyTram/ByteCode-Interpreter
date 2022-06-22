package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

/**
 * The Lit ByteCode is used to pushRunTimeStack literal values to the runtime stack. In some cases, Lit
 * ByteCodes will be accompanied by an id ( a variable name ), this id represents the variable
 * name the value belongs to. This id is optional.
 *
 * • The Lit ByteCode takes 1 or 2 arguments.
 * • The Lit ByteCode should only pushRunTimeStack 1 value to the top of the runtime stack.
 * • Is it not required that the identifier argument exists.
 * • If dumping is on, Lit ByteCode needs to be dumped according the specifications in the
 * Dumping formats section.
 */
public class LitCode extends ByteCode implements Dumpable {

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
        vm.pushRunTimeStack(value);
    }

    @Override
    public String toString() {
        String base = "LIT " + value;
        if(id != null) {
            base += (" " + id + "\t\tint " + id); // tabbing because pdf has the int id tabbed
        }
        return base;
    }

    /**
     * This main function is used to test the toString method of LitCode for dumping.
     */
    public static void main(String[] args) {
        LitCode litCode = new LitCode();
        List<String> arguments = new ArrayList<>();
        System.out.println("**** TESTING LitCode WITH 1 ARGUMENT **** ");
        arguments.add("0");
        litCode.init(arguments);
        System.out.println(litCode);
        System.out.println("**** TESTING LitCode WITH 2 ARGUMENTS **** ");
        arguments.add("j");
        litCode.init(arguments);
        System.out.println(litCode);
    }

}
