package cn.little.mybatis.test;

import cn.little.mybatis.reflection.factory.DefaultObjectFactory;
import cn.little.mybatis.reflection.factory.ObjectFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactoryTest {

    @Test
    public void testCreate(){
        Teacher teacher = new Teacher();
        List<Teacher.Student> list = new ArrayList<>();
        list.add(new Teacher.Student());
        teacher.setName("小傅哥");
        teacher.setStudents(list);

        ObjectFactory objectFactory = new DefaultObjectFactory();
        Teacher teacher1 = objectFactory.create(Teacher.class);
        System.out.println(teacher1);
    }

    static class Teacher {

        private String name;

        private double price;

        private List<Student> students;

        private Student student;

        public static class Student {

            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }

}

