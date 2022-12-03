package com.org.link.helloworld.e2e;

import com.org.link.helloworld.web.controller.e2e.base.BaseTests;
import groovyx.net.http.RESTClient
import org.apache.http.HttpStatus;
import spock.lang.Specification;

public class MockE2eTest extends Specification {

    RESTClient testClient
    BaseTests baseTests
    String reqPath

    def setup() {
        baseTests = new BaseTests()
        testClient = baseTests.getTestClient()
        reqPath = "/api/hello"
    }

    void "hello should return valid response when valid uuid is passed in the header"() {
        when:
        def resp = testClient.get(headers: baseTests.getIncorrectHeader(), path: reqPath)

        then:
        if (resp.getStatus() != HttpStatus.SC_OK) {
            println("baseUrl=" + baseTests.getStrBaseURL())
            println("reqPath=" + reqPath)
            println("headers=" + baseTests.baseTests.getIncorrectHeader())
            println("query=" + baseTests.getDefaultQueryString())
            println("resp.getStatus()=" + resp.getStatus())
            if (resp.data != null && (resp.data instanceof net.sf.json.JSONObject)) {
                println("resp.data=" + resp.data)
            }
        }
        resp.getStatus() == HttpStatus.SC_UNAUTHORIZED
        resp.data != null

    }
}
