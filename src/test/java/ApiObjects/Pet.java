package ApiObjects;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.Objects.equals;

public class Pet {
    private int id;
    private String name;
    private String status;
    private Category category;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;

    private Pet(){}

    private Pet(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.status = builder.status;
        this.category = builder.category;
        this.photoUrls = builder.photoUrls;
        this.tags = builder.tags;
    }

    public static class Builder{
        private final int id;
        private String name = "";
        private String status = "";
        private Category category = null;
        private ArrayList<String> photoUrls = null;
        private ArrayList<Tag> tags = null;

        public Builder(int id){
            this.id = id;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder  setPhotoUrls(ArrayList<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public Builder setTags(ArrayList<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public Pet build(){
            return new Pet(this);
        }
    }

    public ArrayList<String> getPhotoUrls ()
    {
        return photoUrls;
    }

    public String getName ()
    {
        return name;
    }

    public int getId ()
    {
        return id;
    }

    public Category getCategory ()
    {
        return category;
    }

    public ArrayList<Tag> getTags ()
    {
        return tags;
    }

    public String getStatus ()
    {
        return status;
    }

    @Override
    public boolean equals(Object otherPet){
        if (otherPet instanceof Pet) {
            Pet otherPet_2 = (Pet)otherPet;
            return (this.getId() == otherPet_2.getId() &&
                            this.getName().equals(otherPet_2.getName()) &&
                            this.getStatus().equals(otherPet_2.getStatus()) &&
                            Objects.equals(this.getCategory(), otherPet_2.getCategory()));
        }
        else
            return false;

    }

    @Override
    public String toString()
    {
        return "ClassPojo [photoUrls = "+photoUrls+", name = "+name+", id = "+id+", category = "+category+", tags = "+tags+", status = "+status+"]";
    }
}
