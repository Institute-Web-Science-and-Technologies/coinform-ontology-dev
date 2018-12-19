package de.uni.koblenz.west.coinform.ontology_dev;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hp.hpl.jena.util.FileUtils;

import de.uni.koblenz.west.coinform.ontology_dev.utils.JsonLdParser;

public class JsonLdParserTest {

	final public String CLAIM_REVIEWS = "claimReviewTest.json";
	private String claimReviews;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		claimReviews = FileUtils.readWholeFileAsUTF8(classLoader.getResource(CLAIM_REVIEWS).getFile());
	}

	@Test
	public void parse() {
		List<Map> jsonList = JsonLdParser.parse(claimReviews);
		Assert.assertFalse(jsonList.isEmpty());
		Assert.assertTrue(jsonList.size() == 2);
	}

}
