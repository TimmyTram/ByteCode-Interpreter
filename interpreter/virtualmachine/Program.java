package interpreter.virtualmachine;

import interpreter.bytecode.*;

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
        Map<String, Integer> labelCodeMap = new HashMap<>();

        for(int i = 0; i < program.size(); i++) {
            ByteCode byteCode = program.get(i);
            if(byteCode instanceof LabelCode labelCode) {
                labelCodeMap.put(labelCode.getLabel(), i);
            }
        }

        for (ByteCode byteCode : program) {
            if (byteCode instanceof BranchCode branchCode) {
                int address = labelCodeMap.get(branchCode.getLabel());
                branchCode.setAddress(address);
            }
        }

    }

}
