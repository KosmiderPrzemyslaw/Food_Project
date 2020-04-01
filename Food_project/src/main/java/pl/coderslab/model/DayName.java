package pl.coderslab.model;

public class DayName {

    private int id;
    private String name;
    private int displayOrder;

    @Override
    public String toString() {
        return "DayName [id=" + id + ", name=" + name + ", displayOrder=" + displayOrder + "]";
    }

    public DayName(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayName(String name, int displayOrder) {
        this.name = name;
        this.displayOrder = displayOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
