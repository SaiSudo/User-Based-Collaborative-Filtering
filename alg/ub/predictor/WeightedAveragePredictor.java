package alg.ub.predictor;

import java.util.Map;
import java.util.Set;

import alg.ub.neighbourhood.Neighbourhood;
import profile.Profile;
import similarity.SimilarityMap;

public class WeightedAveragePredictor implements Predictor {

	@Override
	public Double getPrediction(Integer userId, Integer itemId, Map<Integer, Profile> userProfileMap,
			Map<Integer, Profile> itemProfileMap, Neighbourhood neighbourhood, SimilarityMap simMap) {
		double above = 0, below=0;
		// get the neighbours for the user
		Set<Integer> neighbours = neighbourhood.getNeighbours(userId);

		// return null if the user has no neighbours
		if (neighbours == null)
			return null;
		
		for(Integer neighbour: neighbours) // iterate over each neighbour
		{
			Double rating = userProfileMap.get(neighbour).getValue(itemId); // get the neighbour's rating for the target item
			int neighbourId=userProfileMap.get(neighbour).getId();
			Double similarity = simMap.getSimilarity(userId, neighbourId);
			if(rating != null && similarity !=null) {
				above += similarity.doubleValue() * rating.doubleValue();
				below+= similarity.doubleValue();
			}
		}

		return below<=0?null:above/below;
	}

}
