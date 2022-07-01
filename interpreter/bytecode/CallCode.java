package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList; // <-- This import only exists to test main method in this class
import java.util.List;

public class CallCode extends BranchCode implements Dumpable {
    private String arguments;

    @Override
    public void init(List<String> args) {
        super.setLabel(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        arguments = vm.getArgumentsFromFrame();
        vm.pushToReturnAddressStack();
        vm.setProgramCounter(super.getAddress());
    }

    @Override
    public String toString() {
        String label = super.getLabel();
        String base = "CALL";
        if(label != null) {
            String functionName = label.split("<")[0]; // f<<2>> split on first instance of '<' --> ['f', '<<2>>']
            base += " " + label + "\t\t" + functionName + "(" + arguments + ")";
        }
        return base;
    }

    /**
     * This main function is used to test the toString method of ReturnCode for dumping.
     * Note: This test will not show correct output (meaning it won't show values in frames)
     * unless you can directly manipulate runtime stack
     */
    public static void main(String[] args) {
        CallCode callCode = new CallCode();
        List<String> arguments = new ArrayList<>();
        arguments.add("f<<3>>");
        callCode.init(arguments);
        System.out.println("**** TESTING CallCode ****");
        System.out.println(callCode);
    }

}
