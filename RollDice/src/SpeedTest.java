import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class SpeedTest {

	public static void main(String[] args) throws IOException {
		
		String theStr = "How much wood would a woodchuck chuck if a woodchuck could chuck wood? He would chuck as much wood as a woodchuck would if a woodchuck could chuck wood";
		Date dStartTime;
		Date dEndTime;
		long time;
		
		System.out.println("Type the following paragraph as fast as you can: " + theStr);
		System.out.print("When you are ready, press enter, type the lines, and press enter again");
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        reader.readLine();
        dStartTime = new Date();
        String userStr = reader.readLine();
        dEndTime = new Date();
        time = dEndTime.getTime() - dStartTime.getTime();
        
        if(!userStr.equals(theStr)) {
			System.out.println("Does not match. Time taken: " + time + "ms");
		} else {
			System.out.println("Perfect match. Time taken: " + time + "ms");
		}
    }

}
