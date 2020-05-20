package alg.ub.predictor;

import java.util.Map;

import alg.ub.neighbourhood.Neighbourhood;
import profile.Profile;
import similarity.SimilarityMap;

public class SimpleNonPersonalisedPredictor implements Predictor{

	@Override
	public Double getPrediction(Integer userId, Integer itemId, Map<Integer, Profile> userProfileMap,
			Map<Integer, Profile> itemProfileMap, Neighbourhood neighbourhood, SimilarityMap simMap) {
		return itemProfileMap.get(itemId).getMeanValue();
	}

}
