java_undetectable_meterpreter
=============================

This code shows you how to add a meterpreter to a java application, bypassing AV.

Kaspersky gives a false positive on the binary (HEUR:Exploit.Java.Generic)
I'll work to understand why this is hapenning and to correct it


What this does is simply load directly into memory from a given URL the meterpreter. So AV's will not find it. The false positive have nothing to do with meterpreter...


## HOW TO:


1 - open MeterpreterRemoveLoader.java and replace the string "http://url.com/meterpreter.jar" by the URL to a java meterpreter payload (**put it on the net, not with the application **)

ATTENTION: with this code, I use my fork of meterpreter so that I can send the lhost & lport through arguments. https://github.com/luisfontes19/metasploit-javapayload

If you do not want to use it, be sure to to adapt the code to use the meterpreter conventions to send the lhost & lport (through the properties file)

2 - change the params array with the ip and port of the listenner's machine

3 - Build the jar to distribute it to the victim. (just type "ant" in the terminal in the project directory) or you can copy this code and put it in any application (just be sure to add the needed libraries too)



You can read more on AV Evasion on this really good article:

http://privacy-pc.com/articles/av-evasion-lessons-learned.html