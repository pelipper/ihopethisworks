import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CollatzProxyTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(collatzproject.CollatzProxy.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getCollatzNumbers() {
    }

    @Test
    public void getCalculations() {
    }

    @Test
    public void getCollatzNumbers1() {
    }

    @Test
    public void getCollatzNumbers2() {
    }

    @Test
    public void getCalculations1() {
    }

    @Test
    public void getCalculations2() {
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
    public void getPredicateType() {
    }

    @Test
    public void setPredicateType() {
    }

    @Test
    public void getPredicateNumber() {
    }

    @Test
    public void setPredicateNumber() {
    }
}
