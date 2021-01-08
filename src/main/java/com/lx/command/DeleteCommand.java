package com.lx.command;

public class DeleteCommand extends Command{
    Content c;
    String delString = "";

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        delString = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());

    }

    @Override
    public void undo() {
        c.msg = delString + c.msg;
    }
}
