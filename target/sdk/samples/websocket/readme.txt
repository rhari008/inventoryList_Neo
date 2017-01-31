############################################################
# Welcome to the SAP HANA Cloud Platform Websockets Sample #
############################################################

1. Prerequisites for execution on your local server from within the Eclipse IDE

1.1 Running the local server using Java 7

You need to install JVM 7 and set it up in the Eclipse IDE. You can either set it as default
or assign it to a specific SAP HANA Cloud Platform local runtime. You can find detailed instructions how
to do this in SAP HANA Cloud Platform Documentation on
https://help.hana.ondemand.com/help/frameset.htm?7613eaad711e1014839a8273b0e91070.html

1.2 Using an up-to-date browser which supports Websockets to access the sample application

Such browsers are Internet Explorer 10 and higher, FireFox 24 and higher, Chrome 31 and higher.

The sample UI can be reached under 'http://localhost:8080/websocket/'.

2. Prerequisites for execution of the Selenium Web driver integration tests from Maven and within Eclipse

2.1 Install Firefox browser

The sample integration tests show you how to use Selenium Web driver ("http://seleniumhq.org") to automatically test
the application. They specifically use the Selenium Firefox Web driver which is easiest to set up. 
As a prerequisite, you need to install the browser beforehand from "http://www.mozilla.org".

Note: The required Selenium web driver may not work with the latest Firefox browser. If you notice issues,
you may try to update the Selenium web driver to the latest version in the parent pom.xml property selenium.test.framework.version.n.
