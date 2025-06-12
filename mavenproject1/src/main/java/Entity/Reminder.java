package Entity;

import java.sql.Date;

public class Reminder {

    private int reminder_id;
    private int maintenance_id;
    private String animalEarTagNumber;
    private String phoneNumber;
    private boolean isSent;
    private Date reminder_date;
    
    public Reminder() {
    }
    
    public int getReminder_id(){
        return reminder_id;
    }
    
    public void setReminder_id(int reminder_id){
        this.reminder_id = reminder_id;
    }

    public int getMaintenance_id() {
        return maintenance_id;
    }

    public void setMaintenance_id(int maintenance_id) {
        this.maintenance_id = maintenance_id;
    }

    public String getAnimalEarTagNumber() {
        return animalEarTagNumber;
    }

    public void setAnimalEarTagNumber(String animalEarTagNumber) {
        this.animalEarTagNumber = animalEarTagNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        this.isSent = sent;
    }

    public Date getReminder_date(){
        return reminder_date;
    }
    
    public void setReminder_date(Date reminder_date) {
        this.reminder_date = reminder_date;
    }

}
