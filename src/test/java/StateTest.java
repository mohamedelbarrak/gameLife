
import org.example.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.example.State.ALIVE;
import static org.example.State.DEAD;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
public class StateTest {


    @Test
    void should_born_with_3_neighbours() {
        assertEquals(ALIVE, DEAD.withLiveNeighbours(3));
    }

    @Test
    void should_die_with_4_neighbours() {
        assertEquals(DEAD, ALIVE.withLiveNeighbours(4));
    }

    @Test
    void should_die_with_no_neighbours() {
        assertEquals(DEAD, ALIVE.withLiveNeighbours(0));
    }

    @Test
    void should_survive_with_two_OR_THREE_neighbours() {
        assertEquals(ALIVE, ALIVE.withLiveNeighbours(2));
        assertEquals(ALIVE, ALIVE.withLiveNeighbours(3));
    }

    @Test
    void should_remain_dead_with_2_neighbours_v1() {
        assertEquals(DEAD, DEAD.withLiveNeighbours(2));
    }



    @Parameterized.Parameters
    public static List<State> data(){
        List<State> a = new ArrayList<State>();// String[] vowels = {"a","e","i","o","u"};
        a.add(DEAD);
        return a;
    }
    //@ParameterizedTest
    //@ValueSource(ints = {2})//@ValueSource(strings = {"", "  "})//  @NullSource//  @EmptySource//  @NullAndEmptySource//  @NullAndEmptySource  @ValueSource(strings = {"  ", "\t", "\n"})//   @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"}, mode = EnumSource.Mode.EXCLUDE)

    @Parameterized.Parameter(2)
    public int input;

    @Test
    void should_remain_dead_with_2_neighbours_v2(int number) {
        assertEquals(DEAD, DEAD.withLiveNeighbours(input));
    }


    @Test
    @ValueSource(ints = {2})
    void should_remain_dead_with_2_neighbours_v3(int number) {
        assertEquals(DEAD, DEAD.withLiveNeighbours(number));
    }



}
