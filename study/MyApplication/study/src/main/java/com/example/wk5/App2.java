package com.example.wk5;

public class App2 {
    private static LogFile logfile;
    App2(){
        logfile = LogFile.getInstance();
        System.out.println(logfile);
    }
}
