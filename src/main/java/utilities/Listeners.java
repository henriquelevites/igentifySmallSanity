package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class Listeners extends CommonOpps implements ITestListener
{
    public void onStart(ITestContext execution)
    {
        System.out.println("\n---------- Starting execution ----------");
    }

    public void onFinish(ITestContext execution)
    {
        System.out.println("\n---------- Execution ended ----------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("\n---------- Starting test: " + test.getName() + " ----------");
    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("\n---------- Skipping test: " + test.getName() + " ----------");
    }

    public void onTestSuccess(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Passed ----------");
        if (!platform.equalsIgnoreCase("api"))
        {
            // Stop Recording
            try
            {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new  File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Failed to delete the file");
            }
        }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Failed ------------");
        if (!platform.equalsIgnoreCase("api"))
        {
            // Stop Recording
            try
            {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test)
    {
        System.out.println("---------- Test: " + test.getName() + " Failed with Success % ----------");
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        if (!platform.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
