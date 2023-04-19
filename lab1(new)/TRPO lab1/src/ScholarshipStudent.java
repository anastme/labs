public class ScholarshipStudent extends Student{
    private double scholarShip = 100;
    private boolean examPassedInTime;
    public ScholarshipStudent(String name, String group, Double avgMark,int listNumber,Boolean examPassedInTime){
        super(name,group,avgMark,listNumber);
        this.examPassedInTime = examPassedInTime;
    }
    public Double getScholarShip() {
        if (examPassedInTime) {
            double avgMark = getAvgMark();
            if (avgMark < 5) {
                scholarShip = 0;
            } else if (avgMark >= 5 && avgMark < 6) {
                scholarShip = scholarShip * 1;
            } else if (avgMark >= 6 && avgMark < 8) {
                scholarShip = scholarShip * 1.25;
            } else if (avgMark >= 8 && avgMark <= 10) {
                scholarShip = scholarShip * 1.5;
            }
        } else {
            scholarShip = 0;
        }
        return scholarShip;
    }
    public String getStudentInfo(){
        return "Номер по списку: " + listNumber + "\nИмя: " + name +
                "\nГруппа: " + group + "\nСредний балл: " + avgMark + "\n" +
                (examPassedInTime ? "Сессия сдана вовремя" : "Сессия сдана не вовремя") +
                "\nСтипендия: " + getScholarShip();
    }
}
