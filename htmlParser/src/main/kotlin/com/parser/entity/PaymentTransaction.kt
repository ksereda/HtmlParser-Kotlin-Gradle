package com.parser.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "table_rows")
class PaymentTransaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @Column(name = "bank_name")
    var bankName: String? = null

    @Column(name = "document_date")
    var documentDate: String? = null

    @Column(name = "account_statement")
    var accountStatement: String? = null

    @Column(name = "executor_info")
    var executorInfo: String? = null

    @Column(name = "count_name_and_card_balance")
    var countNameAndCardBalance: String? = null

    @Column(name = "bank_info")
    var bankInfo: String? = null

    @Column(name = "date")
    var date: String? = null

    @Column(name = "number")
    var number: String? = null

    @Column(name = "currency")
    var currency: String? = null

    @Column(name = "bank")
    var bank: String? = null

    @Column(name = "count")
    var count: String? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "incoming_debit_balance")
    var incomingDebitBalance: BigDecimal? = null

    @Column(name = "incoming_credit_balance")
    var incomingCreditBalance: BigDecimal? = null

    @Column(name = "debit")
    var debit: BigDecimal? = null

    @Column(name = "credit")
    var credit: BigDecimal? = null

    @Column(name = "par_info")
    var parInfo: String? = null

    @Column(name = "outgoing_debit_balance")
    var outgoingDebitBalance: BigDecimal? = null

    @Column(name = "outgoing_credit_balance")
    var outgoingCreditBalance: BigDecimal? = null

    @Column(name = "debit_turnover")
    var debitTurnover: BigDecimal? = null

    @Column(name = "credit_turnover")
    var creditTurnover: BigDecimal? = null

}
