public class Grade {
    private int Calculus;
    private int MathModeling;
    private int DSA;
    private int ComputerArchitecture;
    private int OS;
    private int AdvancedProgramming;

    public Grade(int Calculus, int MathModeling, int DSA, int ComputerArchitecture, int OS, int AdvancedProgramming){
        this.Calculus = Calculus;
        this.MathModeling = MathModeling;
        this.DSA = DSA;
        this.ComputerArchitecture = ComputerArchitecture;
        this.OS = OS;
        this.AdvancedProgramming = AdvancedProgramming;
    }

    /*SET/UPDATE GRADE*/

    public void setCalculus(int Calculus){
        this.Calculus = Calculus;
    }

    public void setMathModeling(int MathModeling){
        this.MathModeling = MathModeling;
    }

    public void setDSA(int DSA){
        this.DSA = DSA;
    }

    public void setComputerArchitecture(int ComputerArchitecture){
        this.ComputerArchitecture = ComputerArchitecture;
    }

    public void setOS(int OS){
        this.OS = OS;
    }

    public void setAdvancedProgramming(int AdvancedProgramming){
        this.AdvancedProgramming = AdvancedProgramming;
    }

    /*GET GRARDE */
    public int getCalculus(){
        return this.Calculus;
    }

    public int getMathModeling(){
        return this.MathModeling;
    }

    public int getDSA(){
        return this.DSA;
    }

    public int getComputerArchitecture(){
        return this.ComputerArchitecture;
    }

    public int getOS(){
        return this.OS;
    }

    public int getAdvancedProgramming(){
        return this.AdvancedProgramming;
    }
}
