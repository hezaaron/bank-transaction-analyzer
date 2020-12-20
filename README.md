# bank-transaction-analyzer
![Bank Transaction Build](https://github.com/hezaaron/bank-transaction-analyzer/workflows/Bank%20Transaction%20Build/badge.svg?branch=master)

The ***bank-transaction-analyzer*** **Application** is presently a standalone application that takes as input a csv bank statements file, containing a list of bank transactions, from the command-line, process it and output a summary report via the command-line. It offers support for exporting to an Html format so the report can be viewed on the browser. It creates an HttpServer that listens for connections on port 8080 for that.

## To run the bank-transaction-analyzer project _locally_, _follow_ the instruction below:

```sh
git clone https://github.com/hezaaron/bank-transaction-analyzer.git && cd bank-transaction-analyzer
```

This will install a copy of the project on your system.

## Install dependencies and start the application
## Requires java 8 or above

**_cmd_**

```sh
gradle build
java -cp app/build/classes/java/main banktransaction.App bankstatement.csv
```

Fire up a web browser and point it to `http://localhost:8080` to view the html format of the summary report on your browser.