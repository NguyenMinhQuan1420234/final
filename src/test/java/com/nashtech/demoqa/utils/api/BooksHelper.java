package com.nashtech.demoqa.utils.api;


import com.nashtech.demoqa.utils.api.contents.APIConstant;
import io.restassured.response.Response;

public class BooksHelper {

    public Response deleteBooks(String userID, String token) {
        String url = String.format(APIConstant.EndpointBookStore.ENDPOINT_BOOKS_STORE, userID);
        RequestHelper requestHelper = new RequestHelper(APIConstant.RequestType.DELETE,url);
        return requestHelper.sendRequest();
    }
}
