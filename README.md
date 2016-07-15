# grails-rest-awesome-plugin - Sponsored by SaaSMax
This plugin adds pagination support to the default REST response of grails applications.
I've plan to add search and include/exclude fields in future.

## Installation
```
compile 'org.grails.plugins:rest-awesome:0.2.0'
```

## Using this plugin
This plugin includes a sample application to which can also be referred.

In order to use this plugin, you will have to first register the custom marshaller provided by this plugin.
If you have a domain class such as Book as shown below:

```
class Book {
    String title
    Double price

    static constraints = {
    }
}
```
You have to register two marshallers for this class (one for collection and one for individual item)

To do so, add following lines to your grails/app/conf/spring/resources.groovy file

```
import demo.Book
import org.grails.plugins.restawesome.renderer.ApiCollectionRendererJson
import org.grails.plugins.restawesome.renderer.ApiRendererJson

beans = {
    bookRenderer(ApiRendererJson, Book) {
        label = "book"
    }

    bookCollectionRenderer(ApiCollectionRendererJson, Book) {
        label = "books"
    }
}

```
label is optional. If you provide, it will use the provided label otherwise it has a fallback value which
is "entity" for individual item and "entities" for collection.

After registering marshallers, you will have to extend "AwesomeRestfulController" provided by this plugin.

Our sample BookController should look like this.

```
package demo

import org.grails.plugins.restawesome.AwesomeRestfulController

class BookController extends AwesomeRestfulController {

    static responseFormats = ['json']

    BookController(){
        super(Book)
    }
}
```

## What will you get?
Here is sample output of curl request to this plugin.
```
curl  http://localhost:8080/book
{"books":[
{"class":"demo.Book","id":1,"price":33.2,"title":"Grails in Action"},
{"class":"demo.Book","id":2,"price":20.2,"title":"Groovy in Action"}],
"paging":{"totalCount":2,"currentMax":10,"curentOffset":0}}
```

You can also sort this response with any of the attributes of Book class. To sort with price,
```
curl  http://localhost:8080/book?sort=price
{"books":[
{"class":"demo.Book","id":2,"price":20.2,"title":"Groovy in Action"},
{"class":"demo.Book","id":1,"price":33.2,"title":"Grails in Action"}],
"paging":{"totalCount":2,"currentMax":10,"curentOffset":0}}
```

We can also change the order of sort like "desc" or "asc".

Sorted by price in descending order:
```
curl  "http://localhost:8080/book?sort=price&order=desc"
{"books":[
{"class":"demo.Book","id":1,"price":33.2,"title":"Grails in Action"},
{"class":"demo.Book","id":2,"price":20.2,"title":"Groovy in Action"}],
"paging":{"totalCount":2,"currentMax":10,"curentOffset":0}}
```

Sorted by price in ascending order:
```
curl  "http://localhost:8080/book?sort=price&order=asc"
{"books":[
{"class":"demo.Book","id":2,"price":20.2,"title":"Groovy in Action"},
{"class":"demo.Book","id":1,"price":33.2,"title":"Grails in Action"}],
"paging":{"totalCount":2,"currentMax":10,"curentOffset":0}}
```

# About SaaSMax
[SaaSMAX](https://saasmax.com) is the growth engine for SaaS companies and their resellers. Our mission is all about recurring SaaS commissions.

