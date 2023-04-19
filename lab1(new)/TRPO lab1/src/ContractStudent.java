public class ContractStudent extends Student{
    private double educationCost;
    public ContractStudent(String name, String group, Double avgMark,int listNumber,double educationCost){
        super(name,group,avgMark,listNumber);
        this.educationCost = educationCost;
    }
    public String getStudentInfo(){
        return "Номер по списку: " + listNumber + "\nИмя: " + name + "\nГруппа: " + group + "\nСредний балл: " + avgMark + "\nСтоимость обучения: " + educationCost;
    }
}
