package ApiObjects;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
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
    public boolean equals(Object o){
        if (!(o instanceof Category))
                return false;
        else
            return (this.id == ((Category) o).getId() && this.name.equals(((Category) o).getName()));
    }
}
