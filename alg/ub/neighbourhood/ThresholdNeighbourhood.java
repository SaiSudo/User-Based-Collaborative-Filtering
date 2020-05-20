package alg.ub.neighbourhood;

import profile.Profile;
import similarity.SimilarityMap;

public class ThresholdNeighbourhood extends Neighbourhood {
	double threshold;

	public ThresholdNeighbourhood(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public void computeNeighbourhoods(SimilarityMap simMap) {
		for (Integer userId : simMap.getIds()) { // iterate over all users

			Profile profile = simMap.getSimilarities(userId); // get the user similarity profile
			if (profile != null) {
				for (Integer id : profile.getIds()) { // iterate over each user in the profile
					double sim = profile.getValue(id);
					if (sim > threshold)
						this.add(userId, id);
				}
			}
		}
	}

}
