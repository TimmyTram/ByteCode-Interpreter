package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private List<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void add(ByteCode bc) {
        program.add(bc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently, all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {
        Map<String, LabelCode> labelCodeMap = new HashMap<>();

    }




}
