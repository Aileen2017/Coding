package geonomicsV3.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geonomicsV3.clusteranalyzer.GeoGrid;
import geonomicsV3.clusteranalyzer.GraphFactory;
/**
 * 
 * @author 
 *
 */
public class GraphFactoryTest {
	
	@Test
	public void testGraph() throws Exception{		
		GeoGrid graph = GraphFactory.generateGeoGrid(7,4, "GeoBlockExample.csv");
		assertEquals("Check number of nodes", 9, graph.getAllNodes().size());
	}
	
	@Test(expected = Exception.class)
	public void testGraphFromCorruptedFile() throws Exception {		
		GeoGrid graph = GraphFactory.generateGeoGrid(7,4, "GeoGridCorrupted.csv");
		//assertEquals("Check number of nodes", 9, graph.getAllNodes().size());
	}

}
