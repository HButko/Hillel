package lessons.lessonTwo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DownloadTest {
    @Test
    public void downloadTest() {
        open("https://the-internet.herokuapp.com/download");

        File file = $$("a").find(exactText("LambdaTest.txt")).download();

        assertThat(file).hasExtension("txt");
    }

    @Test
    public void downloadToFolder() {
        Configuration.downloadsFolder = "target/downloads";
//        Configuration.fileDownload = FileDownloadMode.FOLDER;
        //different option to specify download folder

        open("https://testpages.eviltester.com/styled/download/download-via-js.html");

        File download = $("#server-fetch-data-object")
                .download(DownloadOptions.using(FOLDER));

        assertThat(download.getName()).startsWith("textfile").endsWith(".txt");
    }
}
