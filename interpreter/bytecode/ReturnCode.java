package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

public class ReturnCode extends ByteCode implements Dumpable {

    private String label;
    private int returnLocation;
    private int value;

    @Override
    public void init(List<String> args) {
        if(!args.isEmpty()) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        value = vm.popRunTimeStack();
        returnLocation = vm.popReturnAddressStack();
        vm.popFrame();
        vm.pushRunTimeStack(value);
        vm.setProgramCounter(returnLocation);
    }

    @Override
    public String toString() {
        String base = "RETURN";
        if(label != null) {
            String functionName = label.split("<")[0]; // f<<2>> split on first instance of '<' --> ['f', '<<2>>']
            base += " " + label + "\t\tEXIT " + functionName + " : " + value;
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
