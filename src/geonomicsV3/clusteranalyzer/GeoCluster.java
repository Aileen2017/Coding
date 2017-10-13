package geonomicsV3.clusteranalyzer;

/**
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public final class GeoCluster extends Cluster<GeoNode> {
	
	
	@Override
	public int compareTo(Cluster<GeoNode> o) {
		GeoCluster geoO1 = (GeoCluster)this;
		GeoCluster geoO2 = (GeoCluster)o;
		int i = ((Integer)geoO2.size()).compareTo(((Integer)geoO1.size()));
		if(i !=0){
			return i;
		}
		else{
			return ((Integer)geoO2.getTotalValue()).compareTo(((Integer)geoO1.getTotalValue()));
		}
	}
	
	public final int getTotalValue(){
		int totalValue =0;
		for(GeoNode gnode : this){
			totalValue += (Integer)gnode.getValue();
		}
		return totalValue;
	}
	
	@Override
	public boolean add(final GeoNode e) {
		super.add(e);
		return true;
	}
	

}
