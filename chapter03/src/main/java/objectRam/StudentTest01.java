package objectRam;

import lombok.extern.slf4j.Slf4j;

public class StudentTest01{
    public static void main(String[] args){


        Student s2 = new Student();
        s2.id=1002;
        s2.name="李四";
        s2.age=21;
        s2.sex=false;
        System.out.println(s2.id);

        Student s3 = s2;

        System.out.println(s3.id);

    }
}