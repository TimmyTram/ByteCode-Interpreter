package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        isDumping;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        isDumping = false;

        while(isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);

            if(isDumping) {
                if(!(code instanceof DumpCode)) { // prevents us from printing DumpCode
                    System.out.println(code);
                }
                runTimeStack.dump(); // dump() is void, so I can only print the RTS, but that means the formatting is weird
                System.out.println();
            }

            programCounter++;
        }
    }

    /*
        -------------- ByteCode Requests to Virtual Machine ----------------
     */

    public void haltExecution() {
        isRunning = false;
    }
    public void setDumping(boolean status) {
        this.isDumping = status;
    }

    /*
        -------------- Virtual Machine Requests to RunTimeStack ----------------
     */
    public int peek() {
        return runTimeStack.peek();
    }

    public int pop() {
        return runTimeStack.pop();
    }

    public int push(int value) {
        return runTimeStack.push(value);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public void store(int offset) {
        runTimeStack.store(offset);
    }

    public void load(int offset) {
        runTimeStack.load(offset);
    }

    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
    }

    public int getNumOfValuesInCurrFrame() {
        return runTimeStack.getNumOfValuesInCurrFrame();
    }

    public void setProgramCounter(int counter) {
        this.programCounter = counter;
    }

    /*
        -------------- Virtual Machine Requests to ReturnAddress Stack ----------------
     */

    public void pushToReturnAddressStack() {
        returnAddress.push(programCounter);
    }

    public int popReturnAddressStack() {
        return returnAddress.pop();
    }

}
