package com.esprit.webs;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class Controller {
	
	@Autowired
	private QuerryMethods querryMethods;
	

	@RequestMapping(value = "/meth1",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String meth1() {
		
		String querystring = "PREFIX rdf: <http://www.w3.org/2002/07/owl#>"+
							"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
							" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "+
							"PREFIX : <http://projet.org/pmbok.owl#> "+
				"SELECT   ?y\n" + 
				"WHERE {\r\n" + 
				" :basis_of_estimate a ?y.\r\n" + 
				"}";
		
		return this.querryMethods.selectQuerry(querystring);
	}

	@RequestMapping(value = "/meth2",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String meth2() {
		
		String querystring = "PREFIX rdf: <http://www.w3.org/2002/07/owl#>"+
							"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
							" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "+
							"PREFIX : <http://projet.org/pmbok.owl#> "+
				"SELECT   distinct ?x\n" + 
				"WHERE {\r\n" + 
				" ?x :has_input :enterprise_environmental_factor.\r\n" + 
				"}";
		
		return this.querryMethods.selectQuerry(querystring);
	}
	
	@RequestMapping(value = "/meth3",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String meth3() {
		
		String querystring = "PREFIX rdf: <http://www.w3.org/2002/07/owl#>"+
							"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
							" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "+
							"PREFIX : <http://projet.org/pmbok.owl#> "+
				"SELECT   distinct ?p  ?y\r\n" + 
				"WHERE {\r\n" + 
				" :cost_estimate ?p ?y.\r\n" + 
				" ?p rdf:type owl:ObjectProperty.\r\n" + 
				"}";
		
		return this.querryMethods.selectQuerry(querystring);
	}
	
	@RequestMapping(value = "/meth4",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String meth4() {
		
		String querystring = "PREFIX rdf: <http://www.w3.org/2002/07/owl#>"+
							"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
							" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "+
							"PREFIX : <http://projet.org/pmbok.owl#> "+
				"SELECT ?input  ?output ?tool\r\n" + 
				"WHERE {\r\n" + 
				" :define_scope :has_input ?input.\r\n" + 
				" :define_scope :has_output ?output.\r\n" + 
				" :define_scope :has_tool ?tool.\r\n" + 
				"}";
		
		return this.querryMethods.selectQuerry(querystring);
	}
	
	
	      

	
	

	
	
}
