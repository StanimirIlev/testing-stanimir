package com.stanimiriliev.chapterfour.dataclass;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

/**
 * Created by Stanimir Iliev on 9.7.2017 г..
 */
public class DataClass {

    /**
     * Saves the provided object "o" in the output stream
     * @param out -> Where to save the object
     * @param o -> The object which is being saved
     * @throws IOException if Input/Output exception occurs
     */
    public void saveObject(OutputStream out,Object o) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(out);// Creates new instance of the
        // class ObjectOutputStream
        output.writeObject(o);// Saves the object to the OutputStream
        output.close();// Closes the stream of ObjectOutputStream
    }

    /**
     * Reads an object from the provided InputStreams and returns it as result
     * @param in -> Where to get the object
     * @return the object
     * @throws IOException if Input/Output exception occurs
     * @throws ClassNotFoundException if the no definition for the class with the specified name could be found
     */
    public Object getObject(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(in);// Creates new instance of the
        // class ObjectOutputStream
        Object result = input.readObject();// Read the object
        input.close();// Closes the stream of ObjectInputStream
        return result;// returns the object
    }
}
