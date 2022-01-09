import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOrder {

    public static int cont = 0;

    @Test
    public void start() {
        cont = 1;
    }

    @Test
    public void verify() {
        assertEquals(1, cont);
    }
}
