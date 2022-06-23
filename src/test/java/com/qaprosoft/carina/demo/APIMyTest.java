package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.mymethods.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * This sample shows how create REST API tests.
 * @author oleg-by
 */

public class APIMyTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //+++ 1
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreatePost() {
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.setProperties("api/posts/post.properties");
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse();
    }

    //+++ 2
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testGetPosts() {
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    //+++ 3
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testDeletePosts() {
        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.setProperties("api/posts/post.properties");
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
    }

    //+++ 4
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testPutPosts() {
        PutPostMethod putPostMethod = new PutPostMethod();
        putPostMethod.setProperties("api/posts/post.properties");
        putPostMethod.callAPIExpectSuccess();
        putPostMethod.validateResponse();
    }

    //+++ 5
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreatePostMissingSomeFields() {
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.setProperties("api/posts/post.properties");
        postPostMethod.getProperties().remove("userId");
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse();
    }

    //+++ 6
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testDeleteTodos() {
        DeleteTodoMethod deleteTodoMethod = new DeleteTodoMethod();
        deleteTodoMethod.setProperties("api/todos/todo.properties");
        deleteTodoMethod.callAPIExpectSuccess();
        deleteTodoMethod.validateResponse();
    }

    //+++ 7
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testGetTodos() {
        GetTodoMethod getTodoMethod = new GetTodoMethod();
        getTodoMethod.callAPIExpectSuccess();
        getTodoMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getTodoMethod.validateResponseAgainstSchema("api/todos/_get/rs.schema");
    }

    //+++ 8
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreateTodo() {
        PostTodoMethod postTodoMethod = new PostTodoMethod();
        postTodoMethod.setProperties("api/todos/todo.properties");
        postTodoMethod.callAPIExpectSuccess();
        postTodoMethod.validateResponse();
    }

    //+++ 9
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testPutTodos() {
        PutTodoMethod putTodoMethod = new PutTodoMethod();
        putTodoMethod.setProperties("api/todos/todo.properties");
        putTodoMethod.callAPIExpectSuccess();
        putTodoMethod.validateResponse();
    }

    //+++ 10
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreateTodoMissingSomeFields() {
        PostTodoMethod postTodoMethod = new PostTodoMethod();
        postTodoMethod.setProperties("api/todos/todo.properties");
        postTodoMethod.getProperties().remove("userId");
        postTodoMethod.callAPIExpectSuccess();
        postTodoMethod.validateResponse();
    }

    //+++ 11
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testPutUser() {
        PutUserMethod putUserMethod = new PutUserMethod();
        putUserMethod.setProperties("api/users/user.properties");
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse();
    }

}
