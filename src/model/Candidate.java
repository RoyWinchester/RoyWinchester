package model;

public class Candidate implements java.io.Serializable{

    private int candidateid;
    private String candidatename;

    public int getCandidateid(){
        return this.candidateid;
    }

    public void setCandidateid(int candidateid){
        this.candidateid=candidateid;
    }

    public String getCandidatename(){
        return this.candidatename;
    }

    public void setCandidatename(String candidatename)
    {
        this.candidatename=candidatename;
    }
}

