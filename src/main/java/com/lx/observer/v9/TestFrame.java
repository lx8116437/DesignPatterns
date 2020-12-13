//package com.lx.observer.v9;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TestFrame extends Frame {
//    public void launch(){
//        Button b = new Button("press me");
//        b.addActionListener(new MyActionListener());
//        b.addActionListener(new MyActionListener2());
//        this.add(b);
//        this.pack();
////        this.addWindowListener(System.exit(0));
//
//        this.setLocation(400, 400);
//        this.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new TestFrame().launch();
//    }
//
//
//
//    private class MyActionListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("button pressed!");
//        }
//    }
//
//    private class MyActionListener2 implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("button pressed 2!");
//        }
//    }
//
//}
