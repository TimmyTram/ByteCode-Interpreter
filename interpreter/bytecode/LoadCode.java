package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;


import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

public class LoadCode extends ByteCode implements Dumpable {

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
