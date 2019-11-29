import os
from socket imp
ort *
host = "127.0.0.1"
port = 8080

addr = (host, port)
UDPSock = socket(AF_INET, SOCK_DGRAM)

while True:
    data = raw_input("Enter message or type 'exit': ")
    UDPSock.sendto(data, addr)
    if data == "quit":
        break

UDPSock.close()
os._exit(0)







