package demo

import org.grails.plugins.restawesome.AwesomeRestfulController

class BookController extends AwesomeRestfulController {

    static responseFormats = ['json']

    BookController(){
        super(Book)
    }

//    @Override
//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        def detail = params.detail ?: "complete"
//        respond Book.list(params), [detail:detail, paging:[totalCount: Book.count(),
//                                                            currentMax: params.max,
//                                                            curentOffset: params.offset ?: 0]]
//    }
}
