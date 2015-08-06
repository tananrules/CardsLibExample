package com.example.tanan.cardslibexample;

import retrofit.http.GET;

/**
 * Created by tanan on 5/8/15.
 */
public interface FetchPostsService {
    @GET("/api/get_recent_summary")
    PostObject getPosts();
}
