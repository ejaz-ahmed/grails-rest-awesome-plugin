import demo.Book

class BootStrap {

    def init = { servletContext ->

        new Book(title: "Grails in Action", price: 33.2).save(failOnError: true)
        new Book(title: "Groovy in Action", price: 20.2).save(failOnError: true)

    }
    def destroy = {
    }
}
