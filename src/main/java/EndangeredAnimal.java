import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal  extends Animal{
    public String healthLevel;
    public String ageLevel;
    public static final String DATABASE_TYPE = "Endangered";

    public  EndangeredAnimal(String name,String healthLevel,String ageLevel){
        this.name = name;
        this.healthLevel = healthLevel;
        this.ageLevel = ageLevel;
        type = DATABASE_TYPE;
    }

    public String getHealthLevel(){
        return healthLevel;
    }
    public String getAgeLevel(){
        return ageLevel;
    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals WHERE type='Endangered'";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    @Override
    public void save(){        EndangeredAnimal testEndangeredAnimal1 = new EndangeredAnimal("cat","okay","young");

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
    public static EndangeredAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
}
