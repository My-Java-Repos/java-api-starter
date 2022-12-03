package com.org.link.notification.e2e.testSetup

import groovyx.net.http.HTTPBuilder
import org.springframework.beans.factory.annotation.Value

import static groovyx.net.http.ContentType.URLENC

class JwtGetter {

//    @Value('${e2e.baseIdxUrl')
    String baseIdxUrl ="VALUE_TO_CHANGE"

//    @Value('${e2e.clientId')
    String clientId = "VALUE_TO_CHANGE"

//    @Value('${e2e.clientSecret')
    String clientSecret = "VALUE_TO_CHANGE"

//    @Value('${e2e.path')
    String path = "VALUE_TO_CHANGE"

    def baseUrl = new URL(baseIdxUrl)
    def accessToken

    def getAccessToken() {
        def http = new HTTPBuilder(baseUrl)
        http.post(
                path : path,
                body: [grant_type:'client_credentials', client_id: clientId, client_secret: clientSecret],
                requestContentType: URLENC
        ) {resp, reader -> println "response status: ${resp.statusLine}"
            println 'Response data: -----'
            accessToken = reader['access_token']
        }
        return accessToken
    }

}
