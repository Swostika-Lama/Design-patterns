package Singleton_Logger_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    // Private constructor (singleton rule)
    private Logger(){
        this.fileName = "default_logger.txt";
        openFile();
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    // Opens the file for writing
    private void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // append mode
        } catch (IOException e) {
            System.out.println("Error opening log file: " + e.getMessage());
        }
    }

    // Change file name
    public synchronized void setFileName(String newFileName) {
        try {
            // close existing file if open
            if (writer != null) {
                writer.close(); //
            }
            this.fileName = newFileName;
            writer = new BufferedWriter(new FileWriter(fileName, true));// append mode
        } catch (IOException e) {
            System.out.println("Error closing current log file: " + e.getMessage());
        }

    }

    // Writes a message to the log file
    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush(); //ensure immediate write
            }
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Close the logger manually
    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
        }
    }
}

