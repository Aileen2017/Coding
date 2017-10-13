package geonomicsV3.clusteranalyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 
 *
 */
public class GraphFactory {
	
	
	public static GeoGrid generateGeoGrid(Integer width, Integer height, String fileName) throws Exception{
		
		return new GeoGrid(width, height, generateGeoNodes(fileName));
		
	}
	
	private static Map<Integer, GeoNode> generateGeoNodes(String fileName) throws Exception{
		Map<Integer,GeoNode> map = new HashMap<Integer, GeoNode>();
		File f = new File(fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = null;
			int lineNumber = 1;
			while((line = br.readLine()) != null ){
				try
				{
					String[] elements = line.split(",");
					if(elements.length != 3)
						throw new Exception("Unexpected number of elements");
					GeoNode geoNode = new GeoNode(Integer.parseInt(elements[0]),elements[1],elements[2]);
					map.put(geoNode.value, geoNode);
					lineNumber++;
				}
				catch(Exception e)
				{
					throw new Exception("At line " + lineNumber + ": " + e.getMessage());
				}
			}
			br.close();
			
		} 
		catch (Exception e)
		{
			throw new Exception("Failed to parse file " + fileName + ": " + e.getMessage());
		}
		return map;
	}


}
