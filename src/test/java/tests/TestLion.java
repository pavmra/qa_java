package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestLion {

    @Mock
    Feline feline;

    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "123", ""})
    void testInvalidSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}