import socket

s = socket.socket() # create a socket object

port = 12345 # same ip port to connect to

# connect to the server on local computer
s.connect(('127.0.0.1', port))

# receive data from the server and decode it to get as string
print(s.recv(1024).decode())

s.close() # close the connection