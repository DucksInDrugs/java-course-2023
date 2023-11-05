package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class hw4test {
    List<Animal> animalList = new ArrayList<>(List.of(
        new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
        new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
        new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false),
        new Animal("Elise", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 2, true),
        new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true)));
    @Test
    public void heightSortWithValuesTest() {
        List<Animal> expected = List.of(
            new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Elise", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 2, true),
            new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true),
            new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true)
        );
        assertEquals(expected, Animal.heightSort(animalList));
    }

    @Test
    public void heightSortWithEmptyListTest() {
        assertEquals(List.of(), Animal.heightSort(List.of()));
    }

    @Test
    public void weightSortWithValuesTest() {
        List<Animal> expected = List.of(
            new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true),
            new Animal("Elise", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 2, true),
            new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false)
        );
        assertEquals(expected, Animal.weightSort(animalList));
    }

    @Test
    public void weightSortWithEmptyValueTest() {
        assertEquals(List.of(), Animal.weightSort(List.of()));
    }

    @Test
    public void typeCountingWithValuesTest() {
        animalList.add(new Animal("Quinn", Animal.Type.BIRD, Animal.Sex.F, 10, 10, 10, true));
        Map<Animal.Type, Integer> expected = Map.of(
          Animal.Type.DOG, 1,
          Animal.Type.CAT, 1,
          Animal.Type.SPIDER, 1,
          Animal.Type.BIRD, 2,
          Animal.Type.FISH, 1
        );
        assertEquals(expected, Animal.typeCounting(animalList));
    }

    @Test
    public void typeCountingWithEmptyTest() {
        assertEquals(Map.of(), Animal.typeCounting(List.of()));
    }

    @Test
    public void longestNameWithValuesTest() {
        Animal expected = new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true);
        assertEquals(expected, Animal.longestName(animalList));
    }

    @Test
    public void longestNameWithEmptyTest() {
        assertNull(Animal.longestName(List.of()));
    }

    @Test
    public void mostSexTypeWithValuesTest() {
        assertEquals(Animal.Sex.F, Animal.mostSexType(animalList));
    }

    @Test
    public void mostSexTypeWithEmptyTest() {
        assertNull(Animal.mostSexType(List.of()));
    }

    @Test
    public void heaviestAnimalByTypeWithValuesTest() {
        animalList.add(new Animal("Gwen", Animal.Type.SPIDER, Animal.Sex.F, 17, 5, 40, true));
        animalList.add(new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 10, 30, true));
        Map<Animal.Type, Animal> expected = Map.of(
            Animal.Type.DOG, new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            Animal.Type.CAT, new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true),
            Animal.Type.SPIDER, new Animal("Gwen", Animal.Type.SPIDER, Animal.Sex.F, 17, 5, 40, true),
            Animal.Type.BIRD, new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
            Animal.Type.FISH, new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 10, 30, true)
        );
        assertEquals(expected, Animal.heaviestAnimalByType(animalList));
    }

    @Test
    public void heaviestAnimalByTypeWithEmptyTest() {
        assertEquals(Map.of(), Animal.heaviestAnimalByType(List.of()));
    }

    @Test
    public void oldestAnimalWithValuesTest() {
        Animal expected = new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true);
        assertEquals(expected, Animal.oldestAnimal(animalList));
    }

    @Test
    public void oldestAnimalWithEmptyTest() {
        assertNull(Animal.oldestAnimal(List.of()));
    }

    @Test
    public void heaviestAnimalWithAnswerTest() {
        Optional<Animal> expected = Optional.of(new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true));
        assertEquals(expected, Animal.heaviestAnimal(animalList, 3));
    }

    @Test
    public void heaviestAnimalWithoutAnswerTest() {
        Optional<Animal> expected = Optional.empty();
        assertEquals(expected, Animal.heaviestAnimal(animalList, 1));
    }

    @Test
    public void heaviestAnimalWithEmpty() {
        Optional<Animal> expected = Optional.empty();
        assertEquals(expected, Animal.heaviestAnimal(List.of(), 100));
    }

    @Test
    public void pawsCountWithValuesTest() {
        Integer expected = 18;
        assertEquals(expected, Animal.pawsCount(animalList));
    }

    @Test
    public void pawsCountWithEmptyTest() {
        Integer expected = 0;
        assertEquals(expected, Animal.pawsCount(List.of()));
    }

    @Test
    public void getAnimalsWithAgeNotEqualsPawsWithValuesTest() {
        List<Animal> expected = List.of(
            new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Elise", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 2, true)
        );
        assertEquals(expected, Animal.getAnimalsWithAgeNotEqualsPaws(animalList));
    }

    @Test
    public void getAnimalsWithAgeNotEqualsPawsWithEmptyTest() {
        assertEquals(List.of(), Animal.getAnimalsWithAgeNotEqualsPaws(List.of()));
    }

    @Test
    public void getBitingAnimalsWithAnswerTest() {
        Animal expected = new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true);
        List<Animal> expectedList = List.of(expected);
        animalList.add(expected);
        assertEquals(expectedList, Animal.getBitingAnimals(animalList));
    }

    @Test
    public void getBitingAnimalsWithoutAnswerTest() {
        assertEquals(List.of(), Animal.getBitingAnimals(animalList));
    }

    @Test
    public void getBitingAnimalsWithEmptyTest() {
        assertEquals(List.of(), Animal.getBitingAnimals(List.of()));
    }

    @Test
    public void animalWeightGreaterHeightCountWithValuesTest() {
        Integer expected = 3;
        assertEquals(expected, Animal.animalWeightGreaterHeightCount(animalList));
    }

    @Test
    public void animalWeightGreaterHeightCountWithEmptyTest() {
        Integer expected = 0;
        assertEquals(expected, Animal.animalWeightGreaterHeightCount(List.of()));
    }

    @Test
    public void getComplexNameAnimalsWithAnswerTest() {
        Animal expected = new Animal("Tahm Kench TK", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true);
        animalList.add(expected);
        List<Animal> expectedList = List.of(expected);
        assertEquals(expectedList, Animal.getComplexNameAnimals(animalList));
    }

    @Test
    public void getComplexNameAnimalsWithoutAnswerTest() {
        assertEquals(List.of(), Animal.getComplexNameAnimals(animalList));
    }

    @Test
    public void getComplexNameAnimalsWithEmptyTest() {
        assertEquals(List.of(), Animal.getComplexNameAnimals(List.of()));
    }

    @Test
    public void isDogHigherTrueTest() {
        assertTrue(Animal.isDogHigher(animalList, 2));
    }

    @Test
    public void isDogHigherFalseTest() {
        assertFalse(Animal.isDogHigher(animalList, 3));
    }

    @Test
    public void isDogHigherWithEmptyTest() {
        assertFalse(Animal.isDogHigher(List.of(), 1));
    }

    @Test
    public void sumWeightInRangeOfAgeWithAnswerTest() {
        Map<Animal.Type, Integer> expected = Map.of(
            Animal.Type.DOG, 5
        );
        assertEquals(expected, Animal.sumWeightInRangeOfAge(animalList, 3, 3));
    }

    @Test
    public void sumWeightInRangeOfAgeWithoutAnswerTest() {
        assertEquals(Map.of(), Animal.sumWeightInRangeOfAge(animalList, 5, 10));
    }

    @Test
    public void sumWeightInRangeOfAgeWithEmptyTest() {
        assertEquals(Map.of(), Animal.sumWeightInRangeOfAge(List.of(), 1, 50));
    }

    @Test
    public void specialSortWithValuesTest() {
        animalList.add(new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true));
        List<Animal> expected = List.of(
            new Animal("Yuumi", Animal.Type.CAT, Animal.Sex.F, 4, 2, 4, true),
            new Animal("Warwick", Animal.Type.DOG, Animal.Sex.M, 3, 3, 5, true),
            new Animal("Anivia", Animal.Type.BIRD, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true),
            new Animal("Elise", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 2, true)
        );
        assertEquals(expected, Animal.specialSort(animalList));
    }

    @Test
    public void specialSortWithEmptyTest() {
        assertEquals(List.of(), Animal.specialSort(List.of()));
    }

    @Test
    public void isSpidersBitesMoreOftenThanDogsWithAnswerTest() {
        assertFalse(Animal.isSpidersBitesMoreOftenThanDogs(animalList));
    }

    @Test
    public void isSpidersBitesMoreOftenThanDogsWithEmptyTest() {
        assertFalse(Animal.isSpidersBitesMoreOftenThanDogs(List.of()));
    }

    @Test
    public void heaviestFishInListsWithAnswerTest() {
        Animal expected = new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true);
        List<Animal> extraList = List.of(
            new Animal("Fizz", Animal.Type.FISH, Animal.Sex.M, 1, 1, 1, false),
            new Animal("Tahm Kench", Animal.Type.FISH, Animal.Sex.M, 1000, 101, 30, true)
        );
        List<List<Animal>> listOfAnimalLists = List.of(animalList, extraList);
        assertEquals(expected, Animal.heaviestFishInLists(listOfAnimalLists));
    }

    @Test
    public void heaviestFishInListsWithEmptyTest() {
        assertNull(Animal.heaviestFishInLists(List.of()));
    }

    @Test
    public void errorsInRecordsWithValuesTest() {
        animalList.add(new Animal("", Animal.Type.CAT, null, -10, 2, 5, true));
        animalList.add(new Animal("Clown", null, null, 100,3456, 4, true));
        Map<String, Set<ValidationError>> expected = Map.of(
            "Warwick", Set.of(),
            "Fizz", Set.of(),
            "Anivia", Set.of(),
            "Yuumi", Set.of(),
            "Elise", Set.of(),
            "", Set.of(new ValidationError("Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE), new ValidationError("Age, Height and Weight must be greater than 0", ValidationErrorType.INCORRECT_VALUE)),
            "Clown", Set.of(new ValidationError("Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE))
        );
        assertEquals(expected, Animal.errorsInRecords(animalList));
    }

    @Test
    public void errorsInRecordsWithEmptyTest() {
        assertEquals(Map.of(), Animal.errorsInRecords(List.of()));
    }

    @Test
    public void moreReadableResultWithValuesTest() {
        animalList.add(new Animal("", Animal.Type.CAT, null, -10, 2, 5, true));
        animalList.add(new Animal("Clown", null, null, 100,3456, 4, true));
        Map<String, String> expected = Map.of(
            "Warwick", "",
            "Fizz", "",
            "Anivia", "",
            "Yuumi", "",
            "Elise", "",
            "", "Type, Name and Sex must not be null. Age, Height and Weight must be greater than 0",
            "Clown", "Type, Name and Sex must not be null"
        );
        assertEquals(expected, Animal.moreReadableResult(animalList));
    }
}
