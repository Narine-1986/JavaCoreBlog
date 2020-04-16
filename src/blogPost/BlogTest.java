package blogPost;

import blogPost.Interface.Commands;
import blogPost.exception.PostNotFoundException;

import java.util.Date;
import java.util.Scanner;

public class BlogTest implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static PostStorageImpl psImp = new PostStorageImpl();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
                System.out.println("Input number please");
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case SEARCH_POST:
                    search();
                    break;
                case POSTS_BY_CATEGORY:
                    printByCategory();
                    break;
                case POST_BY_TITLE:
                    getPostByTitle();
                case ALL_POSTS:
                    psImp.printAllPosts();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void printByCategory() {
        System.out.println("input the category");
        String category = scanner.nextLine();
        psImp.printPostsByCategory(category);

    }

    private static void addPost() {
        System.out.println("Please input Post data: title, text, category, createdDate");
        Post post = new Post();
        Date date = new Date();
        try {
            String PostDataStr = scanner.nextLine();
            String[] PostData = PostDataStr.split(",");
            post.setTitle(PostData[0]);
            post.setText(PostData[1]);
            post.setCategory(PostData[2]);
            post.setCreatedDate(date);
            psImp.add(post);
            System.out.println("Post was added!");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid data");
            addPost();
        }
    }

    private static void search() {
        System.out.println("input the search word for the post");
        String keyword = scanner.nextLine();
        psImp.searchPostsByKeyword(keyword);

    }

    private static void getPostByTitle() {
        System.out.println("input the title for the post");
        try {
            String title = scanner.nextLine();
            psImp.getPostByTitle(title);
        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());

        }

    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_POST + " forADD_POST");
        System.out.println("Please input " + SEARCH_POST + " for SEARCH_POST");
        System.out.println("Please input " + POSTS_BY_CATEGORY + " POSTS_BY_CATEGORY");
        System.out.println("Please input " + POST_BY_TITLE + " POSTS_BY_TITLE");
        System.out.println("Please input " + ALL_POSTS + " ALL_POSTS");

    }

}




