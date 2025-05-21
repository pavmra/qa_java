package tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestCat {

    @Mock
    Feline feline;

    @Test
    void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}