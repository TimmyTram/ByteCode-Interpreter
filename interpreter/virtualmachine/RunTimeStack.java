package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer>  runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

//    public static void main(String[] args) {
//        RunTimeStack rts = new RunTimeStack();
//        rts.push(5);
//        System.out.println(rts.peek());
//        rts.push(6);
//        System.out.println(rts.peek());
//        System.out.println(rts.pop());
//        System.out.println(rts.peek());
//    }

    private int lastIndex() {
        return Math.max(this.runTimeStack.size() - 1, 0);
    }

    public void dump() {

    }

    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }
    public int push(int value) {
        this.runTimeStack.add(value);
        return value;
    }

    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    public int store(int offsetFromFramePointer) {
        return 0;
    }

    public int load(int offsetFromFramePointer) {
        return 0;
    }

    public void newFrameAt(int offsetFromTopOfRunStack) {

    }

    public void popFrame() {

    }

}
