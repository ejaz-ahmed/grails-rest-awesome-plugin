package org.grails.plugins.restawesome.converter

import grails.converters.JSON
import org.grails.web.json.JSONWriter

/**
 * Created by ejaz on 3/16/16.
 */
class ApiJSON extends JSON {

    public ApiJSON() {
        super()
    }

    public ApiJSON(Object target) {
        super(target)
    }

    public void renderPartial(JSONWriter out) {
        initWriter(out)
        super.value(target)
    }

    protected initWriter(JSONWriter out) {
        writer = out
        referenceStack = new Stack<Object>();
    }
}
