import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Processor {

	static List<File> allFiles = new ArrayList<>();

	public static void main(String[] Args) {
		try {
			
			buildAllFiles("C:\\Users\\Will\\Desktop\\testDir");

			printAllFiles();

			deleteFilesEndingWith(".ppt");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printAllFiles() {
		for (File j : allFiles) {
			System.out.println(j);
		}
	}

	private static void buildAllFiles(String dir) {
		File folder = new File(dir);
		if (folder.exists() && folder.isDirectory()) {
			File arr[] = folder.listFiles();
			recursivePrint(arr, 0, 0);
		}
	}

	public static void deleteFilesEndingWith(String end) {
		for (File i : allFiles) {
			String fileName = i.getName();
			if (fileName.endsWith(end)) {
				i.delete();
			}
		}
	}

	public static void recursivePrint(File[] arr, int index, int level) {

		if (index == arr.length) {
			return;
		}

		for (int i = 0; i < level; i++) {
			System.out.print("\t");
		}

		if (arr[index].isFile()) {

			System.out.println(arr[index].getName());
			allFiles.add(arr[index]);

		} else if (arr[index].isDirectory()) {
			System.out.println("[" + arr[index].getName() + "]");
			recursivePrint(arr[index].listFiles(), 0, level + 1);
		}

		recursivePrint(arr, ++index, level);

	}

}