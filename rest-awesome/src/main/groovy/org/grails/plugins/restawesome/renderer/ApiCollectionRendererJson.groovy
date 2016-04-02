package org.grails.plugins.restawesome.renderer

import grails.rest.render.ContainerRenderer
import grails.web.mime.MimeType

/**
 * @author ejaz
 */
class ApiCollectionRendererJson extends ApiRendererJson implements ContainerRenderer {
    final Class componentType

    ApiCollectionRendererJson(Class componentType) {
        super(Collection)
        this.componentType = componentType
    }

    ApiCollectionRendererJson(Class componentType, MimeType mimeTypes) {
        super(Collection, mimeTypes)
        this.componentType = componentType
    }
}
