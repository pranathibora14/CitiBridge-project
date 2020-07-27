# Sanctions screening of payments transactions
In most of the online sanctions system, there are a few key words which are banned by the process. It may include names of countries where that transaction is illegal or it might have names of some blacklisted organizations, which are known for the wrong reasons (terrorism etc). The main aim of the project was to create an automatic system for the screening of transations. The application is web based and user can upload a set of transactions (txt file) and the output is given : if sanction was valid or not. 

## Introduction
Many banks currently rely on various un integrated systems for transaction screening. The main aim of this project was to create an integrated platform to automate that process. Here the user enters a file which contains multiple records of transactions. Each transaction has details like txn id, payer name, payee name, payer account, payee account, date etc. The process for sanction has two steps: validation and screening.
Validation means that the contents of each field under every transaction should be valid. This means that the TXN id can't exceed 12 digits, along with things like date format etc. Depending on whether each transaction passes all the validations, the output is shown on the screen. If it is valid, it is sent to screening. 

## Backend
The database used was MySQL, which is open source. The backend runs on a server. Whenever the user inputs a new file( containing many transactions), the data is entered in the database. The validation is done before data is entered in the database. The sanction screening part is done after the data has been entered in the database.

## Validations
The validations are checked using Java language. There are many validations ranging from input data size of account numbers and transaction numbers to checking the format of date entered. If date entered is in wrong format it is converted to DDMMYY. Depending on the status of validation, the output is shown to user (pass/fail). If it passes, it is screend for sanctions. 

## Sanctions screening
Each transaction, from that block of transactions, is picked and screened for sanctions in payer and payee names, location of transaction, amount of transaction and formatting of names. Here when the transaction passes all the sanctions, it is declared screen pass or fail. The user in this case is the clerk who loads the bunch of data on the UI and sees if any transactions raise red flags(screen fails). Another important feature is that, if name of payer/payee has any special characters (ex. Rocky_the_*), the characters are purged. This is to avoid the frauds that happen while transation is screening. The data is displayed per transaction. At a time user can only upload 1 file, which can have any number of transactions. The amount screening applies for transactions having value greater than 1000000. The names of few countries are blacklisted due to their conservative policies. Transactions from such coutries are failed. 

## Technologies used
The front end was done using Angular, JS, Typescript, HTML, CSS. The back end was done using Spring Boot, Java, Maven. The database used was MySQL. Visual Studio code was used to run the front end while the backend part was done in Eclipse. 

## Conclusion
Overall this project gave us an amazing hands on practice of Angular, Typescript and Spring boot. The uploading of text files and storig them in the database was a challenging one and we really enjoyed the project!
