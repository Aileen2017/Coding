package geonomicsV3.unittest;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import geonomicsV3.clusteranalyzer.GeoGrid;
import geonomicsV3.clusteranalyzer.GeoNode;
/**
 * 
 * @author 
 *
 */
public class GeoGridTest {
	
	
	@Test
	public void testGetNextNodes(){
		Map<Integer, GeoNode> nodes = new HashMap<Integer, GeoNode>();
		GeoGrid geoGrid = new GeoGrid(7, 4, nodes);
		GeoNode node1 = new GeoNode(4, "Tom", "2010-10-10" );
		GeoNode node2 = new GeoNode(5, "Katie", "2010-10-10" );
		GeoNode node3 = new GeoNode(6, "Nicole", "2010-10-10" );
		GeoNode node4 = new GeoNode(11, "Mel", "2010-10-10" );
		GeoNode node5 = new GeoNode(13, "Matt", "2010-10-10" );
		GeoNode node6 = new GeoNode(15, "Mel", "2010-10-10" );
		GeoNode node7 = new GeoNode(17, "Patrick", "2010-10-10" );
		GeoNode node8 = new GeoNode(21, "Catherine", "2010-10-10" );
		GeoNode node9 = new GeoNode(22, "Michael", "2010-10-10" );
		nodes.put(node1.value, node1);
		nodes.put(node2.value, node2);
		nodes.put(node3.value, node3);
		nodes.put(node4.value, node4);
		nodes.put(node5.value, node5);
		nodes.put(node6.value, node6);
		nodes.put(node7.value, node7);
		nodes.put(node8.value, node8);
		nodes.put(node9.value, node9);
		Collection<GeoNode> relatedNodes = geoGrid.getNextNode(node1);
		assertTrue(relatedNodes.contains(node2));
		assertTrue(relatedNodes.contains(node4));
		
	}

}


