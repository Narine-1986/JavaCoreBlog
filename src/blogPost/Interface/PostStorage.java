package blogPost.Interface;

import blogPost.Post;
import blogPost.exception.PostNotFoundException;

public interface PostStorage {

    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostsByKeyword(String keyword);

    void printAllPosts();

    void printPostsByCategory(String category);

}
