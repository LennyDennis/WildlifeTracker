import org.sql2o.Connection;

import java.util.List;

public class NormalAnimal extends Animal {
    public static final String DATABASE_TYPE = "Not Endangered";

    public NormalAnimal(String name) {
        this.name = name;
        type = DATABASE_TYPE;
    }

    public static List<NormalAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='Not Endangered'";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimal.class);
        }
    }

    public static NormalAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            NormalAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NormalAnimal.class);
            return animal;
        }
    }
}
