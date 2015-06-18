import java.io.*;
/*
 * the class to save result as csv file
 */
public class outputCSV {

	private String filename; //name of the csv file

	//get the name of the file
	public void csvName() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Please type in the name of the csv flie:");
		try {
			filename = buffer.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	//the function to put the result to a csv file
	public void generateCSV(numList l) {
		File file = new File("E:\\altruism results/" + filename + ".csv"); //the storage path of the csv file
		try {
			if (file.exists() == false) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("altruism,selfish\r\n");
			for (int i = 0; i < numList.TIME; i++) {
				writer.write(l.aList[i] + ",");
				writer.write(l.sList[i] + "\r\n");
			}

			writer.flush();
			writer.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
