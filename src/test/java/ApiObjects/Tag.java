package ApiObjects;

public class Tag {
    private int id;
    private String name;

    public Tag(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tag))
            return false;
        else
            return (this.id == ((Tag) o).getId() && this.name.equals(((Tag) o).getName()));
    }
}
