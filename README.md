

[![Latest release](https://img.shields.io/github/release/martinpaljak/jcardengine/all.svg)](https://github.com/martinpaljak/jcardengine/releases/latest)
&nbsp;[![Maven version](https://img.shields.io/maven-metadata/v?label=maven&metadataUrl=https%3A%2F%2Fmvn.javacard.pro%2Fmaven%2FSNAPSHOTS%2Fcom%2Fgithub%2Fmartinpaljak%2Fjcardengine%2Fmaven-metadata.xml)](https://gist.github.com/martinpaljak/c77d11d671260e24eef6c39123345cae)
&nbsp;[![MIT licensed](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/martinpaljak/jcardengine/blob/master/LICENSE)
&nbsp;[![Build status](https://github.com/martinpaljak/jcardengine/actions/workflows/robot.yml/badge.svg?branch=next)](https://github.com/martinpaljak/jcardengine/actions)
&nbsp;[![Made in Estonia](https://img.shields.io/badge/Made_in-Estonia-0072CE?style=flat&label=Made%20in&labelColor=black)](https://estonia.ee)

# JCardEngine - Java Card Runtime Engine for Java.

Run JavaCard applet source code without a physical device.

> [!TIP]
> More information on how to build and use is available in the [Wiki](https://github.com/martinpaljak/jcardengine/wiki).

<sub>This is a fork/rewrite of [@licel/jcardsim](https://github.com/licel/jcardsim) from April 3, 2024 revision `aa60a02f042c18211e4d0f0aef75f27b0e5cf873`.</sub>

<sub>NOTE: Oracle and Java are trademarks of Oracle Corporation.</sub>
jCardSim
========

### Pone Biometrics version of jCardSim includes:

* fixes ByteContainer such that crypto isn't wrong when secret key BigInteger byte representation is less than 32bytes (see https://github.com/licel/jcardsim/issues/209 )
* soft reconnects on VSmartCard socket errors
* uses SecureRandom in KeyPair instead of always predictable SecureRandomNullGenerator
* upgraded javacard sdk to version 3.20 (still using api version 3.0.5)
* stop trying to load `com.licel.globalplatform.*` stuff

jCardSim is an open source simulator for Java Card, v3.0.5:

* `javacard.framework.*`
* `javacard.framework.security.*`
* `javacardx.crypto.*`

Key Features:

* Rapid application prototyping
* Simplifies unit testing (5 lines of code)

```java
// 1. create simulator
CardSimulator simulator = new CardSimulator();

// 2. install applet
AID appletAID = AIDUtil.create("F000000001");
simulator.installApplet(appletAID, HelloWorldApplet.class);

// 3. select applet
simulator.selectApplet(appletAID);

// 4. send APDU
CommandAPDU commandAPDU = new CommandAPDU(0x00, 0x01, 0x00, 0x00);
ResponseAPDU response = simulator.transmitCommand(commandAPDU);

// 5. check response
assertEquals(0x9000, response.getSW());
```

* Emulation of Java Card Terminal, ability to use `javax.smartcardio`
* APDU scripting (scripts are compatible with `apdutool` from Java Card Development Kit)
* Simplifies verification tests creation (Common Criteria)

*JavaDoc*: https://github.com/licel/jcardsim/tree/master/javadoc

  (Javadoc rendered: https://jcardsim.org/jcardsim/)

*Latest release 3.0.5*: https://github.com/licel/jcardsim/packages/1650016


### What is the difference from Oracle Java Card Development Kit simulator?

* **Implementation of javacard.security.***

  One of the main differences is the implementation of `javacard.security.*`: the current version is analogous to an NXP JCOP 31/36k card. For example, in jCardSim we have support for on-card `KeyPair.ALG_EC_F2M/ALG_RSA_CRT` key generation. Oracle's simulator only supports `KeyPair.ALG_RSA` and `KeyPair.ALG_EC_FP`, which are not supported by real cards.

* **Execution of Java Card applications without converting into CAP**

  jCardSim can work with class files without any conversions. This allows us to simplify and accelerate the development and writing of unit tests.

* **Simulator API**

  jCardSim has a simple and usable API, which also allows you to work with the simulator using `javax.smartcardio.*`.

* **Cross-platform**

  jCardSim is completely written in Java and can therefore be used on all platforms which support Java (Windows, Linux, MacOS, etc).

### How to help jCardSim?

* Join the team of jCardSim developers.
* Try out [DexProtector](https://licelus.com/products/dexprotector). The product is designed for strong and robust protection of Android applications against reverse engineering and modification.
* Licel has one more product you may be interested in - [Stringer Java Obfuscator](https://licelus.com/products/stringer). This tool provides all the features you need to comprehensively protect your Java applications.

**License**: [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)

**Third-party libraries**: [Legion of the Bouncy Castle Java](http://www.bouncycastle.org/java.html)

**Trademarks**: Oracle, Java and Java Card are trademarks of Oracle Corporation.
