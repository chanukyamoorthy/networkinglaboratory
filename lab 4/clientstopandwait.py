import os
from socket import *
import time


host = "127.0.0.1"
port = 8081

addr = (host, port)
UDPSock = socket(AF_INET, SOCK_DGRAM)

for i in range(0,50):
    data = str(i+1)
    t0 = time.time()
    UDPSock.sendto(data, addr)
    tt = time.time()-t0
    ack,addr = UDPSock.recvfrom(2048)
    if ack == " ":
          i = i-1
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







