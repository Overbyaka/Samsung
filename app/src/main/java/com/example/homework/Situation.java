package com.example.homework;

public class Situation {
    Situation[] direction;
    String subject,text;
    int dDifficult,dKnowledge,dWatching;
    public Situation (String subject, String text, int variants, int ddifficult,int dknowledge,int dwatching) {
        this.subject=subject;
        this.text=text;
        dDifficult=ddifficult;
        dKnowledge=dknowledge;
        dWatching=dwatching;
        direction=new Situation[variants];
    }
}