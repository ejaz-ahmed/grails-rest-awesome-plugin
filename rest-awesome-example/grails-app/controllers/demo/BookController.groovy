package demo

import org.grails.plugins.restawesome.AwesomeRestfulController

class BookController extends AwesomeRestfulController {

    static responseFormats = ['json']

    BookController(){
        super(Book)
    }
}
