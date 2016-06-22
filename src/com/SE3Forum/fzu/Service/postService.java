package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Dao.PostDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class postService implements IpostService {
    private  PostDao postDao;
    public postService(){postDao=new PostDao();}
    @Override
    public Boolean addService(Post post) {
        try {
             postDao.add(post);
            return  true;
        }catch (Exception e){
            return  false;
        }

    }



    @Override
    public Boolean deleteService(Serializable id) {

        Post post= (Post) postDao.find(Post.class,id);
       if (post==null) return  false;
        else {
           try {
               postDao.delete(post);
               return  true;
           }catch (Exception e){
               return  false;
           }

        }
    }

    @Override
    public Boolean updateServcie(Post post) {
        try {
            Post p= (Post) postDao.find(Post.class,post.getId());
            p.setContent(post.getContent());
            p.setTag(post.getTag());
            p.setTopic(post.getTopic());
            p.setUser(post.getUser());
            postDao.update(p);
            return true;
        }catch (Exception e){
            return  false;
        }

    }

    @Override
    public Post findService( Serializable id) {
        return (Post) postDao.find(Post.class,id);
    }

    @Override
    public List<Post> listAllService(String tableName) {
        return postDao.listAll(tableName);
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
    public List<Post> findPostWithOption(String Option, SearchOption searchOption)
    {
        return null;
    }



}
