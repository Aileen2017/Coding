package geonomicsV3.clusteranalyzer;

import java.util.Collection;

/**
 * This class contains main method which takes three arguments from user inputs including 
 * width, height of a GeoBlock in the number of Geos and name of csv file that defines the 
 * occupied Geos for the GeoBlock.
 * Then it produces a graph from the given csv file and looks for blocks which are related
 * according to rules by using GraphClusterAnalyser in order to find one cluster with the max 
 * number of related GeoBlocks. Each occupied block in this found cluster will be printed out
 * to the console. When data input is not valid, exception will be thrown to report abnormalities.
 * 
 * 
 * 
 * @author 
 *
 */

public class GeoClusterAnalyser {
	
	public static void main(String[] args){
		
		try
		{
			GeoGrid graph = GraphFactory.generateGeoGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
			GraphClusterAnalyser graphClusterAnalyser = new GraphClusterAnalyser<GeoNode>();
			GeoClustersList geoClustersList = new GeoClustersList();
			Collection<GraphNode> maxCluster = graphClusterAnalyser.getMaxCluster(graph,geoClustersList);
			System.out.println("The Geos in the largest cluster of occupied Geos for this GeoBlock are");
			for(GraphNode gnode : maxCluster){
				GeoNode tempGnode = (GeoNode)gnode;
				System.out.println(tempGnode.value+","+tempGnode.occupierName +","+tempGnode.date);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}


	

