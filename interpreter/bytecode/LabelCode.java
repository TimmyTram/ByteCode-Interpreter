package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Label ByteCode is a ByteCode that has no functionality. Its sole purpose is to mark
 * locations in the program where other ByteCodes can jump to. Label ByteCodes will be used
 * to address resolution so other ByteCodes know where they are supposed to jump to.
 *
 * • Label takes one argument, a label which is used to denote a location in the program.
 * • Dumping Label ByteCodes is optional
 */
public class LabelCode extends ByteCode {

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
}
