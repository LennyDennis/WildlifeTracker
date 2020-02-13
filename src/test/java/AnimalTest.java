//import org.junit.Rule;
//import org.junit.Test;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//    Animal testAnimal = new Animal("cat");
//
//    @Test
//    public void animal_instanceOfAnimal_true(){
//        assertEquals(true, testAnimal instanceof Animal);
//    }
//    @Test
//    public void getName_returnNameOfAnimal_cat(){
//        assertEquals("cat", testAnimal.getName());
//    }
//    @Test
//    public void equals_returnsTrueIfNamesAreTheSame_true(){
//        Animal testAnimal1 = new Animal("cat");
//        assertTrue(testAnimal.equals(testAnimal1));
//    }
//    @Test
//    public void save_savesAnimalInstanceToDB_Animal(){
//        testAnimal.save();
//        assertTrue(Animal.all().get(0).equals(testAnimal));
//    }
//    @Test
//    public void all_returnsAllInstancesOfAnimal_true(){
//        Animal testAnimal1 = new Animal("Dog");
//        testAnimal1.save();
//        testAnimal.save();
//        assertEquals(true, testAnimal1.all().get(0).equals(testAnimal1));
//        assertEquals(true, testAnimal.all().get(1).equals(testAnimal));
//    }
//    @Test
//    public void id_assignIdToSpecificInstance(){
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//    @Test
//    public void getMonsters_retrievesAllMonstersFromDB_monsterList(){
//        Animal testAnimal1 = new Animal("cat");
//        testAnimal1.save();
//        Sightings firstSightings = new Sightings(testAnimal1.getId(),"Zone A","Lenny");
//        firstSightings.save();
//        Sightings secondSightings = new Sightings(testAnimal1.getId(),"Zone A","Lenny");
//        secondSightings.save();
//        Sightings[] sightings = new Sightings[]{firstSightings,secondSightings};
//        assertTrue(testAnimal1.getSightings().containsAll(Arrays.asList(sightings)));
//
//    }
//    @Test
//    public void Animal_instantiatesWithOkayHealthLevel(){
//        assertEquals(testAnimal.getHealthLevel(),(Animal.OKAY_LEVEL));
//    }
//    @Test
//    public void Animal_instantiatesWithYoungAgeLevel(){
//        assertEquals(testAnimal.getAgeLevel(),(Animal.YOUNG_LEVEL));
//    }
//}