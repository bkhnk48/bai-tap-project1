package network.layers;

import infrastructure.entity.Node;
import network.elements.*;
import network.entities.*;
import simulator.DiscreteEventSimulator;

import java.util.HashMap;

public class PhysicalLayer extends Layer {

	public HashMap<Integer, ExitBuffer> exitBuffers;
	public HashMap<Integer, EntranceBuffer> entranceBuffers;
	public SourceQueue sourceQueue;
	public HashMap<Integer, Link> links;
	public DiscreteEventSimulator simulator;
	public Node node;
	
	public PhysicalLayer(Host host) {
		if (host.type == TypeOfHost.Source || host.type == TypeOfHost.Mix) {
			entranceBuffers = null;
			exitBuffers = new HashMap<>();
			sourceQueue = new SourceQueue(host.getId());
			sourceQueue.physicalLayer = this;
			this.node = host;
			this.links = new HashMap<>();
		}
		if (host.type == TypeOfHost.Destination || host.type == TypeOfHost.Mix) {
			this.node = host;
			this.links = new HashMap<>();
		}
	}	

	public PhysicalLayer(Switch sw, int k) {
		entranceBuffers = new HashMap<>();
		exitBuffers = new HashMap<>();
		this.node = sw;
		this.links = new HashMap<>();
	}

}
