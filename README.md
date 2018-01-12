# Compile

`mvn package` 

# Run

`mvn exec:java -Dexec.mainClass="debug.aspose.App"  -Dexec.args="/tmp/Aspose.Words.lic"`

The user will be prompted for the (absolute) path of the word file to be used.

Example with aspose 17.7 and the move track changes produced with office 2016 on windows 10 :

```
mvn exec:java -Dexec.mainClass="debug.aspose.App"  -Dexec.args="/tmp/Aspose.Words.lic"
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building aspose 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ aspose ---
License set successfully.
Enter word file path: /home/msegura/tmp/move3.docx
Word track change ------------------------------------------
revision type=INSERTION revision.getAuthor()=msegura revision.getDateTime()=Thu Jan 11 04:03:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision has an associated run  run.getText()=beginning run.isInsertRevision()=true run.isDeleteRevision=false run.isFormatRevision=false
revision type=INSERTION revision.getAuthor()=msegura revision.getDateTime()=Thu Jan 11 04:03:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision has an associated run  run.getText()=beginning run.isInsertRevision()=true run.isDeleteRevision=false run.isFormatRevision=false
revision type=MOVING revision.getAuthor()=Bobby revision.getDateTime()=Thu Jan 11 05:48:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision type=INSERTION revision.getAuthor()=msegura revision.getDateTime()=Thu Jan 11 04:03:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision has an associated run  run.getText()=end run.isInsertRevision()=true run.isDeleteRevision=false run.isFormatRevision=false
revision type=INSERTION revision.getAuthor()=msegura revision.getDateTime()=Thu Jan 11 04:03:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision has an associated run  run.getText()=  run.isInsertRevision()=true run.isDeleteRevision=false run.isFormatRevision=false
revision type=INSERTION revision.getAuthor()=Bobby revision.getDateTime()=Thu Jan 11 05:48:00 CET 2018
------------------------------------------
Word track change ------------------------------------------
revision has an associated run  run.getText()=beginning run.isInsertRevision()=false run.isDeleteRevision=false run.isFormatRevision=false
revision type=MOVING revision.getAuthor()=Bobby revision.getDateTime()=Thu Jan 11 05:48:00 CET 2018
------------------------------------------
------- aspose view of the content as a text file ------------------
Hello
end beginning


-------------------------
------- aspose view of the content as a html file ------------------
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta name="generator" content="Aspose.Words for Java 17.7" />
		<title>
		</title>
	</head>
	<body>
		<div>
			<p style="margin-top:0pt; margin-bottom:8pt; line-height:108%; font-size:11pt">
				<ins style="-aw-revision-author:'msegura'; -aw-revision-datetime:'2018-01-11T03:03:00'"><span style="font-family:Calibri">beginning</span></ins>
			</p>
			<p style="margin-top:0pt; margin-bottom:8pt; line-height:108%; font-size:11pt">
				<span style="font-family:Calibri">Hello</span>
			</p>
			<p style="margin-top:0pt; margin-bottom:8pt; line-height:108%; font-size:11pt">
				<ins style="-aw-revision-author:'msegura'; -aw-revision-datetime:'2018-01-11T03:03:00'"><span style="font-family:Calibri">end</span></ins><ins style="-aw-revision-author:'Bobby'; -aw-revision-datetime:'2018-01-11T04:48:00'"><span style="font-family:Calibri"> </span></ins><span style="font-family:Calibri">beginning</span>
			</p>
			<p style="margin-top:0pt; margin-bottom:8pt; line-height:108%; font-size:11pt">
				<span style="font-family:Calibri">&#xa0;</span>
			</p>
		</div>
	</body>
</html>
-------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 14.697 s
[INFO] Finished at: 2018-01-12T15:14:36+01:00
[INFO] Final Memory: 27M/345M
[INFO] ------------------------------------------------------------------------

```
