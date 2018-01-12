package debug.aspose;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.aspose.words.Document;
import com.aspose.words.HtmlSaveOptions;
import com.aspose.words.License;
import com.aspose.words.LoadFormat;
import com.aspose.words.LoadOptions;
import com.aspose.words.NodeType;
import com.aspose.words.Revision;
import com.aspose.words.Run;
import com.aspose.words.SaveFormat;
import com.aspose.words.TxtSaveOptions;

public class App {
	private static void initLicense(final String[] args) throws Exception {
		final License license = new License();
		if (args.length == 1) {
			license.setLicense(args[0].trim());
		} else {
			license.setLicense("/tmp/Aspose.Words.lic");
		}
		System.out.println("License set successfully.");
	}

	private static byte[] getWordData() throws IOException {
		final String file;
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter word file path: ");
		file = reader.readLine();
		return Files.readAllBytes(Paths.get(file.trim()));
	}

	private static void showAsposeWordTrackChanges(final byte[] data) throws Exception {
		final String[] revisionTypes = {
		        "INSERTION",
		        "DELETION",
		        "FORMAT_CHANGE",
		        "STYLE_DEFINITION_CHANGE",
		        "MOVING"
		};
		final LoadOptions loadOptions = new LoadOptions();
		loadOptions.setLoadFormat(LoadFormat.AUTO);
		loadOptions.setEncoding(StandardCharsets.UTF_8);
		final Document document = new Document(new ByteArrayInputStream(data), loadOptions);
		for (final Revision revision : document.getRevisions()) {
			System.out.println("Word track change ------------------------------------------");
			// STYLE_DEFINITION_CHANGE does not have an associated run
			if (revision.getParentNode().getNodeType() == NodeType.RUN) {
				final Run run = (Run) revision.getParentNode();
				System.out.println("revision has an associated run " +
				                   " run.getText()=" + run.getText() +
				                   " run.isInsertRevision()=" + run.isInsertRevision() +
				                   " run.isDeleteRevision=" + run.isDeleteRevision() +
				                   " run.isFormatRevision=" + run.isFormatRevision());
			}
			if (revision.getRevisionType() >= 0 && revision.getRevisionType() < revisionTypes.length) {
				System.out.print("revision type=" + revisionTypes[revision.getRevisionType()]);
			} else {
				System.out.print("revision type=" + revision.getRevisionType());
			}
			System.out.println(" revision.getAuthor()=" + revision.getAuthor() +
			                   " revision.getDateTime()=" + revision.getDateTime());
			System.out.println("------------------------------------------");
		}
	}

	private static void showWordAsText(final byte[] data) throws Exception {
		final LoadOptions loadOptions = new LoadOptions();
		loadOptions.setLoadFormat(LoadFormat.AUTO);
		loadOptions.setEncoding(StandardCharsets.UTF_8);
		final Document document = new Document(new ByteArrayInputStream(data), loadOptions);
		document.acceptAllRevisions();
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		document.save(bos, new TxtSaveOptions());
		System.out.println("------- aspose view of the content as a text file ------------------");
		System.out.println(bos.toString());
		System.out.println("-------------------------");
	}

	private static void showAsposeHtml(final byte[] data) throws Exception {
		final LoadOptions loadOptions = new LoadOptions();
		loadOptions.setLoadFormat(LoadFormat.AUTO);
		loadOptions.setEncoding(StandardCharsets.UTF_8);
		final Document document = new Document(new ByteArrayInputStream(data), loadOptions);
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final HtmlSaveOptions saveOptions = new HtmlSaveOptions(SaveFormat.HTML);
		saveOptions.setPrettyFormat(true);
		document.save(bos, saveOptions);
		System.out.println("------- aspose view of the content as a html file ------------------");
		System.out.println(bos.toString());
		System.out.println("-------------------------");
	}

	public static void main(final String[] args) throws Exception {
		initLicense(args);
		final byte[] data = getWordData();
		showAsposeWordTrackChanges(data);
		showWordAsText(data);
		showAsposeHtml(data);
	}
}
