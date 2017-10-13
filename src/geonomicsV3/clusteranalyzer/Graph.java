package geonomicsV3.clusteranalyzer;
import java.util.Collection;

/**
 * 
 * @author 
 *
 */
public interface Graph<M extends GraphNode> {
	
	/*
	 * retrieve all Nodes
	 * @return a collection of GraphNodes
	 */
	public Collection<M> getAllNodes();
	
	/*
	 * get all nodes related to the given node 
	 * @param graphNode
	 * @return a collection of GraphNodes
	 */
	public Collection<M> getNextNode(M node);
}
