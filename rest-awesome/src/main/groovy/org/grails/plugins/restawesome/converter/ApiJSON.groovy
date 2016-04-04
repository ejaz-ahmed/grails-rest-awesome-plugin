package org.grails.plugins.restawesome.converter

import grails.converters.JSON
import org.grails.web.json.JSONWriter

/**
 * @author ejaz
 */
class ApiJSON extends JSON {

    ApiJSON() {}

    ApiJSON(target) {
        super(target)
    }

    void renderPartial(JSONWriter out) {
        initWriter(out)
        super.value(target)
    }

    protected initWriter(JSONWriter out) {
        writer = out
        referenceStack = new Stack<Object>()
    }
}
