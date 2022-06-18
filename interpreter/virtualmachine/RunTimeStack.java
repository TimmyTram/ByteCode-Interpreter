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

    /**
     * This main function is used to test RunTimeStack methods to ensure that it is working as intended
     */
    public static void main(String[] args) {
        RunTimeStack rts = new RunTimeStack();
        System.out.println("**** TESTING push() and peek() ****");
        rts.push(987654321);
        System.out.println("Actual Result: " + rts.peek() + " | Expected: 987654321");
        System.out.println("**** TESTING pop() ****");
        System.out.println("Value returned by pop(): " + rts.pop() + " | Expected: 987654321");
        System.out.println("Checking if RunTimeStack is empty(): " + rts.runTimeStack.isEmpty() + " | Expected: true");
        System.out.println("**** TESTING dump() **** ");
        System.out.print("Actual Result: ");
        rts.push(1);
        rts.push(2);
        rts.push(3);
        rts.newFrameAt(0);
        rts.push(4);
        rts.push(5);
        rts.push(6);
        rts.newFrameAt(0);
        rts.push(7);
        rts.push(8);

        rts.dump();
        System.out.println(" | Expected: [1, 2, 3] [4, 5, 6] [7, 8]");
        System.out.println("**** TESTING popFrame() ****");
        System.out.print("BEFORE POP FRAME: ");
        rts.framePointer.forEach(val -> System.out.print(val + " "));
        rts.popFrame();
        System.out.print("\nAFTER POP FRAME: ");
        rts.framePointer.forEach(val -> System.out.print(val + " "));
        System.out.print("\nVALUES STORED IN RUNTIME STACK IS: ");
        rts.runTimeStack.forEach(val -> System.out.print(val + " "));
        System.out.println("\nUSING DUMP TO SEE FRAMES: ");
        rts.dump();

        System.out.println("\n**************** CLEARING RTS ********************");
        while(!rts.runTimeStack.isEmpty()) {
            rts.popFrame();
        }
        rts.newFrameAt(0);
        rts.push(2020);
        rts.push(2022);
        rts.newFrameAt(0);
        rts.push(1);
        rts.push(2);
        rts.push(3);
        rts.push(4);
        rts.push(5);
        System.out.println("There should be 5 values in current frame: " + rts.getNumOfValuesInCurrFrame());
        rts.dump();
        System.out.print("\nBEFORE POP FRAME: ");
        rts.framePointer.forEach(val -> System.out.print(val + " "));
        rts.popFrame();
        System.out.print("\nAFTER POP FRAME: ");
        rts.framePointer.forEach(val -> System.out.print(val + " "));
        System.out.print("\nVALUES STORED IN RUNTIME STACK IS: ");
        rts.runTimeStack.forEach(val -> System.out.print(val + " "));
        System.out.print("\nUSING DUMP TO SEE FRAMES: ");
        rts.dump();
    }

    private int lastIndex() {
        return Math.max(this.runTimeStack.size() - 1, 0);
    }

    /**
     * Used for dumping the current state of the runTimeStack.
     * It will print portions of the stack based on respective frame markers.
     * Example: [1, 2, 3] [4, 5, 6] [7, 8]
     * Frame Pointers would be 0, 3, 6
     */
    public void dump() {
        int lowerLimit = 0;
        int upperLimit = 0;
        for(int i = 1; i < this.framePointer.size(); i++) {
            upperLimit = this.framePointer.get(i);
            System.out.print(this.runTimeStack.subList(lowerLimit, upperLimit) + " ");
            lowerLimit = upperLimit;
        }
        System.out.print(this.runTimeStack.subList(upperLimit, this.runTimeStack.size()) + " ");
    }

    /**
     * returns the top of the runtime stack, but does not remove
     * @return copy of the top of the stack
     */
    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }

    /**
     * Push the value to the top of the stack.
     * @param value value to be pushed
     * @return value pushed
     */
    public int push(int value) {
        this.runTimeStack.add(value);
        return value;
    }

    /**
     * removes the top of the runtime stack
     * @return the value popped.
     */
    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    /**
     * Takes the top item of the run time stack, and stores it into an offset starting from the current frame.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offsetFromFramePointer) {
        int storedValue = this.pop();
        int slotsAboveCurrentFrameMarker = this.framePointer.peek() + offsetFromFramePointer;
        return runTimeStack.set(slotsAboveCurrentFrameMarker, storedValue);
    }

    /**
     * Takes a value from the run time stack that is at the offset
     * from the current frame marker and pushes it onto the top of the stack.
     * @param offsetFromFramePointer number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offsetFromFramePointer) {
        int slotsAboveCurrentFrameMarker = this.framePointer.peek() + offsetFromFramePointer;
        int loadValue = runTimeStack.get(slotsAboveCurrentFrameMarker);
        return this.push(loadValue);
    }

    /**
     * create a new frame pointer at the index offset slots down from the top
     * of the runtime stack.
     * @param offsetFromTopOfRunStack slots down from the top of the runtime stack
     */
    public void newFrameAt(int offsetFromTopOfRunStack) {
        int slotsFromTopRTS = this.runTimeStack.size() - offsetFromTopOfRunStack;
        this.framePointer.push(slotsFromTopRTS);
    }

    /**
     * pop the current frame off the runtime stack. Also removes the
     * frame pointer value from the FramePointer Stack.
     */
    public void popFrame() {
        int newCurr = this.framePointer.pop();
        while(this.runTimeStack.size() > newCurr) {
            this.pop();
        }
    }

    /**
     * @return how many values in current frame
     */
    public int getNumOfValuesInCurrFrame() {
        return this.runTimeStack.size() - this.framePointer.peek();
    }

}
