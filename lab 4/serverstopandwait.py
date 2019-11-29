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
    print "Received message: " + data
    if data :
        x = "Acknowledged"
    UDPSock.sendto(x,addr)

UDPSock.close()
os._exit(0)
