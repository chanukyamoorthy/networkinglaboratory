# python3
import socket
#sender of half duplex

def chunkstring(string, length):
	return (string[0+i:length+i] for i in range(0, len(string), length))

ip='127.0.0.1'
port = 5001
pos = 0
s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
windowSize=4

while(True):
    print('Enter data')
    inputString=input()
    
    stringList=list(chunkstring(inputString,windowSize-1))
    l=len(stringList)
    
    for i in range(0,l):
        pos = pos+1
        x=str(pos)+stringList[i]
        s.sendto(x.encode(),(ip,port))

s.close()
