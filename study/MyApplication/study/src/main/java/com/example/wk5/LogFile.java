package com.example.wk5;

public class LogFile {
    private LogFile(){};
    private static LogFile instance = null;
    public static LogFile getInstance(){
        if (instance==null) {
            instance = new LogFile();
        }
        return instance;
    }
}
