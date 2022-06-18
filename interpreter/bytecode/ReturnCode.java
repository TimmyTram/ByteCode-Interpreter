package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

/**
 * The Return ByteCode will be used to return from functions but also to put return values in
 * the correct position on the runtime stack. The interpreter project will use this convention for
 * handling arguments and return values. Callers of functions are required to setup argument
 * for the functions they call. Functions themselves (callees) are required to put return values
 * in the correct spot just before returning from a function. Note that this is a convention we
 * will adhere to and is something that is not enforced programmatically. This means if you
 * fail to follow this convention, transient bugs can happen. The Return ByteCode has a lot of
 * responsibility. The steps for completing a return is important.
 *
 * • The Return ByteCode can take 0 to 1 arguments. The arguments have no effect on its
 * functionality. But does effect the Dumping process.
 * • The Return ByteCode must store the return value at the top of the runtime stack.
 * • The Return ByteCode must empty the current frame of all values when the function
 * is complete.
 * • The Return ByteCode must pop the top value from the framePointer stack to remove
 * the frame boundary.
 * • The return ByteCode must pop the top of the return address stack and save it into
 * program counter.
 * • If dumping is on, the Return ByteCode needs to be dumped according the specifications
 * in the Dumping formats section.
 */
public class ReturnCode extends ByteCode {

    private String label;
    private int returnLocation; // TODO: This will be used for execute() and toString()

    @Override
    public void init(List<String> args) {
        if(!args.isEmpty()) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        // TODO: Figure out execute
    }

    @Override
    public String toString() {
        String base = "RETURN";
        if(label != null) {
            String functionName = label.split("<")[0]; // f<<2>> split on first instance of '<' --> ['f', '<<2>>']
            base += " " + label + "\t\tEXIT " + functionName + " : " + returnLocation;
        }
        return base;
    }

    /**
     * This main function is used to test the toString method of ReturnCode for dumping.
     */
    public static void main(String[] args) {
        ReturnCode returnCode = new ReturnCode();
        List<String> arguments = new ArrayList<>();
        returnCode.init(arguments);
        System.out.println("**** TESTING ReturnCode WITH 0 ARGUMENT **** ");
        System.out.println(returnCode);
        arguments.add("f<<2>>");
        returnCode.init(arguments);
        System.out.println("**** TESTING ReturnCode WITH 0 ARGUMENT **** ");
        System.out.println(returnCode);
    }

}
