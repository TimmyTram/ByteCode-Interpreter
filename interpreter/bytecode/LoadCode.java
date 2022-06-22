package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;


import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

/**
 * The Load ByteCode will be used to move values from an offset in the current frame to the
 * top of the stack. This offset works from the beginning of the frame. The purpose behind this
 * ByteCode is it is needed to setup copies of values for things like expressions and arguments
 * for functions. The load ByteCode is not allowed to operate across frame boundaries.
 *
 * • The Load ByteCode can have 1 to 2 arguments.
 * – one argument is the offset in the current frame where the value is to be copied
 * from.
 * – The second argument, if present, is the identifier (variable) the value belongs to.
 * This we be used for dumping.
 * • Load must copy the value at the offset in the current and pushRunTimeStack it to the top of the
 * stack.
 * • Load must not remove any values from the runtime stack.
 * • Load cannot operate across frame boundaries.
 * • Loads’s offset is strictly positive.
 * • Is it not required that the identifier argument exists.
 * • If dump is on, Load needs to be dumped according the specifications given in the
 * Dumping Formats section.
 */
public class LoadCode extends ByteCode {

    private int offset;
    private String id;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1) {
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public String toString() {
        String base = "LOAD " + offset;
        if(id != null) {
            base += " " + id + "\t\t<load " + id + ">";
        }
        return base;
    }

    /**
     * This main function is used to test the toString method of LoadeCode for dumping.
     */
    public static void main(String[] args) {
        LoadCode loadCode = new LoadCode();
        List<String> arguments = new ArrayList<>();
        arguments.add("2");
        loadCode.init(arguments);
        System.out.println("**** TESTING LoadCode WITH 1 ARGUMENT **** ");
        System.out.println(loadCode);
        arguments.add("j");
        loadCode.init(arguments);
        System.out.println("**** TESTING LoadCode WITH 2 ARGUMENTS **** ");
        System.out.println(loadCode);
    }

}
