package geonomicsV3.unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import org.junit.Before;
import org.junit.Test;

import geonomicsV3.clusteranalyzer.ClustersList;
import geonomicsV3.clusteranalyzer.GeoCluster;
import geonomicsV3.clusteranalyzer.GeoClustersList;
import geonomicsV3.clusteranalyzer.GeoGrid;
import geonomicsV3.clusteranalyzer.GeoNode;
import geonomicsV3.clusteranalyzer.GeoNodesList;
import geonomicsV3.clusteranalyzer.Graph;
import geonomicsV3.clusteranalyzer.GraphClusterAnalyser;
import geonomicsV3.clusteranalyzer.GraphFactory;
import geonomicsV3.clusteranalyzer.GraphNode;
/**
 * 
 * @author 
 *
 */
public class ClusterAnalyzerTest {
	
	GeoGrid graph;
	GraphClusterAnalyser graphClusterAnalyser;
	ClustersList geoClustersList;
	
	@Before
	public void setUp() throws Exception{
		graphClusterAnalyser = new GraphClusterAnalyser();
		geoClustersList = new GeoClustersList();
	}
	

	@Test
	public void testGetMaxCluster() throws Exception{
		graph = GraphFactory.generateGeoGrid(7,4, "GeoBlockExample.csv");
		GeoCluster cluster = (GeoCluster) graphClusterAnalyser.getMaxCluster(graph, geoClustersList);
		int[] expectedValues = {4,5,6,11,13};
		
		int index = 0;
		for(GraphNode gnode : cluster){
			GeoNode tempGnode = (GeoNode)gnode;
			System.out.println(tempGnode.value+","+tempGnode.occupierName +","+tempGnode.date);
			assertEquals("",(Integer)tempGnode.getValue(),(Integer)expectedValues[index++]);
			
		}
	}
	
	@Test
	public void testGetMaxCluster2() throws Exception{
		graph = GraphFactory.generateGeoGrid(4, 7, "GeoBlockExample.csv");
		Collection<GraphNode> cluster = graphClusterAnalyser.getMaxCluster(graph,geoClustersList);
		int[] expectedValues = {13,17,21,22};
		
		int index = 0;
		for(GraphNode gnode : cluster){
			GeoNode tempGnode = (GeoNode)gnode;
			System.out.println(tempGnode.value+","+tempGnode.occupierName +","+tempGnode.date);
			assertEquals("",(Integer)tempGnode.getValue(),(Integer)expectedValues[index++]);
			
		}
	}
	

}
