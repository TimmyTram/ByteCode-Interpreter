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
        Map<String, LabelCode> labelCodeMap = new HashMap<>();

        // 1st pass thru arrayList keeping track of all label codes and their labels
        for(ByteCode code : program) {
            if (code instanceof LabelCode labelCode) {
                labelCodeMap.put(labelCode.getLabel(), labelCode);
            }
        }

        // 2nd pass thru arrayList look for call, goto, falsebranch codes and do the following:
        // look at stored label codes and find the 1 that has the matching label
        // then we see the index that label is stored in the array which is equal to our address we need to jump to.
        for(ByteCode byteCode : program) {
            if(byteCode instanceof BranchCode branchCode) {
                int address = program.indexOf(labelCodeMap.get(branchCode.getLabel()));
                branchCode.setAddress(address);
            }
        }
    }

}
