package zisko.multicastor.program.mmrp;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.jnetpcap.Pcap;

/**
 * 
 * The PacketHandler sends packets through the network device
 */
public class PacketHandler {
	/**
	 * 
	 * @param deviceMACAddress is the MAC address of the network device
	 * @param packet is the packet which should be send
	 * @throws IOException if the hardware device was not found
	 */
	
	public static void sendPacket(byte[] deviceMACAddress, byte[] packet) throws IOException{
		Pcap pcap = PcapHandler.getPcapInstance(deviceMACAddress);
		ByteBuffer b = ByteBuffer.wrap(packet);
		if (pcap.sendPacket(b) != Pcap.OK) {
			System.err.println(pcap.getErr());
		}
		pcap.close();
	}
}
