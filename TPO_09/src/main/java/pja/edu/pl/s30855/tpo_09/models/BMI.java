package pja.edu.pl.s30855.tpo_09.models;

public class BMI {
    private double weight;
    private double height;
    private double bmi;
    private String type;

    public BMI(){}

    public BMI (double weight, double height, double bmi, String type){
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.type = type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmi() {
        return bmi;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
