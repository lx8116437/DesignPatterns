package com.lx.ASM;

import jdk.internal.org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception{
        ClassReader cr = new ClassReader(ClassPrinter.class.getClassLoader().getResourceAsStream("com/lx/ASM/Tank.class"));

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/lx/ASM/TimeProxy","before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };


        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        MyClassLoader mc = new MyClassLoader();
        mc.loadClass("com.lx.ASM.TimeProxy");
        Class c2 = mc.defineClass("com.lx.ASM.Tank", b2);
        c2.getConstructor().newInstance();

        String path = (String) System.getProperties().get("user.dir");
        File f = new File(path + "/com/lx/ASM");
        f.mkdir();

        FileOutputStream fs = new FileOutputStream(new File(path + "/com/lx/ASM/Tank_0.class"));
        fs.write(b2);
        fs.flush();
        fs.close();
    }
}
