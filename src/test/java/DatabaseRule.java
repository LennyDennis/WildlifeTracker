import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before(){
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "lenny", " ");
        String connectionString = "jdbc:postgresql://ukywkmtapdfthq:d46cce2f76206e06180033f9168fa2c62a82969473488869b1b860f9902d3638@ec2-184-72-235-159.compute-1.amazonaws.com:5432/dfqcaadhibtj93"; //!
        DB.sql2o = new Sql2o(connectionString, "ukywkmtapdfthq", "d46cce2f76206e06180033f9168fa2c62a82969473488869b1b860f9902d3638"); //!

    }

    @Override
    protected void after(){
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}
