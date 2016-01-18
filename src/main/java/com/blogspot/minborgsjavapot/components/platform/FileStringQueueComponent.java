package com.blogspot.minborgsjavapot.components.platform;

public class FileStringQueueComponent implements StringQueueComponent {

    @Override
    public boolean offer(String msg) {
        // Append the string to the file
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public String poll() {
        // Check if the file has grown
        //  if yes, read the next line and return it
        // if no, return null
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void added() {
        // Open the file and trunkate it if contains an old queue.
        // Set a pointer to the current file location
    }

    @Override
    public void removed() {
        // Close the file and remove it from the file system
    }

}
