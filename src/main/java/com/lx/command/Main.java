package com.lx.command;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();

//        InsertCommand insertCommand = new InsertCommand(c);
//        insertCommand.doit();
//        System.out.println(insertCommand.c.msg);
//        insertCommand.undo();
//        System.out.println(insertCommand.c.msg);
//
//        DeleteCommand deleteCommand = new DeleteCommand(c);
//        deleteCommand.doit();
//        System.out.println(deleteCommand.c.msg);
//        deleteCommand.undo();
//        System.out.println(deleteCommand.c.msg);
//
//        CopyCommand copyCommand = new CopyCommand(c);
//        copyCommand.doit();
//        System.out.println(copyCommand.c.msg);
//        copyCommand.undo();
//        System.out.println(copyCommand.c.msg);

        InsertCommand insertCommand = new InsertCommand(c);
        CopyCommand copyCommand = new CopyCommand(c);
        DeleteCommand deleteCommand = new DeleteCommand(c);

        List<Command> commands = new ArrayList<>();
        commands.add(insertCommand);
        commands.add(copyCommand);
        commands.add(deleteCommand);

        for(Command command : commands){
            command.doit();
            System.out.println(c.msg);
        }


        for(int i = commands.size() -1; i>=0; i--){
            commands.get(i).undo();
            System.out.println(c.msg);
        }


    }
}
