package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;


public class LabelCode extends ByteCode implements Dumpable {

    private String label;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {}

    @Override
    public String toString() {
        return "LABEL";
    }

    public String getLabel() {
        return this.label;
    }

}
