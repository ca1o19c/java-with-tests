import com.learning.javawithtests.domain.User;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals("Comparison Error", 1, 1);
        Assert.assertEquals(0.51234, 0.512, 0.001);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        int i = 5;
        Integer j = 5;
        Assert.assertEquals(Integer.valueOf(i), j);
        Assert.assertEquals(i, j.intValue());

        Assert.assertEquals("keyboard", "keyboard");
        Assert.assertNotEquals("Keyboard", "Mouse");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        var u1 = new User("Usuario 1");
        var u2 = new User("Usuario 1");
        User u3 = null;
        Assert.assertEquals(u1, u2);
        Assert.assertSame(u2, u2);
        Assert.assertNotSame(u1, u2);
        Assert.assertNull(u3);
        Assert.assertNotNull(u1);
    }
}
