package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

public class StoreCode extends ByteCode implements Dumpable {

    private int offset;
    private String id;
    private int value;

    @Override
    public void init(List<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1) {
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
