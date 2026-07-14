package pja.edu.pl.s30855.tpo_09.models;

public class BMR {
    private String gender;

    private double weight;

    private double height;

    private int age;

    private int bmr;

    public BMR(){}

    public BMR (String gender, double weight, double height, int age, int bmr){
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.bmr = bmr;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getBmr() {
        return bmr;
    }

    public void setBmr(int bmr) {
        this.bmr = bmr;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
