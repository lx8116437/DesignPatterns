package com.lx.observer.v9;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Button b = new Button();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.buttonPressed();
    }
}

class Button{
    private List<ActionListener> actionListenerList = new ArrayList<>();
    public void buttonPressed(){
        ActionEvent e = new ActionEvent(this, 1, System.currentTimeMillis() + "");
        for (int i=0;i<actionListenerList.size(); i++){
            ActionListener l = actionListenerList.get(i);
            l.actionPerformed(e);
        }
    }

    public void addActionListener(ActionListener l){
        actionListenerList.add(l);
    }



}

interface ActionListener{
    void actionPerformed(ActionEvent e);
}

class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed!");
    }
}

class MyActionListener2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 2!");
    }
}
