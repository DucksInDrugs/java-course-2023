package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("MagicNumber")
public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static List<Animal> heightSort(List<Animal> inputList) {
        return inputList.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> weightSort(List<Animal> inputList) {
        return inputList.stream().sorted(Comparator.comparing(Animal::weight).reversed()).toList();
    }

    public static Map<Type, Integer> typeCounting(List<Animal> inputList) {
        return inputList.stream().collect(Collectors.toMap(animal -> animal.type, animal -> 1, Integer::sum));
    }

    public static Animal longestName(List<Animal> inputList) {
        return inputList.stream().max(Comparator.comparing(animal -> animal.name.length())).orElse(null);
    }

    public static Sex mostSexType(List<Animal> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting())).entrySet()
            .stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static Map<Type, Animal> heaviestAnimalByType(List<Animal> inputList) {
        return inputList.stream().collect(Collectors.toMap(
            Animal::type, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Animal::weight))));
    }

    public static Animal oldestAnimal(List<Animal> inputList) {
        return inputList.stream().max(Comparator.comparing(Animal::age)).orElse(null);
    }

    public static Optional<Animal> heaviestAnimal(List<Animal> inputList, int k) {
        return inputList.stream().filter(animal -> animal.height < k).max(Comparator.comparing(Animal::weight));
    }

    public static Integer pawsCount(List<Animal> inputList) {
        return inputList.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> getAnimalsWithAgeNotEqualsPaws(List<Animal> inputList) {
        return inputList.stream().filter(animal -> animal.age != animal.paws()).toList();
    }


    public static List<Animal> getBitingAnimals(List<Animal> inputList) {
        return inputList.stream().filter(animal -> animal.bites && animal.height > 100).toList();
    }

    public static Integer animalWeightGreaterHeightCount(List<Animal> inputList) {
        return (int) inputList.stream().filter(animal -> animal.weight > animal.height).count();
    }

    public static List<Animal> getComplexNameAnimals(List<Animal> inputList) {
        return inputList.stream().filter(animal -> animal.name.split(" ").length > 2).toList();
    }

    public static Boolean isDogHigher(List<Animal> inputList, int k) {
        return inputList.stream().anyMatch(animal -> animal.type == Type.DOG && animal.height > k);
    }

    public static Map<Type, Integer> sumWeightInRangeOfAge(List<Animal> inputList, int k, int l) {
        return inputList.stream().filter(animal -> animal.age >= k && animal.age <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> specialSort(List<Animal> inputList) {
        return inputList.stream().sorted(Comparator.comparing(Animal::type)
            .thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public static Boolean isSpidersBitesMoreOftenThanDogs(List<Animal> inputList) {
        long bitingSpiders = inputList.stream().filter(animal -> animal.type == Type.SPIDER && animal.bites).count();
        long bitingDogs = inputList.stream().filter(animal -> animal.type == Type.DOG && animal.bites).count();
        if (bitingDogs == 0 && bitingSpiders == 0) {
            return false;
        } else {
            return bitingSpiders > bitingDogs;
        }
    }

    public static Animal heaviestFishInLists(List<List<Animal>> inputList) {
        return inputList.stream().flatMap(Collection::stream).filter(animal -> animal.type == Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).orElse(null);
    }

    public static Map<String, Set<ValidationError>> errorsInRecords(List<Animal> inputList) {
        return inputList.stream().collect(Collectors.toMap(Animal::name, Animal::validationErrors));
    }

    private static Set<ValidationError> validationErrors(Animal animal) {
        Set<ValidationError> validationErrors = new HashSet<>();
        if (animal.type == null || animal.name == null || animal.sex == null) {
            validationErrors.add(new ValidationError(
                "Type, Name and Sex must not be null", ValidationErrorType.NULL_VALUE));
        }
        if (animal.age <= 0 || animal.weight <= 0 || animal.height <= 0) {
            validationErrors.add(new ValidationError(
                "Age, Height and Weight must be greater than 0", ValidationErrorType.INCORRECT_VALUE));
        }
        return validationErrors;
    }

    public static Map<String, String> moreReadableResult(List<Animal> inputList) {
        return errorsInRecords(inputList).entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.join(". ", entry.getValue()
                .stream().map(ValidationError::getMessage).toList())));
    }
}
