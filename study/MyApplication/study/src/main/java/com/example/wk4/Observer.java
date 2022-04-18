package com.example.wk4;

//**SEE BELOW** modify AirPollutionAlert
//Necessary Import statements here

import java.util.ArrayList;

// **** YOU DO NOT NEED TO MODIFY THIS PART OF THE CODE -------
interface Observer{
    void update(double airPollutionIndex);
}

class Subscriber implements Observer{
    private Subject subject;
    private String observerId;
    public static String outputMessage = "";

    public Subscriber(String observerId, Subject subject){
        this.subject=subject;
        this.observerId = observerId;
        this.subject.register(this);		// register itself
    }

    @Override
    public void update(double airPollutionIndex) {
        String s = this.observerId + " received notification: " + airPollutionIndex;
        System.out.println(s);
        outputMessage += (s + " ");
    }
}

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
//-------------------------------------------------------

//TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
class AirPollutionAlert implements Subject{
    private double airPollutionIndex;
    public ArrayList<Observer> a;

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
    }

    public AirPollutionAlert(){
        this.a = new ArrayList<Observer>();
    }
    @Override
    public void register(Observer o){
        a.add(o);
    }
    @Override
    public void unregister(Observer o){
        a.remove(o);
    }
    @Override
    public void notifyObservers(){
        if (airPollutionIndex>100) {
            for (Observer o : a) {
                o.update(airPollutionIndex);
            }
        }
    }
}

