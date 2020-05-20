package similarity.metric;

import java.util.Set;

import profile.Profile;

public class MeanSquaredDifferenceMetric implements SimilarityMetric {

	double minRating, maxRating;

	/**
	 * constructor - creates a new CosineMetric object
	 */
	public MeanSquaredDifferenceMetric() {
	}

	public MeanSquaredDifferenceMetric(double minRating, double maxRating) {
		this.minRating = minRating;
		this.maxRating = maxRating;
	}

	/**
	 * computes the similarity between profiles
	 * 
	 * @param profile 1
	 * @param profile 2
	 */
	@Override
	public double getSimilarity(Profile p1, Profile p2) {
		double sumOfSquares = 0;
		int countCommon = 0;
		Set<Integer> common = p1.getCommonIds(p2);

		if (common.size()==0) return 0;
		
		for (Integer id : common) {
			double r1 = p1.getValue(id).doubleValue();
			double r2 = p2.getValue(id).doubleValue();
			sumOfSquares += Math.pow(r1 - r2, 2);
			countCommon++;
		}
		double msd = sumOfSquares / countCommon;
		return maxRating - minRating == 0 ? null : 1 - (msd / Math.pow(maxRating - minRating, 2));
	}

}
