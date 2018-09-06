package entity;

public class Department {
    private int did;
    private String name;
    private String password;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
