package interpreter.bytecode;


/**
 * This interface is to be used as a marker interface. This is similar in function to other marker interfaces like:
 *  • Cloneable
 *  • Serializable
 *  Essentially, if a byteCode implements this interface we are saying that we are going to implement a toString()
 *  in each child of byteCode which the virtual machine will print to the console.
 *  If a byteCode does not implement this interface, then the byteCode will be ignored and therefore, not printed to the console.
 *  For example: DumpCode does not implement Dumpable and is not printed to the console.
 */
public interface Dumpable {
}
