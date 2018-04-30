package com.parser.dao

import com.parser.parser.CustomParser
import com.parser.parser.CustomParserType
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder

class Connection {

    @Throws(Exception::class)
    fun setUp() {
        val parser = CustomParser("htmlfile.html", CustomParserType.LOCAL_DOCUMENT)
        val data = parser.parse

        val sessionFactory: SessionFactory

        val registry = StandardServiceRegistryBuilder()
                .configure()
                .build()
        try {
            sessionFactory = MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory()
        } catch (e: Exception) {
            StandardServiceRegistryBuilder.destroy(registry)
            throw e
        }

        val session = sessionFactory.openSession()
        session.beginTransaction()
        for (dataObjects in data) {
            session.save(dataObjects)
        }
        session.transaction.commit()
        session.close()
    }

}