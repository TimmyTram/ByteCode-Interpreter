package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Scanner;
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
            programCounter++;
        }
    }

    /*
        -------------- ByteCode Requests to Virtual Machine ----------------
     */

    /**
     * Used by HaltCode
     * Stop executeProgram() Loop
     */
    public void haltExecution() {
        isRunning = false;
    }
    public void setDumping(boolean status) {
        this.isDumping = status;
    }

    public int read() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do { // keep prompting user until we get a string that is actually an integer
            System.out.print("Please enter an integer : ");
            input = scanner.nextLine();
        } while(!input.matches("-?\\d+"));
        // regex explanation:
        // -? --> Could have a negative sign or not
        // \\d+ --> One or more digits
        return Integer.parseInt(input);
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

    /*
        -------------- Virtual Machine Requests to ReturnAddress Stack ----------------
     */



}
