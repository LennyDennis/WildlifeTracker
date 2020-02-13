import org.sql2o.*;
import java.sql.Timestamp;
import java.util.List;

public class Sightings {
    private int id;
    private int animalId;
    private String sightLocation;
    private String rangerName;
    private Timestamp viewed;

    public Sightings(int animalId, String sightLocation, String rangerName){
        this.animalId = animalId;
        this.sightLocation = sightLocation;
        this.rangerName = rangerName;
    }
    public int getAnimalId(){
        return animalId;
    }

    public String getSightLocation(){
        return sightLocation;
    }
    public String getRangerName(){
        return rangerName;
    }

    public int getId() {
        return id;
    }
    public Timestamp getViewed(){

        return viewed;
    }

    @Override
    public boolean equals(Object aSightings){
        if(!(aSightings instanceof Sightings)){
            return false;
        }else {
            Sightings newSighting = (Sightings) aSightings;
            return this.getAnimalId() == (newSighting.getAnimalId()) &&
                    this.getSightLocation().equals(newSighting.getSightLocation()) &&
                    this.getRangerName().equals(newSighting.getRangerName());
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings (animalid, sight_location, rangername, viewed) VALUES (:animalId, :sightLocation, :rangerName, now())";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalId",this.animalId)
                    .addParameter("sightLocation",this.sightLocation)
                    .addParameter("rangerName",this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sightings> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
        }
    }
    public static Sightings find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id = :id";
            Sightings sighting = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sightings.class);
                return sighting;
        }
        }
    }

