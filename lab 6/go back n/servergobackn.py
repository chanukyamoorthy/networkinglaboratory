import os
from socket import *
import time

host = ""
port = 8081
buf = 1234

addr = (host, port)
UDPSock = socket(AF_INET, SOCK_DGRAM)
UDPSock.bind(addr)

print "Waiting to receive messages..."

while True:
    (data, addr) = UDPSock.recvfrom(buf)
    data = data.decode()
    for i in range(0,len(data)):
           if data[i] == '$':
                   break
    checksum = data[i+1:len(data)]
    print("received sum : "+checksum)
    data = data[0:i]
    rec_checksum = 0
    print ("Received message: " + data)
    for i in range(0,len(data)):
            rec_checksum = rec_checksum^int(ord(data[i]))
    print("calculated check sum : "+str(rec_checksum))
    
    if checksum == str(rec_checksum) :
        x = "Acknowledged"
    UDPSock.sendto(x,addr)

UDPSock.close()
os._exit(0)
