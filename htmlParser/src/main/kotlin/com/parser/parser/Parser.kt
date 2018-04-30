package com.parser.parser

import com.parser.entity.PaymentTransaction

/**
 * Interface that contains methods for processing a document
 */

interface Parser {

    val parse: List<PaymentTransaction>

    /**
     * parse data from document
     * @return list of objects
     */
}
