# python3
#sender of sliding window full duplex!!!
import socket


def chunkstring(string, length):
	return (string[0+i:length+i] for i in range(0, len(string), length))

ip='127.0.0.1'
port = 5003
windowSize=5
pos=-1

senderSocket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
receiverSocket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
receiverSocket.bind((ip,5004))

print('Enter data')

while(True):
    inputString=input()
    stringList=list(chunkstring(inputString,windowSize))
    l=len(stringList)
    for i in range(0,l):
        pos=pos+1
        pos=pos%4
        x=str(pos)+stringList[i]
        senderSocket.sendto(x.encode(),(ip,5003))
        data, addr = receiverSocket.recvfrom(1024)
        print(data.decode())

    

senderSocket.close()
receiverSocket.close()
