//package com.graphql.userPoc.controller;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.graphql.userPoc.queryService.AuthQuery;
//import com.graphql.userPoc.queryService.UserQuery;
//
//import graphql.ExecutionResult;
//import graphql.GraphQL;
//import graphql.GraphQLException;
//import graphql.schema.GraphQLSchema;
//import graphql.schema.idl.SchemaPrinter;
//import io.leangen.graphql.GraphQLSchemaGenerator;
//import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
//import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
//import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
//
//@RestController
//public class UserController {
//
//	private final GraphQL graphQL;
//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//	@Autowired
//	public UserController(UserQuery userQuery, AuthQuery authQuery) {
//		// Schema generated from query classes
//		GraphQLSchema schema = new GraphQLSchemaGenerator().withResolverBuilders(
//				// Resolve by annotations
//				new AnnotatedResolverBuilder(),
//				// Resolve public methods inside root package
//				new PublicResolverBuilder("com.graphql.userPoc"))
//				.withOperationsFromSingleton(userQuery, UserQuery.class).withOperationsFromSingleton(authQuery)
//				.withValueMapperFactory(new JacksonValueMapperFactory()).generate();
//		graphQL = GraphQL.newGraphQL(schema).build();
//		System.out.println(new SchemaPrinter().print(schema));
//	}
//
//	@PostMapping(value = "/graphql")
//	public Object execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
//			throws GraphQLException {
//		logger.info("Query execution started..." + request.get("query")); 
//		ExecutionResult result = graphQL.execute(request.get("query"), raw);
//		if (result.getErrors().isEmpty()) {
//			logger.info("Query executed..." + result.getData());
//			return result.getData();
//		}
//		else {
//			logger.info("exception occured...");
//			return result.getErrors();
//		}
//	}
//
//}
