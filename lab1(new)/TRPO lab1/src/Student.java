import java.util.ArrayList;

public abstract class Student {
    protected String name;
    protected String group;
    protected double avgMark;
    protected int listNumber;
    public Student(String name, String group, Double avgMark, int listNumber){
        this.name = name;
        this.group = group;
        this.avgMark = avgMark;
        this.listNumber = listNumber;
    }
    public static Double getAvgMarkOfAllStudents(ArrayList<Student> students){
        double sumOfMarks = 0.0;
        for(int i = 0; i< students.size();i++){
            sumOfMarks += students.get(i).getAvgMark();
        }
        return sumOfMarks/students.size();
    }
    public Double getAvgMark() {return avgMark;}
    public String getName(){return name;}
    public String getGroup(){return group;}
    public int getListNumber(){return listNumber;}
    public abstract String getStudentInfo();
}

