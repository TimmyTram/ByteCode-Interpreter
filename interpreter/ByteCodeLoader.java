package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public final class ByteCodeLoader {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each read line:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     *      Then add newly created and initialize ByteCode to the program
     */
    public Program loadCodes() {
        Program program = new Program();
        String[] items;
        String className;
        Class c;
        ByteCode bc;
        List<String> args = new ArrayList<>();

        try {
            while(this.byteSource.ready()) {
                items = this.byteSource.readLine().split("\\s+");
                className = CodeTable.getClassName(items[0]);
                c = Class.forName("interpreter.bytecode." + className);
                bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                for(int i = 1; i < items.length; i++) {
                    args.add(items[i]);
                }
                bc.init(args);
                program.add(bc);
                args.clear();
            }
        } catch(IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(-55);
        }

        program.resolveAddress();
        return program;
    }
}
