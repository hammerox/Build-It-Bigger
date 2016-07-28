package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.view.View;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    Context mContext;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext = getContext();
    }

    @Test
    public void testJokes() {
        EndpointsAsyncTask task = new EndpointsAsyncTask(mContext);
        assertNotNull(task.execute());
    }
}