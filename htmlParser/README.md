# HtmlParser: This is Kotlin HTML Parser

**HtmlParser** is a Kotlin parser for working with HTML documents from "BSB Bank". Representation of parsing types: local document (load a Document from a File), url (load a Document from a URL), string (parse a document from a String)

HtmlParser is designed to work with html documents from "BSB Bank".



## How does it work

- Parse html document:

 * val parser = CustomParser("htmlfile.html", CustomParserType.LOCAL_DOCUMENT)
 * val data = parser.parse


## Input

- Load a Document from a File
1. val parser = CustomParser("htmlfile.html", CustomParserType.LOCAL_DOCUMENT)

- Load a Document from a URL
2. val parser = CustomParser("htmlfile.html", CustomParserType.URL)

- Parse a document from a String
3. val parser = CustomParser("htmlfile.html", CustomParserType.STRING)



# Methods:

1. parse - parse data from document

  


## Getting started:
1. Read the documentation
2. Enjoy !
