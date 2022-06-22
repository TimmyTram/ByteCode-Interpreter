package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

/**
 * The Store ByteCode will be used to move values from the top of the run time stack to an
 * offset in the current frame. This offset starts from the beginning of the frame. The idea
 * behind this ByteCode is it is needed to do operations like assignments. The Store ByteCode
 * is not allowed to operate across frame boundaries.
 * 7
 *
 * • The Store ByteCode can have 1 to 2 arguments.
 * – one argument is the offset in the current frame where the value that is popped is
 * to be stored.
 * – The second argument, if present, is the identifier (variable) the value being moved
 * belongs to. This we be used for dumping.
 * • Store must pop the top of the runtime stack and store the value at the offset in the
 * current frame.
 * • Store cannot operate across frame boundaries.
 * • Store’s offset is strictly positive
 * • If dump is on, Store needs to be dumped according the specifications given in the
 * Dumping Formats section.
 */
public class StoreCode extends ByteCode implements Dumpable {

    private int offset;
    private String id;
    private int value;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1) { // prevent boundary error.
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
        value = vm.peekRunTimeStack();
    }

    @Override
    public String toString() {
        String base = "STORE " + offset;
        if(id != null) {
            base += " " + id + "\t\t" + id + "=" + value;
        }
        return base;
    }

    /**
     * This main function is used to test the toString method of StoreCode for dumping.
     * Note: RunTimeStack is empty when we run this. Value is 0 due to initialization of private fields
     */
    public static void main(String[] args) {
        StoreCode storeCode = new StoreCode();
        List<String> arguments = new ArrayList<>();
        System.out.println("**** TESTING StoreCode WITH 1 ARGUMENT **** ");
        arguments.add("1");
        storeCode.init(arguments);
        System.out.println(storeCode);
        System.out.println("**** TESTING StoreCode WITH 2 ARGUMENTS **** ");
        arguments.add("k");
        storeCode.init(arguments);
        System.out.println(storeCode);
    }

}
