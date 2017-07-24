import de.vandermeer.asciitable.AsciiTable;
/**
 * @author grace
 *
 */
public class TableToasciitableDemo {
	public static void printAsciiTable() {
			
		AsciiTable at = new AsciiTable();
		at.getContext().setWidth(30);
		at.addRule();
		at.addRow("row 1 col 1", "row 1 col 2");
		String[] array = new String[2];
		array[0] = "row 1 col 1";
		array[1] = "row 1 col 1";
		at.addRow("row 1 col 1", "row 2 col 2");
		//When reading elements from other methods
		Object[] rowObject = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			rowObject[i] = array[i];
		}
		at.addRow(rowObject);
//		at.addRow(new Object[]{array[0],array[0]});
		at.addRule();
		at.addRow("row 2 col 1row 2 col 1row 2 col 1row 2 col 1row 2 col 1", "row 2 col 2");
		at.addRule();
		String res = at.render();
		System.out.println(res);
	}
	public static void main(String args[]) {
		TableToasciitableDemo.printAsciiTable();
	}
}

//<dependency>
//   <groupId>de.vandermeer</groupId>
//   <artifactId>asciitable</artifactId>
//   <version>0.3.2</version>
//</dependency>

//doc: http://www.vandermeer.de/projects/skb/java/asciitable/examples/AT_00b_Width_Behavior.html
