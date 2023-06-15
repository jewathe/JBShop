package learn.android.w14exampratiquejean.entity;

public class TypeMenu extends Entity{
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeMenu(int id, String description) {
        super(id);
        this.description = description;
    }

    public TypeMenu(int id) {
        super(id);
    }
}
