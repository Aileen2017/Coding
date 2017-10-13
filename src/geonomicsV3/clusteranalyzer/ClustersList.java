package geonomicsV3.clusteranalyzer;

import java.util.ArrayList;

/**
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public abstract class ClustersList<M extends Cluster<?>> extends ArrayList<M> {

	public abstract M addCluster();

}
