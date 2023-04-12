/*tính toán mấy cái liên quan đến điểm ở đây */
public class GF {
    public double avgGrade(Grade grade){
        double totalGrade = grade.getCalculus() + grade.getMathModeling() + grade.getComputerArchitecture() + grade.getDSA() + grade.getOS() + grade.getAdvancedProgramming();
        return totalGrade / 6;
    }
}
