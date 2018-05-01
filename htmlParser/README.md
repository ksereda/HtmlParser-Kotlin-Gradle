# CustomParser: This is Java HTML Parser

**CustomParser** is a Java library for working with HTML documents from "BSB Bank". Representation of parsing types: local document (load a Document from a File), url (load a Document from a URL), string (parse a document from a String)

htmlParse is designed to work with html documents from "BSB Bank".



## How does it work
- You must import the library (CustomParser)

 import com.parser.parser.CustomParser;

- Parse html document:

 CustomParser parser = new CustomParser("file.html", CustomParserType.LOCAL_DOCUMENT);
   parser.parse();



## Input

- Load a Document from a File
1. CustomParser parser = new CustomParser("file.html", CustomParserType.LOCAL_DOCUMENT);

- Load a Document from a URL
2. CustomParserImpl parser = new CustomParserImpl("file.html", CustomParserType.URL);

- Parse a document from a String
3. CustomParserImpl parser = new CustomParserImpl("file.html", CustomParserType.STRING);



# Methods:

1. parse - parse data from document

2. getDataFromTableBody() - parse data from document's body table

3. getDataFromTableHeader() - parse data from document's header table

4. getTotalDebitAmount() - the amount of all debits from the document

5. getTotalCreditAmount() - the amount of all credits from the document

6. getAccountTurnover() - balance - the difference between the debit and the credit of the document

   


## Getting started:
1. You can download CustomParserLibrary jar (or it add to your Maven/Gradle build)
2. Read the documentation
3. Enjoy!
