package com.lx.command;

public class InsertCommand extends Command {
    Content c;
    String insertStr = "巴拉巴拉小魔仙变身!";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + insertStr;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - insertStr.length());

    }
}
