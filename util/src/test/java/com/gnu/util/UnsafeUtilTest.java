package com.gnu.util;

import com.gnu.util.pojo.Student;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author siberiwolf@hotmail.com on 2017/9/25
 */
public class UnsafeUtilTest {
    @Test
    public void createObjTest() throws Exception {
        A a = new A();
        Assert.assertEquals(1, a.getX());

        A b = A.class.newInstance();
        Assert.assertEquals(1, b.getX());

        A c = (A) UnsafeUtil.createObj(A.class);
        Assert.assertEquals(0, c.getX());

        B d = new B();
        Assert.assertEquals(2, d.getX());

        Constructor<?> constructor = UnsafeUtilTest.B.class.getDeclaredConstructor(UnsafeUtilTest.class);
        B e = (B) constructor.newInstance(new UnsafeUtilTest());
        Assert.assertEquals(2, e.getX());

        B f = (B) UnsafeUtil.createObj(B.class);
        Assert.assertEquals(0, f.getX());
    }

    @Test
    public void changePrivateIntFieldTest() throws Exception {
        Student student = new Student();
        Assert.assertEquals(1, student.getId());

        UnsafeUtil.changePrivateIntField(student, "id", 10);
        Assert.assertEquals(10, student.getId());
    }

    // static nested class A
    // OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
    // UnsafeUtilTest.A obj = new UnsafeUtilTest.A();
    static class A {
        private int x;

        public A() {
            this.x = 1;
        }

        public int getX() {
            return this.x;
        }
    }

    // inner class B
    // OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    // UnsafeUtilTest test = new UnsafeUtilTest();
    // UnsafeUtilTest.B obj1 = test.new B();
    class B {
        private int x;

        public B() {
            this.x = 2;
        }

        public int getX() {
            return this.x;
        }
    }
}
