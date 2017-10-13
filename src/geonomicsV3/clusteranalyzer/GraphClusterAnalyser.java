package geonomicsV3.clusteranalyzer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class GraphClusterAnalyser<M extends GraphNode> {
	
	/*
	 * This method iterates through all nodes in a given graph and find each cluster.
	 * Then a MAX cluster will be located given rules which define how a cluster is considered
	 * to be MAX. This method provides a generic way to process any kinds of graphs to find a Max
	 * cluster.
	 * 
	 */
	
	public Cluster<M> getMaxCluster(Graph<M> graph, ClustersList<Cluster<M>> clustersList ){
		HashSet<M> allNodes = new HashSet<M>();
		allNodes.addAll(graph.getAllNodes());
		HashSet<M> currentNodes = new HashSet<M>();
		while(!allNodes.isEmpty()){
			
			M gnode = allNodes.iterator().next();
			allNodes.remove(gnode);
			currentNodes.add(gnode);
			Cluster<M> cluster = clustersList.addCluster();
			while(!currentNodes.isEmpty()){
				M gnode2 = currentNodes.iterator().next();
				Collection<M> relatedNodes = graph.getNextNode(gnode2);
				for(M tempGnode:relatedNodes){
					if(allNodes.contains(tempGnode)){
						currentNodes.add(tempGnode);
						allNodes.remove(tempGnode);
					}
						
				}
				cluster.add(gnode2);
				currentNodes.remove(gnode2);
			}
			clustersList.add(cluster);
		}
	
		Collections.sort(clustersList);
		Cluster<M> maxCluster = (Cluster<M>) clustersList.get(0);
		Collections.sort(maxCluster);
		return clustersList.get(0);
	}

}
