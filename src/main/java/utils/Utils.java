package utils;

import drivers.strategies.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class Utils {

    public static String decode64(String encodedStr){
        Base64.Decoder decoder= Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static boolean takeScreenshot() {
        File file= ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File(Constants.SCREENSHOT_FOLDER+generaterandomString(Constants.SCREENSHOT_NAME_LENGHT)+Constants.SCREENSHOT_EXTENSION));
            return true;
        } catch (IOException e) {
           return false;
        }

    }

    private static String generaterandomString(int length){
        String seedChards =Constants.ALPHABET;
        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for(int i=0;i<length;i++){
            sb.append(seedChards.charAt(random.nextInt(seedChards.length())));
        }
        return sb.toString();
    }
}
