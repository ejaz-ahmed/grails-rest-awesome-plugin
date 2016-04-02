package org.grails.plugins.restawesome

import grails.rest.RestfulController

class AwesomeRestfulController<T> extends RestfulController<T> {

    AwesomeRestfulController(Class<T> resource) {
        super(resource)
    }

    @Override
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def detail = params.detail ?: "complete"

        respond listAllResources(params), [detail:detail, paging:[totalCount: resource.count(),
                                                                  currentMax: params.max,
                                                                  curentOffset: params.offset ?: 0]]
    }
}
