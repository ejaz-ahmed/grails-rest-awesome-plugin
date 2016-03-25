package org.grails.plugins.restawesome.renderer

import grails.rest.render.ContainerRenderer
import grails.web.mime.MimeType

/**
 * Created by ejaz on 3/16/16.
 */
class ApiCollectionRendererJson extends ApiRendererJson implements ContainerRenderer {
    final Class componentType

    public ApiCollectionRendererJson(Class componentType) {
        super(Collection)
        this.componentType = componentType
    }

    public ApiCollectionRendererJson(Class componentType, MimeType mimeTypes) {
        super(Collection, mimeTypes)
        this.componentType = componentType
    }
}
