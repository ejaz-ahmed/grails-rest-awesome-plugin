import demo.Book
import org.grails.plugins.restawesome.renderer.ApiCollectionRendererJson
import org.grails.plugins.restawesome.renderer.ApiRendererJson

// Place your Spring DSL code here
beans = {
    bookRenderer(ApiRendererJson, Book) {
        label = "book"
    }

    bookCollectionRenderer(ApiCollectionRendererJson, Book) {
        label = "books"
    }
}
