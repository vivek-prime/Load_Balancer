import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class LoadBalancerTest {

    @Test
    public void testLoadBalancer() throws Exception {
        List<ApplicationNode> addList = new ArrayList<>();
        addList.add(new ApplicationNode("101", true));
        addList.add(new ApplicationNode("102", true));
        addList.add(new ApplicationNode("103", true));
        addList.add(new ApplicationNode("103", true));
        LoadBalancer loadBalancer = new LoadBalancer(addList);

        assertEquals(loadBalancer.getUsedNodeIds().size(), 3);
    }
}