package org.grails.plugins.restawesome.renderer

import grails.rest.render.AbstractRenderer
import grails.rest.render.ContainerRenderer
import grails.rest.render.RenderContext
import grails.util.GrailsWebUtil
import grails.web.mime.MimeType
import org.grails.plugins.restawesome.converter.ApiJSON
import org.grails.web.json.JSONWriter

/**
 * @author ejaz
 */
class ApiRendererJson<T> extends AbstractRenderer<T> {
    String label

    ApiRendererJson(Class<T> targetClass) {
        super(targetClass, MimeType.JSON)
    }

    @Override
    void render(T object, RenderContext context) {
        context.setContentType(GrailsWebUtil.getContentType(MimeType.JSON.name, GrailsWebUtil.DEFAULT_ENCODING))

        def out = context.writer

        JSONWriter writer = new JSONWriter(out)
        writer.object()
        writer.key(getLabel())

        ApiJSON converter = object as ApiJSON
        converter.renderPartial(writer)

        if (context.arguments?.paging) {
            writer.key("paging")
            converter = context.arguments.paging as ApiJSON
            converter.renderPartial(writer)
        }
        writer.endObject()

        out.flush()
        out.close()
    }

    String getLabel() {
        if (label) {
            label
        }
        else if (this instanceof ContainerRenderer) {
            "entities"
        }
        else {
            "entity"
        }
    }
}
