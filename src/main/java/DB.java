import org.sql2o.*;

public class DB {

//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "lenny", " ");
    public static String connectionString = "jdbc:postgresql://ec2-50-17-178-87.compute-1.amazonaws.com:5432/d4j2d175a39ddv";
    public static Sql2o sql2o = new Sql2o(connectionString, "igcdveckmrjegr", "15e056595699a9b71cbe5cd1a52804383d329c01c73e3311dbe1f4471a9620b9");

}
