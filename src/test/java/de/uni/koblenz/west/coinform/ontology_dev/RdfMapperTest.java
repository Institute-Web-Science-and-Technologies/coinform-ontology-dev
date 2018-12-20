package de.uni.koblenz.west.coinform.ontology_dev;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.jsonldjava.core.JsonLdError;
import com.hp.hpl.jena.util.FileUtils;

import de.uni.koblenz.west.coinform.ontology_dev.rdf.mapper.RdfMapper;
import de.uni.koblenz.west.coinform.ontology_dev.utils.JsonLdParser;
import junit.framework.TestCase;

public class RdfMapperTest extends TestCase {

	final public String CLAIM_REVIEWS = "claimReviewTest.json";
	final public String CLAIM_REVIEWS_TTL = "claimReview.ttl";
	private List<Map> claimReviewList;
	private File dest;

	@Override
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		dest = new File(CLAIM_REVIEWS_TTL);
		String claimReviews = FileUtils.readWholeFileAsUTF8(classLoader.getResource(CLAIM_REVIEWS).getFile());
		claimReviewList = JsonLdParser.parse(claimReviews);

	}

	@Test
	public void testToRdf() throws JsonLdError, JsonGenerationException, IOException {
		RdfMapper.toRdf(claimReviewList, dest);
		Assert.assertTrue(dest.exists());
		dest.delete();

	}

}
