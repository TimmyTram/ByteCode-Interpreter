package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

/**
 * The Args ByteCode is going to be used to setup how many arguments a function has. The
 * Args ByteCode will always be executed just before a Call ByteCode. The Args ByteCode
 * has one argument, the number of values that are arguments for the next function call. This
 * value N, will be used to determine how many values starting from the top of the runtime
 * stack will be a part of a newly created activation frame for the next function call. Args will
 * need to figure out where in the runtime stack this new frame begins at and push this index
 * into the FramePointer stack.
 *
 * • The Args byteCode has one argument, the number of values that will be a part of the
 * new activation frame.
 * • The Args ByteCode will need to push the starting index of the new frame to the
 * framePointer stack.
 * • If dump is on, the Args ByteCode is required to be dumped. Examples are given in
 * this document.
 */
public class ArgsCode extends ByteCode {

    private int numOfArgs;

    @Override
    public void init(List<String> args) {
        numOfArgs = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(numOfArgs);
    }

    @Override
    public String toString() {
        return "ARGS " + numOfArgs;
    }
}
