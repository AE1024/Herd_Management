/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

public class Animal {
    private String earTagNumber;
    private int user_id;
    private String parentEarTagNumber;
    private String type;
    private String breed;
    private Date birthDate;
    private String gender;
    private float weight;
    private boolean hasOffspring;

    public Animal() {

    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public void setEarTagNumber(String earTagNumber) {
        this.earTagNumber = earTagNumber;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getParentEarTagNumber() {
        return parentEarTagNumber;
    }

    public void setParentEarTagNumber(String parentEarTagNumber) {
        this.parentEarTagNumber = parentEarTagNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean getHasOffspring() {
        return hasOffspring;
    }

    public void setHasOffspring(boolean hasOffspring) {
        this.hasOffspring = hasOffspring;
    }
    @Override
public String toString() {
    return "Animal{" +
            "earTagNumber=" + earTagNumber +
            ", user_id=" + user_id +
            ", parentEarTagNumber=" + parentEarTagNumber +
            ", type='" + type + '\'' +
            ", breed='" + breed + '\'' +
            ", birthDate=" + birthDate +
            ", gender='" + gender + '\'' +
            ", weight=" + weight +
            ", hasOffspring=" + hasOffspring +
            '}';
}

}
