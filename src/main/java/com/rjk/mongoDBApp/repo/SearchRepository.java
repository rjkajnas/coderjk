package com.rjk.mongoDBApp.repo;

import java.util.List;
import com.rjk.mongoDBApp.model.Post;

public interface SearchRepository {
	List<Post> findByText(String keyword);
}
