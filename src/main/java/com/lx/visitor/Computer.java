package com.lx.visitor;

/**
 * 电脑
 */
public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v){
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        // 个人采购
        PersonVisitor p = new PersonVisitor();
        // 根据类型初始化价格
        new Computer().accept(p);
        System.out.println(p.totalPrice);

        // 公司采购
        CorpVisitor c = new CorpVisitor();
        // 根据类型初始化价格
        new Computer().accept(c);
        System.out.println(c.totalPrice);
    }

}

/**
 * 电脑零件
 */
abstract class ComputerPart{
    /**
     * 接收
     * @param v 访问者
     */
    abstract void accept(Visitor v);

    /**
     * 获取价格
     * @return
     */
    abstract double getPrice();
}

/**
 * 访问者接口
 */
interface Visitor{
    /**
     * CPU 访问者
     * @param cpu
     */
    void visitCPU(CPU cpu);

    /**
     * 内存 访问者
     * @param memory
     */
    void visitMemory(Memory memory);

    /**
     * 主板 访问者
     * @param board
     */
    void visitBoard(Board board);
}

/**
 * CPU 中央处理器
 */
class CPU extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

/**
 * Memory 内存
 */
class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
/**
 * Board 主板
 */
class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

/**
 * 个人采购
 */
class PersonVisitor implements Visitor{
    double totalPrice = 0.0;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.9;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.9;
    }
}

/**
 * 公司采购
 */
class CorpVisitor implements Visitor{
    double totalPrice = 0.0;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.75;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.75;
    }
}

