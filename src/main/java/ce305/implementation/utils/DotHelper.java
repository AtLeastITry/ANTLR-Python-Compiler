package ce305.implementation.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ce305.abstraction.dot.DotConnection;
import ce305.abstraction.dot.DotNode;

public class DotHelper {
    public static Collection<DotNode> flattenConnections(List<DotConnection> connections) {
        Map<UUID, DotNode> result = new HashMap<UUID,DotNode>();

        for (DotConnection connection : connections) {
            if (!result.keySet().contains(connection.a.id)){
                result.put(connection.a.id, connection.a);
            }
            if (!result.keySet().contains(connection.b.id)){
                result.put(connection.b.id, connection.b);
            }   
        }

        return result.values();
    }
}