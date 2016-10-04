package exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UseGraph {

	/**
	 * @param args
	 * @throws VertexExistsException
	 * @throws GraphIsFullException
	 */

	// Please complete the code for the following method.
	// A correctly working method gets up to 5 marks
	// A quality implementation gets up to 3 marks
	static Graph<String> loadGraph(String pathName)
			throws FileNotFoundException, GraphIsFullException,
			VertexExistsException
	// Loads a String graph from a text file formatted as follows:
	// N: some number -> max number of vertices
	// V: vertexname -> at most N lines for this format
	// E: vertex1, vertex2 -> each line gives an edge from vertex1 to vertex2
	// (vertex1, vertex2 must be strings)
	// Example:
	// N: 5
	// V: A
	// V: B
	// V: C
	// V: D
	// E: A,B
	// E: A,C
	// E: C,D
	// The loadGraph must create the following graph:
	//
	// A --- B
	// |
	// |
	// C --- D
	//
	// If the text file is empty or contains at least the N: ... line, the graph
	// must be empty (not null!)
	//
	{
		// Your code goes here
		Scanner file = new Scanner(new File(pathName));
		Graph<String> graph;
		String line = file.nextLine();
		String[] lineData = line.split(": ");
		graph = new Graph<String>(Integer.parseInt(lineData[1]));
		//create Graph with its max number of vertex
		while(file.hasNextLine()){
			String line_ = file.nextLine();
			String[] lineData_ = line_.split(": ");
			if(lineData_[0].equals("V")){
				graph.addVertex(lineData_[1]);
				}//add vertex
			else if(lineData_[0].equals("E")){
				String[] vertexData = lineData_[1].split(",");
				graph.addEdge(vertexData[0], vertexData[1]);
				
			}// add Edge
	
		}
		file.close();
		return graph;
	}

	public static void main(String[] args) throws FileNotFoundException,
			GraphIsFullException, VertexExistsException {
		// TODO Auto-generated method stub
		String pathname = args[0];
		Graph<String> g1 = loadGraph(pathname);
		System.out.println(g1.connectedComponents());
	}

}
