package IOOC.linearSearch;

public class Student implements  Comparable<Student> {

    private String name;

    private int score;

    public Student(String name){
        this.name=name;

    }

    public Student(String name,int score){
        this.name=name;
        this.score = score;

    }

    @Override
    public boolean equals(Object another) {

        if(this == another){
            return true;
        }
        if(another == null){
            return false;
        }

        if(this.getClass()!= another.getClass()){
            return false;
        }

        if(this.name.toLowerCase().equals(((Student)another).name.toLowerCase())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(Student another) {
//      if(this.score<another.score){
//          return -1;
//      }else if(this.score == another.score){
//          return 0;
//      }return 1;

        return this.score- another.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)",name,score);
    }
}
