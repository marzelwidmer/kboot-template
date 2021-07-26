package contracts.index

import org.springframework.cloud.contract.spec.Contract


// http :8080/ "Cookie: KBoot=5678" --print=HhBb
// http :8080/ "Cookie: KBoot=1234" Host:portal.c3smonkey.ch/coolapp/services/kboot  --print=HhBb
[
		[accountId: "1234",curentUserId: "ID1234"],
 		[accountId: "5678",curentUserId: "ID5678"],
]
.collect { data ->
    Contract.make {
        priority 1
        name "index_${data.accountId}"
        request {
            method "GET"
            urlPath("/")
//            cookies {
//                cookie "KBoot": data.accountId
//            }
        }
        response {
            status OK()
            headers {
                contentType "application/hal+json"
            }
            body(
                    [
                            "_links": [
                                    "self" : [
                                            "href": value(
                                                    stub("http://${fromRequest().header('Host')}${fromRequest().header('Port')}/"),
                                                    test("http://localhost:8080/"))
                                    ],
                                    "documentation"     : [
                                            "href": value(
                                                    stub("http://${fromRequest().header('Host')}${fromRequest().header('Port')}/api-docs/manual.html"),
                                                    test("http://localhost:8080/api-docs/manual.html"))
                                    ],
                                    "foobar"     : [
                                            "href": value(
                                                    stub("http://${fromRequest().header('Host')}${fromRequest().header('Port')}/foobar"),
                                                    test("http://localhost:8080/foobar"))
                                    ]
                            ]
                    ]
            )
        }
    }
}
