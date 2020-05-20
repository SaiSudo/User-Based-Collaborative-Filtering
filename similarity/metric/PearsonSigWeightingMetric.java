package similarity.metric;

import java.util.Set;

import profile.Profile;

public class PearsonSigWeightingMetric implements SimilarityMetric{

	int threshold;
	public PearsonSigWeightingMetric(int threshold) {
		this.threshold=threshold;
	}
	
	@Override
	public double getSimilarity(Profile p1, Profile p2) {
		PearsonMetric pearsonMetric=new PearsonMetric();
		double w=pearsonMetric.getSimilarity(p1, p2);
		Set<Integer> common = p1.getCommonIds(p2);
		return common.size()<threshold?w*common.size()/threshold:w;
	}
}
