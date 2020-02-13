import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class NewSightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    NewSightings testSighting =new NewSightings(1,"Zone A","Lenny");

    @Test
    public void sighting_instanceOfNewSightings_true(){
        assertEquals(true, testSighting instanceof NewSightings);
    }
    @Test
    public void getAnimalId_getTheAnimalId_int(){
        assertEquals(1,testSighting.getAnimalId());
    }
    @Test
    public void getLocation_getSightingLocation_location(){
        assertEquals("Zone A",testSighting.getSightLocation());
    }
    @Test
    public void getRanger_getTheRangerName_ranger(){
        assertEquals("Lenny",testSighting.getRangerName());
    }
    @Test
    public void equal_checkWhetherNewSightingsContentAreTheSame_true(){
        NewSightings testSighting1 =new NewSightings(1,"Zone A","Lenny");
        assertTrue(testSighting.equals(testSighting1));
    }
    @Test
    public void save_returnsTrueIfTheSavedAreEqual(){
        testSighting.save();
        assertTrue(NewSightings.all().get(0).equals(testSighting));
    }
    @Test
    public void save_assignsIdToSpecificInstance(){
        testSighting.save();
        NewSightings savedNewSightings = NewSightings.all().get(0);
        assertEquals(savedNewSightings.getId(),testSighting.getId());
    }
    @Test
    public void all_returnsAllInstancesOfNewSightings_true(){
        testSighting.save();
        NewSightings testSighting1 =new NewSightings(1,"ZoneA","Lenny");
        testSighting1.save();
        assertEquals(true,NewSightings.all().get(0).equals(testSighting));
        assertEquals(true,NewSightings.all().get(1).equals(testSighting1));

    }
    @Test
    public void find_returnSpecificSighting_testSighting1(){
        testSighting.save();
        NewSightings testSighting1 =new NewSightings(1,"Zone A","Lenny");
        testSighting1.save();
        assertEquals(NewSightings.find(testSighting1.getId()),testSighting1);
    }
    @Test
    public void save_saveSAnimalIDIntoDb_true(){
        NormalAnimal testNormalAnimal = new NormalAnimal("cat");
        testNormalAnimal.save();
        NewSightings testSighting1 =new NewSightings(testNormalAnimal.getId(),"Zone A","Lenny");
        testSighting1.save();
        NewSightings savedSighting = NewSightings.find(testSighting1.getId());
        assertEquals(savedSighting.getAnimalId(), testNormalAnimal.getId());
    }
    @Test
    public void save_recordsWhenTheSightingWasViewed(){
        testSighting.save();
        Timestamp sightingViewed = NewSightings.find(testSighting.getId()).getViewed();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(),sightingViewed.getDay());
    }

}