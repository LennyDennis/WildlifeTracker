import org.sql2o.*;
import java.util.List;

public abstract class Animal {


    public String healthLevel;
    public String ageLevel;
    public String name;
    public int id;
    public String type;
    public String getHealthLevel() {
        return healthLevel;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        }else {
            Animal newNormalAnimal = (Animal) otherAnimal;
            return this.getName().equals(((Animal) otherAnimal).getName());
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name,type,health,age) VALUES (:name,:type,:health,:age);";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .addParameter("health",this.healthLevel)
                    .addParameter("age",this.ageLevel)
                    .executeUpdate()
                    .getKey();
        }
    }
    public List<Sightings> getSightings() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animalid = :id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }

    }
}
