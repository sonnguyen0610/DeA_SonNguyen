public class Student {
    private int ID;
    private String Name;
    private String Email;
    private int bonus,report,app;
    private double lt;

    public Student() {
    }

    public Student(int ID, String name, String email, int bonus, int report, int app, double lt) {
        this.ID = ID;
        Name = name;
        Email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public int getBonus() {
        return bonus;
    }

    public int getReport() {
        return report;
    }

    public int getApp() {
        return app;
    }

    public double getLt() {
        return lt;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("ID=").append(ID);
        sb.append(", Name='").append(Name).append('\'');
        sb.append(", Email='").append(Email).append('\'');
        sb.append(", bonus=").append(bonus);
        sb.append(", report=").append(report);
        sb.append(", app=").append(app);
        sb.append(", lt=").append(lt);
        sb.append('}');
        return sb.toString();
    }
}
