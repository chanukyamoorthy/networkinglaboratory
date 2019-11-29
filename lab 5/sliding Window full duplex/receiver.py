# python3
#receiver of full duplex protocol
import socket
import time

ip='127.0.0.1'
port = 5003

senderSocket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
receiverSocket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

receiverSocket.bind((ip,5003))

while True:
    data, addr = receiverSocket.recvfrom(1024)
    p=data.decode()
    print(p[1:])
    msg ="ack"+p[0]
    senderSocket.sendto(msg.encode(),(ip,5004))
		
senderSocket.close()
receiverSocket.close()
