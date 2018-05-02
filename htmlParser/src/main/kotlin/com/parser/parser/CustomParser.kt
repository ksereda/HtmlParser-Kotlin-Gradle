package com.parser.parser

import com.parser.entity.PaymentTransaction
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.io.IOException
import java.math.BigDecimal
import java.util.ArrayList

/**
 * Сlass implements the methods presented in the interface Parser
 */

class CustomParser(var source: String?, var type: CustomParserType?) : Parser {

    @Throws(IOException::class)
    private fun getDocument(source: String?, type: CustomParserType): Document {
        var document = Document("")
        when (type) {
            CustomParserType.URL -> {
                document = Jsoup.connect(source).get()
                return document
            }
            CustomParserType.LOCAL_DOCUMENT -> {
                document = Jsoup.parse(File(source!!), "UTF-8")
                return document
            }
            CustomParserType.STRING -> {
                document = Jsoup.parse(source!!)
                return document
            }
        }
        return document
    }

    override val parse: List<PaymentTransaction>
        @Throws(IOException::class)
        get() {
            val doc = getDocument(this.source, this.type!!)

            val listTable = ArrayList<PaymentTransaction>()
            val SELECTOR_TABLE_HEADER = "body > div > table:nth-child(2)"
            val elementsHeader = doc.select(SELECTOR_TABLE_HEADER)
            for (header in elementsHeader) {
                val rowsHeader = header.getElementsByTag("tr")
                for (i in rowsHeader.indices) {
                    val rowHeader = rowsHeader[i]
                    val tdsHeader = rowHeader.getElementsByTag("td")
                    val tableHeader = PaymentTransaction()
                    if (tdsHeader.size == 2 && i == 0) {
                        tableHeader.bankName = tdsHeader[0].text()
                        tableHeader.documentDate = tdsHeader[1].text()
                        listTable.add(tableHeader)
                    } else if (tdsHeader.size == 2 && i == 1) {
                        tableHeader.accountStatement = tdsHeader[0].text()
                        listTable.add(tableHeader)
                    } else if (tdsHeader.size == 4 && i == 2) {
                        tableHeader.executorInfo = tdsHeader[0].text()
                        listTable.add(tableHeader)
                    } else {
                        tableHeader.countNameAndCardBalance = tdsHeader[0].text()
                        tableHeader.bankInfo = tdsHeader[1].text()
                        listTable.add(tableHeader)
                    }
                }
            }

            val SELECTOR_TABLE_BODY = "body > div > table:nth-child(4)"
            val elementsBody = doc.select(SELECTOR_TABLE_BODY)
            for (table in elementsBody) {
                val rows = table.getElementsByTag("tr")
                for (i in rows.indices) {
                    if (i > 1) {
                        val row = rows[i]
                        val tds = row.getElementsByTag("td")
                        if (tds.size > 2) {
                            val tableBody = PaymentTransaction()
                            if (tds.size == 3 && i == 2) {
                                tableBody.title = tds[0].text()
                                tableBody.incomingDebitBalance = BigDecimal(tds[1].text().replace(" ".toRegex(), ""))
                                tableBody.incomingCreditBalance = BigDecimal(tds[2].text().replace(" ".toRegex(), ""))
                                listTable.add(tableBody)
                            } else if (tds.size == 3 && i == rows.size - 2) {
                                tableBody.title = tds[0].text()
                                tableBody.debitTurnover = BigDecimal(tds[1].text().replace(" ".toRegex(), ""))
                                tableBody.creditTurnover = BigDecimal(tds[2].text().replace(" ".toRegex(), ""))
                                listTable.add(tableBody)
                            } else if (tds.size == 3 && i == rows.size - 1) {
                                tableBody.title = tds[0].text()
                                tableBody.outgoingDebitBalance = BigDecimal(tds[1].text().replace(" ".toRegex(), ""))
                                tableBody.outgoingCreditBalance = BigDecimal(tds[2].text().replace(" ".toRegex(), ""))
                                listTable.add(tableBody)
                            } else {
                                tableBody.date = tds[0].text()
                                tableBody.number = tds[1].text()
                                tableBody.currency = tds[2].text()
                                tableBody.bank = tds[3].text()
                                tableBody.count = tds[4].text()
                                tableBody.parInfo = tds[5].text().split(" ".toRegex(), 3).toTypedArray()[2]
                                tableBody.debit = BigDecimal(tds[6].text().replace(" ".toRegex(), ""))
                                tableBody.credit = BigDecimal(tds[7].text().replace(" ".toRegex(), ""))
                                listTable.add(tableBody)
                            }
                        }
                    }
                }
            }
            return listTable
        }



}
