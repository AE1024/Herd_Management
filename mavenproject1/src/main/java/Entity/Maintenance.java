package Entity;

import java.sql.Date;

public class Maintenance {
    private int maintenanceId; 
    private String earTagNumber;
    private Date vaccinationCheckDate;
    private Date nailCheckDate;
    private Date veterinarianCheckDate;
    private Date birthControlDate;
    private Date matingCheckDate;

    public Maintenance() {
    }

    // Getter ve Setter metodları
    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public void setEarTagNumber(String earTagNumber) {
        this.earTagNumber = earTagNumber;
    }

    public Date getVaccinationCheckDate() {
        return vaccinationCheckDate;
    }

    public void setVaccinationCheckDate(Date vaccinationCheckDate) {
        this.vaccinationCheckDate = vaccinationCheckDate;
    }

    public Date getNailCheckDate() {
        return nailCheckDate;
    }

    public void setNailCheckDate(Date nailCheckDate) {
        this.nailCheckDate = nailCheckDate;
    }

    public Date getVeterinarianCheckDate() {
        return veterinarianCheckDate;
    }

    public void setVeterinarianCheckDate(Date veterinarianCheckDate) {
        this.veterinarianCheckDate = veterinarianCheckDate;
    }

    public Date getBirthControlDate() {
        return birthControlDate;
    }

    public void setBirthControlDate(Date birthControlDate) {
        this.birthControlDate = birthControlDate;
    }

    public Date getMatingCheckDate() {
        return matingCheckDate;
    }

    public void setMatingCheckDate(Date matingCheckDate) {
        this.matingCheckDate = matingCheckDate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", earTagNumber=" + earTagNumber +
                ", vaccinationCheckDate=" + vaccinationCheckDate +
                ", hoofCheckDate=" + nailCheckDate +
                ", veterinarianCheckDate=" + veterinarianCheckDate +
                ", birthControlDate=" + birthControlDate +
                ", matingCheckDate=" + matingCheckDate +
                '}';
    }
}