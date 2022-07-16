package contracts.index

import org.springframework.cloud.contract.spec.Contract

def PORT_PATTERN = ~"([0-9]+)"
def SERVER_BASE_PATH = "http://localhost:$PORT_PATTERN"

Contract.make {
    priority 1
    description "Index Root Controller API entry point."
    name "index_root_controller"
    request {
        method "GET"
        urlPath("/")
    }
    response {
        status OK()
        headers {
            contentType "application/hal+json"
        }
        body(
                [
                        "_links": [
                                "self"         : [
                                        "href": value(
                                                stub("http://${fromRequest().header('Host')}${fromRequest().header('Port')}/"),
                                                test("$SERVER_BASE_PATH/")

                                        )
                                ],
                                "documentation": [
                                        "href": value(
                                                stub("http://${fromRequest().header('Host')}${fromRequest().header('Port')}/api-docs/manual.html"),
                                                test("$SERVER_BASE_PATH/api-docs/${regex('manual.html')}")
                                        )
                                ]
                        ]
                ]
        )
    }
}
