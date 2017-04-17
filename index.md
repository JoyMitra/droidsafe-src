
# DroidSafe #
## A Platform for Android Application Analysis##

![DroidSafe Logo](http://people.csail.mit.edu/mgordon/logo.png)

## Update (June 13, 2016): Final Version of DroidSafe released

Today, we updated our public repo such that it represents the final version of our project source code.  We have also released our modifications to Soot for our object-sensitive points to analysis as a [separate repo](https://github.com/MIT-PAC/obj-sens-soot).  

This final version of the code does not exactly reproduce the results in our NDSS 2015 paper.  If you need the version of our code that was used for the NDSS 2015 paper, please email the group.  

Note that the DroidSafe project is no longer active, and this code is no longer actively maintained.  However, please email the group if you have any questions as we encourage users.

## DroidSafe Overview

The DroidSafe project develops novel program analysis techniques to diagnose and remove malicious code from Android mobile applications. The DroidSafe project is developed by [MIT's Center for Resilient Software](http://groups.csail.mit.edu/pac/crs/), the [Kestrel Institute](http://www.kestrel.edu/), and [Global InfoTek, Inc](http://www.globalinfotek.com/). The core of our system is a static information-flow analysis that operates on either Java bytecode for an application or an application's APK.  The DroidSafe team co-designed a semantic model of Android runtime behaviors and a static information-flow analysis to achieve acceptable precision, accuracy, and scalability for real-world Android applications.  

The DroidSafe system includes:

1. Comprehensive, accurate, and precise Android runtime semantics model.  The model was seeded with the Java code from the Android Open Source Project's (AOSP) implementation of Android 4.4.1.  The DroidSafe team then automatically and manually added semantics to this model to account for native code semantics and runtime code semantics not included in the AOSP Java code.  The model includes a manually-verified core that accounts for over 98% of API calls in Android applications.  The model provides a single language solution for Android static analysis.

1. A comprehensive set of sensitive source method calls defined on the Android API version 4.4.1.

1. A comprehensive set of sink method calls that can exfiltrate information beyond application boundaries defined on Android API version 4.4.1

1. Scalable and precise global static analysis optimized for the information flow problem on Android.  This includes a deeply object-sensitive global points-to analysis with a custom solver, and a global call-site sensitive, object-sensitive, field-sensitive, and flow-insensitive taint analysis.

1. A plugin for the [Eclipse IDE](https://eclipse.org/) designed to help a trusted human analyst rapidly triage an unknown Android application.  The plugin, called the DroidSafe Navigator, presents our information-flow analysis and points-to analysis results overlaid on the source code for an application.  The DroidSafe Navigator also includes features to guide an analyst to sensitive portions of an application based on API usage and implementation idioms.

Our recent publication below demonstrates that the DroidSafe information-flow analysis system achieves unprecedented precision and accuracy for Android information-flow analysis (as measured on a standard previously published set of benchmark applications). Furthermore, DroidSafe detects all malicious information flow leaks inserted into 24 real-world Android applications by three independent, hostile Red-Team organizations. The previous state-of-the art analysis, in contrast, detects less than 10% of these malicious flows. 

### Publications ###

 * [Information Flow Analysis of Android Applications in DroidSafe](http://people.csail.mit.edu/mgordon/papers/droidsafe-ndss-2015.pdf). Michael I. Gordon, Deokhwan Kim, Jeff Perkins, Limei Gilham, Nguyen Nguyen, and Martin Rinard. NDSS 2015, San Diego, CA, February, 2015.  

### Running DroidSafe ###

We include a detailed introduction to running our analysis and inspecting an application in our Eclipse plugin [here](https://github.com/MIT-PAC/droidsafe-src/wiki/Getting-Started).  We recommend running DroidSafe on a machine with at least 64 GB of memory.

### DroidSafe Analysis Source ###

DroidSafe is built on top of the [Soot Java program analysis framework](http://sable.github.io/soot/).  We have made extensive modifications to Soot, and include those modifications as a jar in our github repository.  We will soon make available the source code for our Soot modifications.  The modifications include a new object-sensitive points-to analysis built on top of Soot's SPARK framework.

DroidSafe also incorporates the [Java String Analyzer](http://www.brics.dk/JSA/) to resolve strings in Android programs.  We have made modifications to JSA for DroidSafe and include a jar file in our repository.

If you would like to inspect or extend the DroidSafe analysis, the root of the source code is [here](https://github.com/MIT-PAC/droidsafe-src/tree/master/src).  We in the process of improving the code documentation.

### DroidSafe Android Semantic Model (Android Device Implementation)

Our source repository includes the Java source code for our semantic model of the Android API and runtime.  The model is appropriate for flow-insensitive analyses of Android applications focused on data-flow and allocation effects in the API / Runtime.  All semantics are represented in Java.  However, there are precision / accuracy increasing that run as part of our analysis. The Java implementation includes annotations on methods and fields that denote sensitive sources and sinks.  The source code is rooted [here](https://github.com/MIT-PAC/droidsafe-src/tree/master/modeling/api) and follows the package structure of the Android API.

### Application Benchmarks

The DroidSafe team contributed 40 micro-applications to the [DroidBench](https://github.com/secure-software-engineering/DroidBench) Android Information Flow benchmark suite.  The malicious Android applications from APAC cannot be release at this time due to our contract with DARPA.

### Authors and Contributors
@mgordon is the DroidSafe project leader at MIT.

### Support or Contact
droidsafe@lists.csail.mit.edu