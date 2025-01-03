import socket

s = socket.socket() # next create a socket object
print("Socket succesfully created")

port = 12345 # reserve port 12345 (but it can be any port)

# next bind to the port
# we have not typed any ip to the field
# instead we have inputted an empty string
# this makes the server listen to requests
# coming from other computers on the network
s.bind(('',port))
print("socket binded to %s" %(port))

s.listen(5) # put the socket into listening mode
print ("socket is listening")

while True:
    c, addr = s.accept() # establish connection with clietn
    print("Got connection from ", addr)
    c.send("Thanks for connection".encode()) # encode into bytes
    c.close() # close the connection with the client
    break # leaving the loop, once the connection is closed
