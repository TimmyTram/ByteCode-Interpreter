package interpreter.bytecode;


/**
 *  BranchCode is an abstract class because we have this idea where certain byteCodes need to hold some sort of address to jump to
 *  CallCode, GotoCode and FalseBranchCode all shared these fields as well as methods,
 *  so I decided to put them in a singular class to reuse code.
 *  This makes the if check in the resolveAddress() in Program.java much simpler because we have one if statement that
 *  covers all cases where a byteCode needs a jump with an address.
 */
public abstract class BranchCode extends ByteCode {

    private String label;
    private int address;

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getAddress() {
        return this.address;
    }

}
