package ai;

import java.util.ArrayList;

import GameObjects.GameObject;
import core.TileManager;
import core.Window;

public class Pathfinder {
	Window window;
	Node[][] node;
	ArrayList<Node> openList=new ArrayList<Node>();
	public ArrayList<Node> pathList=new ArrayList<>();
    Node startNode,goalNode,currentNode;
    boolean goalReached=false;
    int step=0;
    
    public Pathfinder(Window window) {
    	this.window=window;
    	instantiateNodes();
    }

	private void instantiateNodes() {
	
		node=new Node[Window.maxScreenCol][Window.maxScreenRow];
		
		int col=0;
		int row=0;
		while(col<Window.maxScreenCol && row<window.maxScreenRow) {
			node[col][row]=new Node(col,row);
		    	col++;
			if(col==Window.maxScreenCol) {
				col=0;
				row++;
			}
		}	
	}
	
	public void resetNodes() {
		int col=0;
		int row=0;
		while(col<Window.maxScreenCol &&row<window.maxScreenRow) {
		node[col][row].open=false;	
		node[col][row].checked=false;
		node[col][row].solid=false;	
	
		col++;
		if(col==Window.maxScreenCol) {
			col=0;
			row++;
		}	
		}	
		
		openList.clear();
		pathList.clear();
		goalReached=false;
		step=0;
	}
	
	public void setNode(int startCol,int startRow,int goalCol,int goalRow,GameObject entity) {
		resetNodes();
		
		startNode=node[startCol][startRow];
		currentNode=startNode;
		goalNode=node[goalCol][goalRow];
		openList.add(currentNode);
		
//		int col=0;
//		int row=0;
//		while(col<Window.maxScreenCol && row < Window.maxScreenRow) {
//			int tileNum=TileManager.map[col][row];
//			if(tileNum==1) {
//				node[col][row].solid=true;
//			}
//			
//			//interactable
//			//for (int i =0;i< )
//           
//			getCost(node[col][row]);
//			
//			col++;
//			if(col==Window.maxScreenCol) {
//				col=0;
//				row++;
//			}
//	
//		}
//		
		for(int col=0;col<Window.maxScreenCol;col++) {
			for(int row=0;row<Window.maxScreenRow;row++) {
				int tileNum=TileManager.map[col][row];
				if(tileNum==1) {
					node[col][row].solid=true;
				}
				
				//interactable
				//for (int i =0;i< )
	           
				getCost(node[col][row]);
				
//				col++;
//				if(col==Window.maxScreenCol) {
//					col=0;
//					row++;
//				}
			}	
		}
		
	}

	private void getCost(Node node) {
		//Gcost
		int xDistance=Math.abs(node.col-startNode.col);
		int yDistance=Math.abs(node.row-startNode.row);
		node.gCost=xDistance+yDistance;
		
		//Hcost
		 xDistance=Math.abs(node.col-goalNode.col);
		 yDistance=Math.abs(node.row-goalNode.row);
		node.hCost=xDistance+yDistance;
		
		//Fcost
		node.fCost=node.gCost+node.hCost;
	}
	public boolean search() {
		while(goalReached==false && step<500) {
			
			int col =currentNode.col;
			int row=currentNode.row;
			
			currentNode.checked=true;
			openList.remove(currentNode);
			
			if(row-1 >=0) {
				openNode(node[col][row-1]);
			}
			if(col-1 >=0) {
				openNode(node[col-1][row]);				
			}
			if(row+1<Window.maxScreenRow) {
				openNode(node[col][row+1]);
			}
			
			if(col+1<Window.maxScreenCol) {
				openNode(node[col+1][row]);
			}
			
			
			int bestNodeIndex=0;
			int bestNodefCost=0;
			
			for(int i=0;i<openList.size();i++) {
				if(openList.get(i).fCost<bestNodefCost) {
					bestNodeIndex=i;
					bestNodefCost=openList.get(i).fCost;
				}
				
				else if(openList.get(i).fCost==bestNodefCost) {
					if(openList.get(i).gCost<openList.get(bestNodeIndex).gCost) {
						bestNodeIndex=i;
					}
				}
			}
			
			if(openList.size()==0) {
				break;
			}
			
			currentNode=openList.get(bestNodeIndex);
			
			if(currentNode==goalNode) {
				goalReached=true;
				trackThePath();
			}
			step++;
		}
		return goalReached;
	}

	private void trackThePath() {
		Node current=goalNode;
		while(current!=startNode) {
			pathList.add(0,current);
			current=current.parent;
		}
	}

	private void openNode(Node node) {
		if(node.open==false&&node.checked==false&&node.solid==false) {
			
			node.open=true;
			node.parent=currentNode;
			openList.add(node);
		}
	}
}
