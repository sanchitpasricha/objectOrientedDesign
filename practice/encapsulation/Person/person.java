package practice.encapsulation.Person;

public class person {
    private String name;
    private int age;

    public person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }
    }
}


