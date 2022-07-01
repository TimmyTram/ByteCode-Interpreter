package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

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
            base += (" " + id + "\t\tint " + id);
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
