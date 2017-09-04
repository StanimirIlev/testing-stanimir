package com.stanimiriliev.chapterfour.directorybrowser;

import java.io.File;

/**
 * Created by Stanimir Iliev on 9.7.2017 y..
 */
public class DirectoryBrowser {

    /**
     * List all sub directories and files if the path is directory or message occurs if
     * the path leads to a specific file
     * @param path -> the path that is either a directory or it leads to a file
     */
    public void listContent(String path){
        File file = new File(path);// Creates new instance of the class File
        if(file.isDirectory()){// checks if the path is directory
            String[] list = file.list();// Gets all sub directories and files
            for(String item : list){// Prints them to the console
                System.out.println(item);
            }
        }
        else if(file.isFile()){// checks if the path is file
            System.out.println("This directory leads to a file.");
        }
        else{// if the path is not file nor directory prints error msg for invalid directory
            System.out.println("Invalid directory!");
        }
    }
}
