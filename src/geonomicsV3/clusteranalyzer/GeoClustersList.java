package geonomicsV3.clusteranalyzer;

/**
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public final class GeoClustersList extends ClustersList<GeoCluster> {
	
	
	@Override
	public final GeoCluster addCluster(){
		GeoCluster geoCluster = new GeoCluster();
		this.add(geoCluster);
		return geoCluster;
	};

}
