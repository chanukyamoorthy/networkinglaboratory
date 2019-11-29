# python3
#receiver of half duplex
import socket
import time
#ip = "192.168.43.56" #@ Ritesh

ip='127.0.0.1'
port = 5001

s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
s.bind((ip,port))
print("receivng messages !!!")
while True:
	data, addr = s.recvfrom(1024)
	p=data.decode()
	print(p)
		
s.close()
