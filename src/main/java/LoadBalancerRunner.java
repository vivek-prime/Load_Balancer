import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LoadBalancerRunner {
    public static void main(String[] args) throws Exception {
        List<ApplicationNode> addList = new ArrayList<>();
        addList.add(new ApplicationNode("101", true));
        addList.add(new ApplicationNode("102", true));
        addList.add(new ApplicationNode("103", true));
        addList.add(new ApplicationNode("103", true));

        LoadBalancer loadBalancer = new LoadBalancer(addList);

        // add node
        addList.clear();
        addList.add(new ApplicationNode("104", true));
        loadBalancer.addApplicationNodes(addList);
        log.info("Currently Nodes : " + loadBalancer.getUsedNodeIds());

        // remove node
        List<String> removeList = new ArrayList<>();
        removeList.add("104");
        removeList.add("103");
        loadBalancer.removeApplicationNodes(removeList);
        log.info("Currently Nodes : " + loadBalancer.getUsedNodeIds());
    }
}
