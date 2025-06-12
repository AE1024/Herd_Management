package Entity;

public class Health_Record {
    private int id;
    private String earTagNumber;
    private boolean healthCondition;
    private String diagnosis;

    public Health_Record() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public void setEarTagNumber(String earTagNumber) {
        this.earTagNumber = earTagNumber;
    }

    public boolean isHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(boolean healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Health_Record{" +
                "id=" + id +
                ", earTagNumber=" + earTagNumber +
                ", healthCondition=" + healthCondition +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}