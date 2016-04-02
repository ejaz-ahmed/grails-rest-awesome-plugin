package org.grails.plugins.restawesome

import grails.plugins.Plugin

class RestAwesomeGrailsPlugin extends Plugin {
    def grailsVersion = "3.0.11 > *"
    def title = "Rest Awesome"
    def author = "Ejaz Ahmed"
    def authorEmail = "ejaz_ahmed@outlook.com"
    def description = 'Adds pagination, sorting and include/exclude support in Grails applications default REST response'
    def profiles = ['web']
    def documentation = "http://grails.org/plugin/rest-awesome"
    def license = "APACHE"
    def issueManagement = [url: "https://github.com/ejaz-ahmed/grails-rest-awesome-plugin/issues"]
    def scm = [url: "https://github.com/ejaz-ahmed/grails-rest-awesome-plugin"]
}
