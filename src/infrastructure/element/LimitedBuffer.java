package infrastructure.element;

import infrastructure.entity.Node;
import network.elements.Packet;

public abstract class LimitedBuffer extends Buffer {
	
	protected Node node;
	protected Node connectNode;
	protected int size;


	public Node getConnectNode() {
		return connectNode;
	}

	public Node getNode() {
		return node;
	}

	/**
	 * Phuong thuc insertPacket se lam nhiem vu chen goi tin p 
	 * vao trong bo dem cua no
	 * @param p la goi tin can chen vao
	 * @return true neu nhu chen duoc goi tin
	 *         false neu nhu KHONG chen duoc goi tin vao (tuc bo dem da day)
	 */
	public void insertPacket(Packet p) {
		if (allPackets.size() > size) {
			System.out.println("ERROR: Buffer: " + this.toString() + " oversized");
		}
			
		allPackets.enqueue(p);
	}
	
	public Packet removePacket() {
		if (allPackets.isEmpty()) return null;
		return allPackets.dequeue();
	}
	
	public boolean isFull() {
		if (allPackets.size() > size)
			System.out.println("ERROR: Buffer: " + this.toString() + " oversized");
		return allPackets.size() == size;
	}

	public int getNumOfPacket() {
		if (allPackets.size() > size) {
			System.out.println("ERROR: Buffer: " + this.toString() + " oversized");
		}
			
		return allPackets.size();
	}

	public boolean canAddPacket() {
		return allPackets.size() < size ;
	}
}
