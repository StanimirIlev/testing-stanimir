package com.stanimiriliev.chapterfour.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Stanimir Iliev on 9.7.2017 г..
 */
public class TransferObject {

    /**
     * Transfer specific number of bytes with a specific offset from InputStream to
     * OutputStream
     * @param in -> the InputStream
     * @param out -> the OutputStream
     * @param offset -> the offset
     * @param size -> how many bytes to transfer
     */
    public void transfer(InputStream in, OutputStream out, int offset, int size){
        byte[] buff = new byte[1024];// Creates buffer
        try{
            while(in.read(buff) != -1){// Reads until the end from the input stream and write it
                // to the output stream with the specific offset and size
                out.write(buff, offset , size);
            }
        }
        catch(IOException e){
            e.printStackTrace();// Prints detailed information about the exception that occurs
        }
    }
}
