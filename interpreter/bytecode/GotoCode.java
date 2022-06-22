package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Goto ByteCode is used to jump to Labels in our programs. Goto is considered an
 * unconditional jump. This means regardless of the state of the program, we take the jump.
 * Goto has one argument, the label it needs to jump to. Like FalseBranch, Goto’s label needs
 * to go through address resolution as well.
 *
 * • Goto has one argument, a label to jump to.
 * • Goto’s Label must have its address resolved before the program begins executing. More
 * on this later.
 * • If dump is on, Goto is required to be dumped. Examples are given in this document
 */
public class GotoCode extends ByteCode implements Dumpable {

    private String label;
    private int location;

    @Override
    public void init(List<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(this.location);
    }

    @Override
    public String toString() {
        return "GOTO " + label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLocation(int location) {
        this.location = location;
    }

}
