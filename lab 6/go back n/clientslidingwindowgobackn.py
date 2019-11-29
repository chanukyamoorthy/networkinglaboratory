import os
from socket import *
import time


host = "127.0.0.1"
port = 8080

addr = (host, port)
UDPSock = socket(AF_INET, SOCK_DGRAM)

frame_size = 5
cnt = 0
eff = 0
frames = []

for i in range(0,50,5):
    frames = [x for x in range(i,i+frame_size)]      
    data = str(frames)
    xor = 0
    for i in frames:
          xor = xor^i
    print("data : "+data)
    print("checksum : "+str(xor))
    data = data+"$"+str(xor)
    t0 = time.time()
    UDPSock.sendto(data.encode(), addr)
    tt = time.time()-t0
    ack,addr = UDPSock.recvfrom(2048)
    if ack == " ":
          i = i-5
          continue
    else : 
          print(ack)
    pd = time.time()-tt-t0
    eta = tt/(tt+2*pd)
    if i == 0:
         eff = eta
    if eff<eta:
         eff = eta
         
print("Efficiency : "+str((1-eff)*100))
UDPSock.close()
os._exit(0)







