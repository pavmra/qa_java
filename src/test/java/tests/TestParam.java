package tests;

import com.example.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestAnimal {


    @Test
    void testTravoyad() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, animal.getFood("Травоядное"));
    }

    @Test
    void testPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, animal.getFood("Хищник"));
    }
    @Test
    void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}