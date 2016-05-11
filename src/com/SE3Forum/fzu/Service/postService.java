package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class postService implements IpostService {


    @Override
    public Boolean addService(Post post) {
        return null;
    }

    @Override
    public Boolean deleteService(Serializable id) {
        return null;
    }

    @Override
    public Boolean updateServcie(Post post) {
        return null;
    }

    @Override
    public Post findService(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public List<Post> listAllService(String tableName) {
        return null;
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public Post findPostByName(String name) {
        return null;
    }

    @Override
    public List<Post> findPostWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
