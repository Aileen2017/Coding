package geonomicsV3.clusteranalyzer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 
 *
 */
public class GeoGrid implements Graph<GeoNode> {
	
	int gridWidth;
	int gridHeight;
	
	Map<Integer, GeoNode> geoNodes = new HashMap<Integer, GeoNode>(); 
	
	public GeoGrid(int _gridWidth, int _gridHeight, Map<Integer, GeoNode> _geoNodes){
		gridWidth = _gridWidth;
		gridHeight = _gridHeight;
		geoNodes = _geoNodes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see geonomicsV2.clusteranalyzer.Graph#getAllNodes()
	 */
	
	@Override
	public Collection<GeoNode> getAllNodes() {
		return geoNodes.values();
	}

	/*
	 * (non-Javadoc)
	 * @see geonomicsV2.clusteranalyzer.Graph#getNextNode(geonomicsV2.clusteranalyzer.GraphNode)
	 */
	
	@Override
	public Collection<GeoNode> getNextNode(GeoNode geoNode) {
		
		List<GeoNode> nextNodes = new ArrayList<GeoNode>();
		
		if(geoNode.getValue() % gridWidth != 0)
		{
			GeoNode leftNode = geoNodes.get(geoNode.getValue()-1);
			if(leftNode != null)
			{
				nextNodes.add(leftNode);
			}
		}
		if(geoNode.getValue()%gridWidth != (gridWidth-1)){
			GeoNode rightNode = geoNodes.get(geoNode.getValue()+1);
			if(rightNode != null){
				nextNodes.add(rightNode);
			}
		}
		if(((Integer)geoNode.getValue()+gridWidth)< (gridWidth * gridHeight)){
			GeoNode topNode = geoNodes.get(geoNode.getValue()+gridWidth);
			if(topNode!=null){
				nextNodes.add(topNode);
			}
		}
		if((geoNode.getValue()-gridWidth)>0){
			GeoNode lowerNode = geoNodes.get(geoNode.getValue()-gridWidth);
			if(lowerNode !=null){
				nextNodes.add(lowerNode);
			}
		}
				
		return nextNodes;
	}

	

}
