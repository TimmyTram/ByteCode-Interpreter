package interpreter.bytecode;

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
