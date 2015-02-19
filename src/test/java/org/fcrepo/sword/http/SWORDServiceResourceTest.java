/**
 * Copyright 2015 DuraSpace, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.sword.http;

import org.apache.abdera.model.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * @author claussni
 * @date 18.02.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/sword.xml")
@WebAppConfiguration
public class SWORDServiceResourceTest {

    @Autowired
    private SWORDServiceResource webResource;

    @Test
    public void hasSwordVersion2() {
        final Service service = webResource.serviceDocument();
        final String v = service.getSimpleExtension(
                "http://purl.org/net/sword/terms/",
                "version",
                "sword");
        assertEquals("2.0", v);
    }

}