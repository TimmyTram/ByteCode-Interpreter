package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

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
public class StoreCode extends ByteCode {

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
        value = vm.peek();
    }

    @Override
    public String toString() {
        return "STORE " + offset + " " + id + "\t" + id + "=" + value;
    }
}
