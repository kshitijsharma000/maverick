package com.desk.httpUtils;

/**
 * Created by kshitij.sharma on 10/1/2015.
 * Whoever wants to get data from server.. must implement his interface..
 * for getting the String data back.
 */
public interface AsyncResponse {
    void processResult(String str);
}
