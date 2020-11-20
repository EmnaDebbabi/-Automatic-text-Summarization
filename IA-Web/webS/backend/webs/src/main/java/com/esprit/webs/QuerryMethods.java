package com.esprit.webs;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;

@Service
public class QuerryMethods {
	
	public String selectQuerry(String querystring) {
		String NS = "";
		   // lire le model a partir d'une ontologie
//				Model model = JenaEngine.readModel("data/ontologiesProjet.owl");
				Model model = JenaEngine.readModel("data/ontology.owl");
				 List<JSONObject> list=new ArrayList();
				if (model != null) {
		  
					NS = model.getNsPrefixURI("");
					//System.out.println(NS);
					Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
					
					//System.out.println(querystring);
					Query query = QueryFactory.create(querystring);
					QueryExecution qexec =QueryExecutionFactory.create(query, inferedModel);
					try {
						ResultSet results =qexec.execSelect();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						ResultSetFormatter.outputAsJSON(outputStream,results);
						String json = new String(outputStream.toByteArray());
						return json;
					}
					finally {
						qexec.close();
					} 
				} else {
					System.out.println("Error when reading model from ontology");
				}
				return null;
	}

}
