import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class RealCollatzTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(collatzproject.RealCollatz.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getLowerBound() {
    }

    @Test
    public void setLowerBound() {
    }

    @Test
    public void getUpperBound() {
    }

    @Test
    public void setUpperBound() {
    }

    @Test
    public void getCollatzNumbers() {
    }

    @Test
    public void getCalculations() {
    }
}
