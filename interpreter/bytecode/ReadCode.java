package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

/**
 * The Read ByteCode is used to read user input from the keyboard. Only integers should be
 * accepted from users. You may use Scanners or BufferedReaders to read input from the user.
 * 3.12.1 Requirements
 * • When asking for user input, use the following prompt: ”Please enter an integer : ”
 * 11
 * • The Read ByteCode needs to verify that the value given is actually a number. If
 * an invalid number is given, state that the input is invalid and ask for another value.
 * Continue to do so until a valid value is given.
 * • Push the validated integer to the VirtualMachine’s RunTimeStack.
 * • If dumping is on, Simply print ”READ” to the console.
 */
public class ReadCode extends ByteCode implements Dumpable {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do { // keep prompting user until we get a string that is actually an integer
            System.out.print("Please enter an integer : ");
            userInput = scanner.nextLine();
        } while(!userInput.matches("-?\\d+"));
        // regex explanation:
        // -? --> Can have negative sign or not (in factorial and fib it will just return 1 so this part really isn't needed)
        // \\d+ --> One or more digits (non-negative) since negative fib and factorial isn't needed
        vm.pushRunTimeStack(Integer.parseInt(userInput));
        scanner.close();
    }

    @Override
    public String toString() {
        return "READ";
    }
}
