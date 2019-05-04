package shu.ces.filmsystem.Model;

public class Cinema extends User{
    private String city;
    private String address;
    private double star;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
