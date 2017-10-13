package geonomicsV3.clusteranalyzer;

/**
 * 
 * @author 
 *
 */
public class GeoNode extends GraphNode {
	
	public int value;
	public String occupierName;
	public String date;
	
	public GeoNode(int _value, String _name, String _date){
		value = _value;
		occupierName = _name;
		date = _date;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public int compareTo(GraphNode o) {
		GeoNode tempO1 = (GeoNode)this;
		GeoNode tempO2 = (GeoNode)o;
		return ((Integer)tempO1.getValue()).compareTo(((Integer)tempO2.getValue()));
	}
	
	/*@Override
	public int compare(GeoNode o1, GeoNode o2) {
		GeoNode tempO1 = (GeoNode)o1;
		GeoNode tempO2 = (GeoNode)o2;
		return ((Integer)tempO1.getValue()).compareTo(((Integer)tempO2.getValue()));
	}*/
	
}
