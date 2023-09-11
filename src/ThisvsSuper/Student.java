package ThisvsSuper;

class Student{
    String name;
    String sec;
    int age;
    String std;

    Student(String name){
        this(name,21);
    }
    Student(String name,int age){
        this(name,"VII",age,"B");
    }
    Student(String name,String std,int age,String sec){
        this.name = name;
        this.std = std;
        this.age = age;
        this.sec = sec;
    }

    void getResponsibiites(){
        System.out.println("Studying");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sec='" + sec + '\'' +
                ", age=" + age +
                ", std='" + std + '\'' +
                '}';
    }
}

