package com.parser.parser

/**
 * Representation of parsing types: local document (load a Document from a File), url (load a Document from a URL), string (parse a document from a String)
 */

enum class CustomParserType {
    LOCAL_DOCUMENT,
    URL,
    STRING
}
