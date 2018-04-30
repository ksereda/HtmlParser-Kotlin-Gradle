package com.parser.parser

import com.parser.dao.Connection

object HtmlParser {
    @JvmStatic
    fun main(args: Array<String>) {

        val connection = Connection()
        try {
            connection.setUp()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}