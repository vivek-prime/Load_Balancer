import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public class LoadBalancer {
    private static int maxNodes = 10;
    private Map<String, ApplicationNode> applicationNodeMap;
    private List<String> usedNodeIds;

    public LoadBalancer() {
        usedNodeIds = new ArrayList<>();
        applicationNodeMap = new HashMap<>();
    }

    public void addApplicationNodes(List<ApplicationNode> nodesList) throws Exception {
        if (this.usedNodeIds.size() + nodesList.size() > maxNodes)
            throw new Exception("Max limit exceeded");

        for (ApplicationNode applicationNode : nodesList) {
            String nodeId = applicationNode.getNodeId();
            if (!usedNodeIds.contains(nodeId)) {
                applicationNodeMap.put(nodeId, applicationNode);
                usedNodeIds.add(nodeId);
            } else
                log.error("Duplicate Node id - " + nodeId);
        }
    }

    public void removeApplicationNodes(List<String> nodeIdsList) throws Exception {
        if (this.usedNodeIds.size() == 0)
            throw new Exception("No Application Servers");
        for (String nodeId : nodeIdsList) {
            if (usedNodeIds.contains(nodeId)) {
                applicationNodeMap.remove(nodeId);
                usedNodeIds.remove(nodeId);
            } else
                log.error("Invalid Node id - " + nodeId);
        }
    }
}
