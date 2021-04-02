package models;

public class Client {
    private String CPF;
    private String name;
    private String email;
    private String tel;

    public Client(String CPF, String name, String email, String tel) {
        this.CPF = CPF;
        this.name = name;
        this.email = email;
        this.tel = tel;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return name + "," + CPF + "," + email + "," + tel;
    }
}
