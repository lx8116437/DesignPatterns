package com.lx.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node{
    abstract public void p();
}

class BreachNode extends Node{
    List<Node> nodeList = new ArrayList<>();

    String name;
    public BreachNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n){
        nodeList.add(n);
    }
}

class LeafNode extends Node{
    String content;
    public LeafNode(String content){
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

public class Main {
    public static void main(String[] args) {
        BreachNode root = new BreachNode("root");
        BreachNode chapter1 = new BreachNode("chapter1");
        BreachNode chapter2 = new BreachNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BreachNode b21 = new BreachNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    public static void tree(Node b, int dept){
        for (int i = 0 ; i < dept; i++){
            System.out.print("--");
        }
        b.p();
        if(b instanceof BreachNode){
            for (Node n : ((BreachNode) b).nodeList) {
                tree(n, dept + 1);
            }

        }


    }




}
