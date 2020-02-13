import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NewSightings {
    private int id;
    private int animalId;
    private String sightLocation;
    private String rangerName;
    private Timestamp viewed;

    public NewSightings(int animalId,String sightLocation, String rangerName){
        this.animalId = animalId;
        this.sightLocation = sightLocation;
        this.rangerName = rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getSightLocation() {
        return sightLocation;
    }

    public String getRangerName() {
        return rangerName;
    }
    public int getId(){
        return id;
    }

    public Timestamp getViewed() {
        return viewed;
    }

    public boolean equals(Object otherSightings){
        if(otherSightings instanceof NewSightings){
            NewSightings newSighting = (NewSightings) otherSightings;
            return this.getAnimalId()==(newSighting.getAnimalId())&&
                    this.getRangerName().equals(newSighting.getRangerName()) &&
                    this.getSightLocation().equals(newSighting.getSightLocation());
        }
        else {
            return false;
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
    public static List<NewSightings> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(NewSightings.class);
        }
    }
    public static NewSightings find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings where id=:id";
            NewSightings newSightings = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(NewSightings.class);
            return newSightings;
        }
    }
}
