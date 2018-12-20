package de.uni.koblenz.west.coinform.ontology_dev.rdf.mapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.jena.JenaTripleCallback;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.impl.ModelCom;

public class RdfMapper {

	private static JenaTripleCallback callback = new JenaTripleCallback();

	public static Object toRdf(List<Map> jsonLdList) throws JsonLdError, JsonGenerationException, IOException {
		return JsonLdProcessor.toRDF(jsonLdList, callback);
	}

	public static void toRdf(List<Map> jsonLdList, File dest) throws JsonLdError, JsonGenerationException, IOException {
		ModelCom model = (ModelCom) JsonLdProcessor.toRDF(jsonLdList, callback);
		FileOutputStream out = new FileOutputStream(dest);
		try {
			RDFWriter writer = model.getWriter("Turtle");
			writer.write(model, out, null);
			out.flush();
		} finally {
			out.close();
		}

	}

}
