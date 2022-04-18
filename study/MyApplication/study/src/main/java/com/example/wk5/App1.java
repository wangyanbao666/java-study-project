package com.example.wk5;

public class App1 {
    private static LogFile logfile=null;
    App1(){
        logfile = LogFile.getInstance();
        System.out.println(logfile);
    }
}
