/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.GetUserMethods;
import com.qaprosoft.carina.demo.api.PostUserMethod;
import com.qaprosoft.carina.demo.gabiAPI.GetPhotoMethod;
import com.qaprosoft.carina.demo.gabiAPI.PatchPhotoMethod;
import com.qaprosoft.carina.demo.gabiAPI.PostPhotoMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class APIGabiTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "gabi")
    public void testGetPhotos() {
        GetPhotoMethod getPhotoMethod = new GetPhotoMethod();
        getPhotoMethod.callAPIExpectSuccess();
        getPhotoMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPhotoMethod.validateResponseAgainstSchema("api/photos/_get/rs1.schema");
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void testPostPhotos() {
        PostPhotoMethod postPhotoMethod = new PostPhotoMethod();
        postPhotoMethod.setProperties("api/photos/photos.properties");
        postPhotoMethod.callAPIExpectSuccess();
        postPhotoMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test()
    @MethodOwner(owner = "gabi")
    public void testPatchAPhoto(){
        PostPhotoMethod postPhotoMethod = new PostPhotoMethod();
        postPhotoMethod.setProperties("api/photos/photos.properties");
        postPhotoMethod.callAPI();
        postPhotoMethod.validateResponse();
        PatchPhotoMethod patchPhotoMethod = new PatchPhotoMethod();
        patchPhotoMethod.setProperties("api/photos/photos.properties");
        patchPhotoMethod.callAPI();
        patchPhotoMethod.validateResponse();
    }


}
