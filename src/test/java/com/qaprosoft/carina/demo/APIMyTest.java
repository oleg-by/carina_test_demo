package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.mymethods.DeletePostMethod;
import com.qaprosoft.carina.demo.api.mymethods.GetPostMethod;
import com.qaprosoft.carina.demo.api.mymethods.PostPostMethod;
import com.qaprosoft.carina.demo.api.mymethods.PutPostMethod;
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

    //+++
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testCreatePost() {
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.setProperties("api/posts/post.properties");
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse();
    }

    //+++
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testGetPosts() {
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    //+++
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testDeletePosts() {
        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.setProperties("api/posts/post.properties");
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
    }

    //+++
    @Test()
    @MethodOwner(owner = "oleg-by")
    public void testPutPosts() {
        PutPostMethod putPostMethod = new PutPostMethod();
        putPostMethod.setProperties("api/posts/post.properties");
        putPostMethod.callAPIExpectSuccess();
        putPostMethod.validateResponse();
    }
}
