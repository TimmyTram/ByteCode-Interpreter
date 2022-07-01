package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

public class ReadCode extends ByteCode implements Dumpable {
    @Override
    public void init(List<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
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
