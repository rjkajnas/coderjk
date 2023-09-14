package com.rjk.mongoDBApp.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rjk.mongoDBApp.model.Post;

@Repository
public class SearchRepositoryImpl implements SearchRepository {
	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<Post> findByText(String keyword) {
		final List<Post> posts = new ArrayList<>();

		MongoDatabase database = mongoClient.getDatabase("rjk");
		MongoCollection<Document> collection = database.getCollection("jobPost");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("text",
								new Document("query", keyword).append("path",
										Arrays.asList("techStack", "desc", "profile")))),
				new Document("$sort", new Document("experience", 1L)), new Document("$limit", 5L)));

		result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

		return posts;

	}
}
