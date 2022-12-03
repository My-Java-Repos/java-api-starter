package com.org.link.helloworld.e2e.base

import groovyx.net.http.RESTClient

class BaseTests {

    String strEnv
    String strBaseURL
    RESTClient testClient
    JwtGetter jwtGetter = new JwtGetter()
    def accessToken = jwtGetter.getAccessToken()

    def BaseTests() {

        strBaseURL = "http://localhost:8080"
        strEnv = "local"
        String propTestEnv = System.getProperty("testEnv")
        if (propTestEnv != null) {
            strEnv = propTestEnv
        }

        if (strEnv in ['dev', 'test', 'demo', 'stage']) {
            strBaseURL = "https:gateway-" + strEnv + ".linkhealth.com/VALUE_TO_CHANGE"
        }
        if (strEnv == "prod") {
            strBaseURL = "https:gateway.linkhealth.com/portal-notification"
        }

        String propBaseURL = System.getProperty("baseUrl")
        if (propBaseURL != null) {
            strBaseURL = propBaseURL
        }

        testClient = new RESTClient(strBaseURL)
        testClient.handler.failure = testClient.handler.success
    }

    def getIncorrectHeader() {
        return ['uuid': 'someString']
    }

    def getAuthorizationHeader() {
        return ['Authorization': "Bearer ${accessToken}"]
    }
}




